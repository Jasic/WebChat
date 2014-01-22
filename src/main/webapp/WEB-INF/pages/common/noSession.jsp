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

    <script language="javascript"
            src="${_jsPath}/jquery.min.js"></script>
    <script language="javascript"
            src="${_jsPath}/jquery.common.js"></script>
    <script language="javascript"
            src="${_jsPath}/jquery.timers.js"></script>

    <script type="text/javascript">

        $(document).ready(function () {
            if (self == top) {
                $(".alarm-area").show();

                $('body').everyTime(1000, 'goto', function () {
                    if ($("#timeLeft").html() == "1") {
                        top.window.location.href = '${_webPath}';
                    } else {
                        $("#timeLeft").html($("#timeLeft").html() - 1);
                    }
                }, $("#timeLeft").html());

            } else {
                // 弹出登录框
                top.relogin($("#lastVisitURL").val(), $("#lastVisitMethod").val());
            }
        });

    </script>

</head>
<body>
<div class="alarm-area dn">
    <input type="hidden"
           id="lastVisitURL"
           value="${lastVisitURL}"/>
    <input type="hidden"
           id="lastVisitMethod"
           value="${lastVisitMethod}"/>

    <div class="alarm-tip-box nologin">您还没有登录，请先登录，<label id='timeLeft'>5</label> 秒后自动跳转</div>
    <div class="alarm-opt-box">
        <span class="home"
              onclick="_home();">立刻登录</span>
    </div>
</div>
</body>
</html>

