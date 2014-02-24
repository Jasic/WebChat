<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"
           uri="http://java.sun.com/jsp/jstl/functions" %>


<% String pa = request.getContextPath();
    String baPa = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + pa;
    String rePa = "/resource";
    String _cssPath = baPa + rePa + "/css";
    String _restaurantPath = baPa + rePa + "/restaurant";
    String _imgPath = baPa + rePa + "/img";
    String _jspPath = baPa + rePa + "/js";%>
<c:set var="basePath"
       value="<%=baPa%>"></c:set>
<c:set var="path"
       value="<%=pa%>"></c:set>

<c:set var="_cssPath"
       value="<%=_cssPath%>"></c:set>
<c:set var="_jsPath"
       value="<%=_jspPath%>"></c:set>
<c:set var="_imgPath"
       value="<%=_imgPath%>"></c:set>
<c:set var="_restaurantPath"
       value="<%=_restaurantPath%>"></c:set>
