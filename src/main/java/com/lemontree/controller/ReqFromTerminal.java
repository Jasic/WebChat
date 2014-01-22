package com.lemontree.controller;

import cn.tisson.framework.utils.StringUtils;
import com.lemontree.daemon.domm.cmd.BaseCmd;
import com.lemontree.daemon.domm.cmd.Command;
import com.lemontree.daemon.domm.reslt.BaseReslt;
import com.lemontree.daemon.process.Processor;
import com.lemontree.util.HttpValidateUtil;
import com.lemontree.util.JsonUtils;
import org.jasic.util.ExceptionUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static com.lemontree.common.GlobalConstants.HANDLE_CMD_HTTP_REQUEST_ERROR;
import static com.lemontree.common.GlobalConstants.HANDLE_CMD_NOT_COMPLETED;
import static com.lemontree.common.GlobalVariables.DAEMON_HANDLE_CMD_CODE_MAP;

/**
 * User: Jasic
 * Date: 14-1-2
 * <p/>
 * 处理从后端发送过来的命令、上传文件的总入口
 */
@Controller("reqFromTerminal")
@RequestMapping(value = "/terminal")
//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ReqFromTerminal {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(ReqFromTerminal.class);

    @Autowired
    private Processor processor;

    /**
     * @return
     */
    @RequestMapping(value = "/cmd", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    BaseReslt _handleCmd(HttpEntity<String> entity) {

        BaseReslt reslt = new BaseReslt();
        HttpHeaders headers = entity.getHeaders();
        if (!HttpValidateUtil.valiateJsonHeader(headers)) {
            reslt = new BaseReslt();
            reslt.setCode(HANDLE_CMD_HTTP_REQUEST_ERROR);
            String detail = DAEMON_HANDLE_CMD_CODE_MAP.get(HANDLE_CMD_HTTP_REQUEST_ERROR) + "不符合Json请求令规范";
            reslt.setDetail(detail);
            logger.error(detail);
        } else {
            String json = entity.getBody();
            try {
                BaseCmd cmd = JsonUtils.parseToObject(json, BaseCmd.class);
                Command ct = cmd.getCmd();
                // 命令字段不能为空
                if (ct != null && !StringUtils.isEmpty(ct.getExplain())) {
                    cmd.setJsonStr(json);
                    reslt = processor.process(cmd);
                } else {
                    reslt.setCode(HANDLE_CMD_NOT_COMPLETED);
                    reslt.setDetail(DAEMON_HANDLE_CMD_CODE_MAP.get(HANDLE_CMD_NOT_COMPLETED));
                }
            } catch (Exception e) {
                logger.error(ExceptionUtil.getStackTrace(e));
                reslt.setCode(HANDLE_CMD_HTTP_REQUEST_ERROR);
                reslt.setDetail(DAEMON_HANDLE_CMD_CODE_MAP.get(HANDLE_CMD_HTTP_REQUEST_ERROR));
            }
        }
        return reslt;
    }


    /**
     * @return
     */
    @RequestMapping(value = "/upload", method = {RequestMethod.POST})
    public
    @ResponseBody
    String _handleUpload(HttpServletRequest request) {


        return "";
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }
}
