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

    <script type="text/javascript">

        // 初始化页面
        $(document).ready(function () {
            if (self !== top) {
                $(".home").hide();
            }
        });

    </script>

</head>
<body>
<div class="alarm-area">
    <div class="alarm-tip-box warning f0">
        <span>出现错误<c:if test="${exceptionCode != null && exceptionCode != ''}"><b
                class="red">(错误码：${exceptionCode})，</b></c:if>：</span><span><b class="red">${exceptionDesc}</b>，请联系管理员。</span>
    </div>
    <div class="alarm-opt-box">
        <span class="home"
              onclick="_home();">返回首页</span>
        <span class="goback s10"
              onclick="_historyBack();">返回上一页</span>
    </div>
</div>
</body>
</html>

