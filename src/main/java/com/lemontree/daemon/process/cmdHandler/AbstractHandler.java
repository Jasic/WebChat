package com.lemontree.daemon.process.cmdHandler;

import com.lemontree.common.LogicHelper;
import com.lemontree.daemon.domm.cmd.Account;
import com.lemontree.daemon.domm.cmd.BaseCmd;
import com.lemontree.daemon.domm.reslt.BaseReslt;
import com.lemontree.service.Status;
import com.lemontree.daemon.process.Administrator;
import com.lemontree.service.CheckAuthService;
import org.jasic.util.Asserter;
import org.jasic.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.lemontree.common.GlobalConstants.HANDLE_CMD_ERROR;
import static com.lemontree.common.GlobalConstants.HANDLE_CMD_LOGIN_ERROR;
import static com.lemontree.common.GlobalVariables.DAEMON_HANDLE_CMD_CODE_MAP;
import static com.lemontree.service.Status.ProcessStatus;

/**
 * Author Jasic
 * Date 13
 * 处理命令的抽象爹类
 */
@Component
public abstract class AbstractHandler<C extends BaseCmd> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractHandler.class);

    protected final ThreadLocal<Administrator> adminThreadLocal = new ThreadLocal<Administrator>();

    @Autowired
    private CheckAuthService checkAuthService;

    /**
     * 抽象方法，各实际处理方法各处具体实现
     *
     * @param cmd
     */
    protected abstract BaseReslt doHandle(C cmd);

    /**
     * 过滤作用
     *
     * @param cmd
     * @return
     */
    private ProcessStatus beforeHandle(C cmd) {

        ProcessStatus ps;
        Account account = cmd.getAccount();


        if (account != null) {
            ps = checkAuthService.checkAuth(account, adminThreadLocal);

        } else {
            ps = new ProcessStatus();
            ps.setStatus(Status.EXECUTE_CMD_FAIL_CODE);
            ps.setReason("Login account is null, please check it!");
        }

        return ps;

    }

    /**
     * 后置处理
     *
     * @param reslt
     */
    private void afterHandle(BaseReslt reslt) {

        // TODO 验证结果的正确性
        Asserter.notNull(reslt);
        Asserter.notNull(reslt.getCode());
        Asserter.notNull(reslt.getDetail());

    }


    /**
     * 基本是用于给外部调用
     *
     * @param cmd
     */
    public BaseReslt handle(C cmd) {


        BaseReslt r = null;

        try {
            ProcessStatus ps = beforeHandle(cmd);
            Integer status = ps.getStatus();
            switch (status) {

                /**
                 * 验证成功
                 */
                case Status.EXECUTE_CMD_SUCCESS_CODE: {
                    r = doHandle(cmd);
                    break;
                }
                /**
                 * 验证失败
                 */
                case Status.EXECUTE_CMD_FAIL_CODE: {
                    r = new BaseReslt();
                    r.setCode(HANDLE_CMD_LOGIN_ERROR);
                    r.setDetail(DAEMON_HANDLE_CMD_CODE_MAP.get(HANDLE_CMD_LOGIN_ERROR) + ":" + ps.getReason());
                    break;
                }
            }
            afterHandle(r);
        } catch (Exception e) {

            r = new BaseReslt();
            r.setCode(HANDLE_CMD_ERROR);
            String detail = (DAEMON_HANDLE_CMD_CODE_MAP.get(HANDLE_CMD_ERROR));
            detail = LogicHelper.getTerminalProcessDetail(detail, e);

            r.setDetail(detail);

            logger.error(ExceptionUtil.getStackTrace(e));
        }
        return r;
    }

    public void setCheckAuthService(CheckAuthService checkAuthService) {
        this.checkAuthService = checkAuthService;
    }
}
