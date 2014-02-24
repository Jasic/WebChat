<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%@ include file="/WEB-INF/pages/common/imports.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type"
          content="text/html; charset=utf-8"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1"/>

    <title>点餐</title>

    <link rel="stylesheet" href="${_cssPath}/jquery.mobile-1.4.0.css"/>
    <link rel="stylesheet" href="${_cssPath}/jqm-demos.css"/>
    <link rel="stylesheet" href="${_cssPath}/idangerous.swiper.css"/>
    <link rel="stylesheet" href="${_cssPath}/common.css"/>
    <link rel="stylesheet" href="${_cssPath}/orderDishes.css"/>

    <script language="javascript" src="${_jsPath}/jquery.js"></script>
    <script language="javascript" src="${_jsPath}/jquery.mobile-1.4.0.js"></script>

    <script type="text/javascript"><!--
    $(function () {
        // 增加
        /*$(".count-add").click(function{
         var count = parseInt($(this).parent().find("input").val());
         if (count >= 0) {
         $(this).find(".count-cut").removeClass("dn");
         $(this).find("input").removeClass("dn");
         }
         $(this).parent().find("input").val(count + 1);
         });

         // 减少
         $(".count-cut").click(function(){
         var count = parseInt($(this).parent().find("input").val());
         $(this).parent().find("input").val(count - 1);
         if (count <= 1) {
         $(this).find(".count-cut").addClass("dn");
         $(this).find("input").addClass("dn");
         }
         });*/
    });

    function addCount(obj) {
        var count = parseInt($(obj).parent().find("input").val());
        if (count >= 0) {
            $(obj).parent().find(".count-cut").removeClass("dn");
            $(obj).parent().find("input").removeClass("dn");
        }
        $(obj).parent().find("input").val(count + 1);
    }

    function cutCount(obj) {
        var count = parseInt($(obj).parent().find("input").val());
        if (count <= 1) {
            $(obj).parent().find(".count-cut").addClass("dn");
            $(obj).parent().find("input").addClass("dn");
        }
        $(obj).parent().find("input").val(count - 1);
    }
    --></script>

</head>

<body>

<div data-role="page">
    <div data-role="header">
        <h1>点餐菜单</h1>
    </div>
    <div role="main"
         class="ui-content order-ui-content">
        <div class="order-header">
            <span>${shopName}</span>
        </div>

        <div data-demo-html="true"
             data-demo-css="#inset-tablist">
            <div data-role="tabs">
                <ul data-role="listview"
                    data-inset="true"
                    class="tablist-left order-listview">
                    <c:forEach begin="0" step="1" items="${caiPingXiaoLeis}" var="caiPingXiaoLei"
                               varStatus="xaioLeiStatus">
                        <c:if test="${caiPingXiaoLei.caiPingXiaoLeiName!=null}">
                            <li data-icon="false">
                                <a href="#link${xaioLeiStatus.count}"
                                   data-ajax="false">
                                    <c:out value="${caiPingXiaoLei.caiPingXiaoLeiName}"/>
                                </a>
                            </li>
                        </c:if>
                    </c:forEach>
                </ul>

                <c:forEach begin="0" step="1" items="${caiPingXiaoLeis}" var="caiPingXiaoLei"
                           varStatus="xaioLeiStatus">
                    <c:if test="${caiPingXiaoLei.caiPingXiaoLeiName!=null}">
                        <ul id="link${xaioLeiStatus.count}"
                            class="tablist-content order-list-listview"
                            data-role="listview"
                            data-inset="true">
                            <c:forEach begin="0" step="1" items="${caiPingXiaoLei.caiPings}" var="caiPing"
                                       varStatus="caiPingStatus">
                                <c:if test="${caiPing.caiPingName!=null}">
                                    <li data-icon="false">
                                        <div>
                                            <%
                                            // TODO 找不到图片则统一一个图片
                                            // %>
                                            <img src="${_restaurantPath}/${shopId}/img/foods/${caiPing.caiPingID}.jpg" height="30%" width="30%" alt="">

                                            <br/>
                                            <span><c:out value="${caiPing.caiPingName}"/></span>
                                            <span class="orange font-b">￥${caiPing.jiaGe}</span>
                                        </div>
                                    <span class="btn-span">
                                    <button data-role="none"
                                            class="order-add-btn count-add"
                                            onclick="addCount(this);">+
                                    </button>
                                    <input data-role="none"
                                           class="order-input dn"
                                           readonly="readonly"
                                           value="0"/>
                                    <button data-role="none"
                                            class="order-add-btn count-cut dn"
                                            onclick="cutCount(this);">-
                                    </button>
                                    </span>
                                    </li>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </c:if>
                </c:forEach>
                </ul>
            </div>
        </div>
    </div>
    <!-- /content --

    <div data-role="footer"
         class="text-center">
        <button data-role="none"
                class="order-footer-btn orange">选好了
        </button>
    </div>
    <!-- /footer -->

</div>
<!-- /page -->

</body>
</html>

