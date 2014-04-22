<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%@ include file="/WEB-INF/pages/common/imports.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type"
          content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">


    <title>点餐</title>

    <link rel="stylesheet" href="${_cssPath}/jquery.mobile-1.4.0.css"/>
    <link rel="stylesheet" href="${_cssPath}/jqm-demos.css"/>
    <link rel="stylesheet" href="${_cssPath}/idangerous.swiper.css"/>
    <link rel="stylesheet" href="${_cssPath}/common.css"/>
    <link rel="stylesheet" href="${_cssPath}/orderDishes.css"/>

    <script language="javascript" src="${_jsPath}/jquery.js"></script>
    <script language="javascript" src="${_jsPath}/jquery.mobile-1.4.0.js"></script>
    <script language="javascript" src="${_jsPath}/jquery.cookie.js"></script>

    <script type="text/javascript"><!--

    $(function () {

        /**
         * 清除已选记录
         */
        $("#clearHistory").click(function(){
            // 清除cookies
            $.cookie("chooseMenu",null);
            // TODO 清除当前选择的
        });

        /**
         * 确定选择
         */
        $("#chooseok").click(function () {
            var data = new Array()
            var index = 0;
            $(".order-input").each(function () {
                if (Number($(this).val()) > 0) {
                    var count = 0;
                    var food = new Object();
                    var id = $(this).attr("id");
                    food["id"] = id;
                    food["price"] = $(this).parent().parent().find(".price").text();
                    food["name"] = $(this).parent().parent().find(".caiPingName").text();
                    food["count"] = Number($(this).val()) + Number(count);
                    data[index] = food;
                    index++;
                }
            });

            // alert("新增记录是:\n" + JSON.stringify(data));

            // 循环cookie记录
            var history = new Array();
            history = JSON.parse($.cookie("chooseMenu"));
            // alert("历史记录是:\n" + history);
            if (history != null) {
                $.each(history, function (key, val) {
                    var obj = val;
                    var sameId = false;
                    $.each(data, function (key1, val1) {
                        // alert("历史记录ID:［" + obj.id + "],循环中的新ID:[" + val1.id + "],它们" + (obj.id == val1.id));
                        // id相同则将计数器相加
                        if (obj.id == val1.id) {
                            val1.count = (obj.count + val1.count);
                            sameId = true;
                        }
                    });

                    // Id不相同则直接将历史记录中的加进来
                    if (!sameId) {
                        data[index] = obj;
                        index++;
                    }
                });
            }
            var json = JSON.stringify(data);
            // alert("最终结果:\n" + json);

            if (index > 0) {
                $.cookie('chooseMenu', json, { expires: 1 }); //设置带时间的cookie 1天
                var order = window.confirm("加入菜单成功，是否查看已选菜单?");
                if (order) {
                    window.location = "record";
                }
                // 提交
//                $.ajax({
//                    type: "POST",
//                    url: "chooseMenu",
//                    data: "json=" + json,
//                    success: function (msg) {
//                        if (msg == 'success') {
//                            var order = window.confirm("加入菜单成功，是否立即下单！");
//                            if (order) {
//                                window.location = "record";
//                            }
//                        } else {
//                            alert("下单错误，信息：" + msg);
//                        }
//                    }
//                });
            } else {
                alert("未选择菜品,请先选择菜式！");
            }
        });

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
            <span>
            </span>
        </div>

        <div data-demo-html="true"
             data-demo-css="#inset-tablist">
            <div data-role="tabs">
                <ul data-role="listview"
                    data-inset="true"
                    class="tablist-left order-listview">
                    <c:forEach begin="0" step="1" items="${caiPingXiaoLeis}" var="caiPingXiaoLei"
                               varStatus="xaioLeiStatus">
                        <c:if test="${caiPingXiaoLei.caipingxiaoleiname!=null}">
                            <li data-icon="false">
                                <a href="#link${xaioLeiStatus.count}"
                                   data-ajax="false">
                                    <c:out value="${caiPingXiaoLei.caipingxiaoleiname}"/>
                                </a>
                            </li>
                        </c:if>
                    </c:forEach>
                </ul>

                <c:forEach begin="0" step="1" items="${caiPingXiaoLeis}" var="caiPingXiaoLei"
                           varStatus="xaioLeiStatus">
                    <c:if test="${caiPingXiaoLei.caipingxiaoleiname!=null}">
                        <ul id="link${xaioLeiStatus.count}"
                            class="tablist-content order-list-listview"
                            data-role="listview"
                            data-inset="true">
                            <c:forEach begin="0" step="1" items="${caiPingXiaoLei.caiPings}" var="caiPing"
                                       varStatus="caipingstatus">
                                <c:if test="${caiPing.caipingname!=null}">
                                    <li data-icon="false">
                                        <span>
                                            <%
                                                // TODO 找不到图片则统一一个图片
                                                // %>
                                            <img src="${_restaurantPath}/${shopId}/img/foods/${caiPing.caipingid}.jpg"
                                                 height="30%" width="30%" alt="">

                                            <br/>
                                            <span class="caiPingName"><c:out value="${caiPing.caipingname}"/></span>
                                            ￥<span class="price orange font-b">${caiPing.jiage}</span>
                                        </span>
                                        <span class="btn-span">
                                            <button data-role="none"
                                                    class="order-add-btn count-add"
                                                    onclick="addCount(this);">+
                                            </button>
                                            <input id="${caiPing.caipingid}" data-role="none"
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
    <!-- /content -->

    <div data-role="footer"
         class="text-center" data-position="fixed" data-fullscreen="true">
        <button id="chooseok" data-role="none"
                class="order-footer-btn orange">选好了
        </button>
        <button id="clearHistory" data-role="none"
                class="order-footer-btn orange">清除
        </button>
    </div>

</div>
<!-- /page -->

</body>
</html>

