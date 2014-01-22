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

</head>
<body>
<div class="alarm-area">
    <div class="alarm-tip-box prohibit">你没有权限访问此页面，如有疑问，请联系管理员。</div>
    <div class="alarm-opt-box">
        <span class="home"
              onclick="_home();">返回首页</span><span class="goback"
                                                  onclick="_goback();">返回上页</span>
    </div>
</div>
</body>
</html>

