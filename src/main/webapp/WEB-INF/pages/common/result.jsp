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
<div class="result-area">
    <div class="result-tip-box">${optName}成功，请选择下一步操作</div>
    <div class="result-opt-box f0">
        <button onclick="_gotoURL('${continueURL}');">继续${optName}</button>
        <button class="s10"
                onclick="_gotoURL('${listURL}');">返回列表
        </button>
    </div>
</div>
</body>
</html>

