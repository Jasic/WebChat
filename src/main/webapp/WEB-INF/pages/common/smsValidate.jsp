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
                title: "手机验证",
                btnclose: false
            });

            // 退出按钮
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

        <div class="blue">手机验证码已经发送到您在电子推送平台设置的联系手机上，请填写手机中的6位验证码</div>
        <div class="blue">此验证码在30分钟内有效，如没有收到验证码，请点击<input type="button"
                                                          class="sms-validate-button-mini"/>重新获取
        </div>
        <div class="item-wapper-sms-validate">
            <span class="item">&nbsp;&nbsp;手机号码: </span>
            <input type="text"
                   name="mobile"
                   id="mobile"/>
            <button type="button"
                    class="sms-validate-button"
                    id="refreshSmsValidateCodeBtn"
                    title="点击获取手机验证码"></button>
            <span class="red"
                  id="mobileTip"></span><br/>
            <span class="item">手机验证码: </span>
            <input type="text"
                   name="smsValidateCode"
                   id="smsValidateCode"/>
            <span class="red"
                  id="smsValidateCodeTip"></span>
        </div>
        <div class="submit-wapper-sms-validate">
            <button type="button"
                    class="default-button"
                    onclick="matchSmsValidateCode();">确认
            </button>
            <button type="button"
                    class="default-button ml10"
                    id="logoutBtn">返回
            </button>
            <span id="errInfo"
                  class="red"></span>
        </div>
    </form>
</div>
</body>
</html>
