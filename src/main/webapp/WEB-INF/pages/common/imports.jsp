<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>

<% String pa = request.getContextPath();
    String baPa = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + pa;
    String rePa = "/resource";
    String _cssPath = baPa + rePa + "/css";
    String _jspPath = baPa + rePa + "/js";%>
<c:set var="basePath"
       value="<%=baPa%>"></c:set>
<c:set var="path"
       value="<%=pa%>"></c:set>

<c:set var="_cssPath"
       value="<%=_cssPath%>"></c:set>
<c:set var="_jsPath"
       value="<%=_jspPath%>"></c:set>
