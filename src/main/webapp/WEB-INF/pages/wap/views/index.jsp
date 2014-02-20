<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/pages/common/imports.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <title>微订餐首页</title>

    <link rel="stylesheet" href="${_cssPath}/jquery.mobile-1.4.0.min.css" />
    <link rel="stylesheet" href="${_cssPath}/jqm-demos.css" />
    <link rel="stylesheet" href="${_cssPath}/idangerous.swiper.css" />
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700" />
    <link rel="stylesheet" href="${_cssPath}/common.css" />
    <link rel="stylesheet" href="${_cssPath}/index.css" />

    <script language="javascript" src="${_jsPath}/jquery.js"></script>
    <script language="javascript" src="${_jsPath}/jquery.mobile-1.4.0.min.js"></script>
    <script language="javascript" src="${_jsPath}/idangerous.swiper-1.8.js"></script>

    <script type="text/javascript">
        $(function() {
            var mySwiper = $('.swiper-container').swiper( {
                //Your options here:
                mode : 'horizontal',
                loop : true,
                autoplay : 1000,
                mode : 'horizontal',
                slidesPerView : 'auto',
                pagination : '.pagination-sd'
                //etc..
            });

            function playSwipe() {
                mySwiper.swipeNext();
            }

            // 定时器，定时滚动焦点图
            var interval = setInterval(playSwipe, 3000);

            $("#orderDishes").click(function(){
                location.href = "/wap/${shopId}/orderDishes";
            });

            $("#customer").click(function(){
                <c:choose>
                <c:when test="${clientInfo==null}">
                var redrect = window.confirm("您未进行绑定，请先绑定个人信息！");
                if (redrect) {
                    location.href = "/wap/${shopId}/register";
                }
                </c:when>
                <c:when test="${sessionScope.LOGIN_USER_KEY==null}">
                var redrect = window.confirm("您未登录，请先登录！");
                if (redrect) {
                    location.href = "/wap/${shopId}/login";
                }
                </c:when>
                <c:otherwise>
                    location.href = "/wap/${shopId}/customer";
                </c:otherwise>
                </c:choose>

            });

            $(".swiper-slide").click(function(){
                location.href = $(this).attr("title");
            });

        });
    </script>
</head>
<body>
<div data-role="page">
    <div data-role="content" class="content">

        <!-- 焦点图 -->
        <div class="swiper-container" style="cursor: pointer;">
            <div class="swiper-wrapper">

                <!-- 显示广告 -->
                <c:forEach var="i" items="${ases}">
                <div class="swiper-slide" title="activity.html">
                    <a href="${i.advertisementInfo.forwardurl}">
                     <img src="${_imgPath}/shopx/${shopId}/${i.advertisementInfo.imgurl}" title="${i.advertisementInfo.description}" width="100%" />
                    </a>
                </div>
                </c:forEach>
            </div>
        </div>
        <div class="pagination-sd my-pagination-sd"></div>

        <!-- 功能菜单 -->
        <div style="width: 98%; margin: 0% auto; padding: 1px;">
            <div class="ui-grid-a" style="background-color: white;">
                <div class="ui-block-a ui-block-item">
                    <div id="shake" class="ui-bar ui-bar-a padding-0 back-yaoyiyao">
                        <span class="small-menu-title">刮刮卡</span>
                        <span>99元外卖红包欢乐..</span>
                    </div>
                </div>
                <div class="ui-block-b ui-block-item">
                    <div id="customer" class="ui-bar ui-bar-a padding-0 back-myself">
                        <span class="small-menu-title">我的</span>
                        <span>订单、券包</span>
                    </div>
                </div>
            </div>
            <!-- /grid-a -->
        </div>

        <div style="width: 98%; margin: 0px auto; padding: 0px; margin-top: 15px;">
            <div class="ui-grid-a" style="background-color: white;">
                <div class="ui-block-a ul.ui-grid-a">
                    <div id="orderDishes"
                         class="ui-bar ui-bar-a padding-0 back-diancan">
                        <span class="big-menu-title red">点菜</span>
                        <span>自助点菜下单</span>
                    </div>
                </div>
                <div class="ui-block-b ui-block-item">
                    <div id="takeOut" class="ui-bar ui-bar-a padding-0 back-waimai">
                        <span class="big-menu-title green">外卖</span>
                        <span>点外卖返现50%</span>
                    </div>
                </div>
                <div class="ui-block-a ui-block-item">
                    <div id="nearby" class="ui-bar ui-bar-a padding-0 back-fujin">
                        <span class="big-menu-title olive">附近</span>
                        <span>发现周边美食</span>
                    </div>
                </div>
                <div class="ui-block-b ui-block-item">
                    <div id="pay"
                         class="ui-bar ui-bar-a padding-0 back-jiezhang">
                        <span class="big-menu-title blue">结账</span>
                        <span>手机轻松付款</span>
                    </div>
                </div>
            </div>
            <!-- /grid-a -->
        </div>
    </div>
    <!-- /content -->
</div>
</body>
</html>
