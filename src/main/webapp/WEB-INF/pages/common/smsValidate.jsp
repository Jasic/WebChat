<%@ page language="java"
         pageEncoding="GBK" %>
<%@ include file="/WEB-INF/views/common/imports.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <title>${_title}</title>

    <%@ include file="/WEB-INF/views/common/meta.jsp" %>

    <link rel="stylesheet"
          type="text/css"
          href="${_cssPath}/main.css"/>
    <link rel="stylesheet"
          type="text/css"
          href="${_cssPath}/common.css"/>
    <link rel="stylesheet"
          type="text/css"
          href="${_cssPath}/validate.css"/>

    <script language="javascript"
            src="${_jsPath}/jquery.min.js"></script>
    <script language="javascript"
            src="${_jsPath}/jquery.common.js"></script>
    <script language="javascript"
            src="${_jsPath}/jquery.zbox.js"></script>
    <script language="javascript"
            src="${_jsPath}/jquery.validate.js"></script>

    <script type="text/javascript">

        $(document).ready(function () {

            $("#smsValidate").zbox({
                title: "�ֻ���֤",
                btnclose: false
            });

            // �˳���ť
            $("#logoutBtn").click(function () {
                var url = "/" + window.location.pathname.split("/")[1] + "/logout?v=" + (new Date().getMilliseconds());
                window.location.href = url;
            });

            $("#refreshSmsValidateCodeBtn").click(function () {
                sendValidateSms();
            });

            $(document).keydown(function (event) {
                if (event.keyCode == 13) {
                    $('form').each(function () {
                        event.preventDefault();
                    });

                    matchSmsValidateCode();
                }
            });

            $("#mobile").bind("keydown",function () {
                $("#modileTip").html("");
            }).focus();

            $("#smsValidateCode").bind("keydown", function () {
                $("#smsValidateTip").html("");
                stopSmsSendWaiting();
            });

        });
    </script>

</head>
<body>
<div id="smsValidate"
     class="form-wapper-sms-validate">
    <form id="smsValidateForm">
        <input type="hidden"
               id="lastSendTime"
               value="${lastSendTime}"/>

        <div class="blue">�ֻ���֤���Ѿ����͵����ڵ�������ƽ̨���õ���ϵ�ֻ��ϣ�����д�ֻ��е�6λ��֤��</div>
        <div class="blue">����֤����30��������Ч����û���յ���֤�룬����<input type="button"
                                                          class="sms-validate-button-mini"/>���»�ȡ
        </div>
        <div class="item-wapper-sms-validate">
            <span class="item">&nbsp;&nbsp;�ֻ�����: </span>
            <input type="text"
                   name="mobile"
                   id="mobile"/>
            <button type="button"
                    class="sms-validate-button"
                    id="refreshSmsValidateCodeBtn"
                    title="�����ȡ�ֻ���֤��"></button>
            <span class="red"
                  id="mobileTip"></span><br/>
            <span class="item">�ֻ���֤��: </span>
            <input type="text"
                   name="smsValidateCode"
                   id="smsValidateCode"/>
            <span class="red"
                  id="smsValidateCodeTip"></span>
        </div>
        <div class="submit-wapper-sms-validate">
            <button type="button"
                    class="default-button"
                    onclick="matchSmsValidateCode();">ȷ��
            </button>
            <button type="button"
                    class="default-button ml10"
                    id="logoutBtn">����
            </button>
            <span id="errInfo"
                  class="red"></span>
        </div>
    </form>
</div>
</body>
</html>
