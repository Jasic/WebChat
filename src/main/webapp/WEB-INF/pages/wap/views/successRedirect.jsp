<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/common/imports.jsp" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>

<head>
    <title>${type}成功</title>
</head>
<body>
<h1 align="center">${type}成功</h1>
<h3 align="center" id="p1"><span id=timer>${seconds}</span>秒后自动跳转<a href='${redirectUrl}'>个人信息</a>页面</h3>
<script>
    function Timer(){
        var TimeSpan = document.getElementById("timer");
        TimeSpan.innerHTML = parseInt(TimeSpan.innerHTML) -1; //自动给他减1秒
        if(TimeSpan.innerHTML ==0){
            //如果是0秒了。
            location.href="${redirectUrl}";
        }
    }
    setInterval("Timer()",1000);
</script>
</body>
</html>
