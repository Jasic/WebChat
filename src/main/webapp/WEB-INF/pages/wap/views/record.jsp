<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%@ include file="/WEB-INF/pages/common/imports.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>我的订单-</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="author" content="www.hs.com">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">

    <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="${_cssPath}/wap.css"/>

    <script language="javascript" src="${_jsPath}/jquery.js"></script>
    <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <script language="javascript" src="${_jsPath}/jquery.cookie.js"></script>



    <script type="text/javascript">

        var $j = jQuery.noConflict();
        $j.ajaxSetup({
            cache: false,
            success: function (data, textStatus) {
                if (data != null && data != undefined && data.indexOf("j_username") != -1 && data.indexOf("j_password") != -1 && data.indexOf("isLoginPage") != -1) {
                    window.location = __ctxPath + "/login.html";
                }
            }
        });

        $j.fn.extend({
            loading: function () {
                return this.each(function () {
                    $j(this).css({"position": "relative"}).append('<div class="loading_data">&nbsp;</div>');
                });
            }
        });
        jQuery(document).ready(function ($) {
            // 提取cookie记录
            var chooseMenu = $.cookie("chooseMenu");
            var current = new Array();
            current = JSON.parse(chooseMenu);

            var html = $("#foodHTML").html();
            var reslutHtml = "";

            //回调函数有两个参数,第一个是元素索引,第二个为当前值
            $.each(current, function (key, val) {
                var obj = val;

                //new RegExp('网址', 'g')  第二个参数g代码不区分大小写
                reslutHtml += html.replace(new RegExp('\\[name\\]','g'), obj.name)
                        .replace(new RegExp('\\[price\\]','g'), obj.price)
                        .replace(new RegExp('\\[unit\\]','g'), "件")
                        .replace(new RegExp('\\[id\\]','g'), obj.id)
                        .replace(new RegExp('\\[count\\]','g'), obj.count);
            });

            $("#cookieMenu").html(reslutHtml);
        });
    </script>

</head>
<body>
<div data-role="page">


<div class="carte my_carte">
    <div class="box_carte">
        <div id="shippingcartBillDiv" class="tips">
            <span class="fl">您共点了<a id="foodCount" href="#">0</a>道菜</span>
        <span class="fr">共计：<strong class="red">303.00元</strong><font
                style="font-size: 10pt; color: #999999">(不含时价菜)</font></span></div>

        <div id="contentRt" class="content index_other" style="height: 783px;">
            <div class="title">
                <h4 class="fl">我的订单</h4>

                <div class="fr">
                    <a class="btn_green" onclick="goIndex()">加菜</a>
                    <a class="btn_cle6e6e8" id="show" href="javascript:void(0)" onclick="clearCart();">清空</a>
                </div>
                <div class="clear"></div>
            </div>
            <ul class="">

                <%!
                    /**
                     * [name]   菜品名称
                     * [price]  菜品单价
                     * [unit]   菜品单位
                     * [id]     菜品id
                     * [count]  菜品数量
                     **/
                %>
                <div style="display: none" id="foodHTML">
                    <li id="foodLi[id]">
                        <div class="cont_fl">
                            <div class="txt">
                                <h3><a href="#">[name][name]</a></h3>
                                <p class="cl666">
                                    <span class="red">[price]元/[unit]</span>
                                </p>
                            </div>
                        </div>
                        <div class="cont_fr cont_fr_other">
                            <a class="btn_subtract" href="#"
                               onclick="quantityMinus(&#39;[id]&#39;, 1);"></a>
                            <span id="[id]" name="quantitys" tabindex="1">[count]</span>
                            <a class="btn_add" href="javascript:void(0)" onclick="quantityPlus(&#39;[id]&#39;,1);"></a>
                            <input type="hidden" name="productSkuCodes" value="[id]">
                        </div>
                    </li>
                </div>
                <li id="cookieMenu"></li>

            </ul>
            <p class="cl999 reference">菜式价格仅供参考，以餐厅结算为准！</p>

            <!-- 是否是vip -->
            <!-- 指定部长 begin  -->
            <!-- 堂食 -->
            <!-- -------- 指定部长 begin-------------->
            <div class="appoint">
                <input id="ministerId" type="hidden" value="">

                <div class="title2">
                    <a href="javascript:void(0);" onclick="toggleScreen(this)" indexid="" objid="waiter">
                        <em class="icn_appoint" id="img"></em>指定部长：
                        <span id="spanTitle">不指定</span>
                    </a>
                </div>
                <div class="minister" id="waiter" style="display: none;">
                    <a href="javascript:void(0);" onclick="chooseMinister(this,&#39;&#39;)" value=""
                       class="curr">不指定</a>
                    <a href="javascript:void(0);" onclick="chooseMinister(this,&#39;0&#39;)"
                       value="7dbe5c7f-93b5-488e-ba87-f07dc1043ccb">吴秋英</a>
                    <a href="javascript:void(0);" onclick="chooseMinister(this,&#39;1&#39;)"
                       value="e387d6c9-1aab-4878-a2cf-bc5605ff8a44">谢满香</a>
                </div>
                <div class="clear"></div>
            </div>

        </div>
    </div>
    <div class="clear"></div>
    <div class="btn_my">
        <a id="goback" class="btn_my_green" href="http://14.146.224.119/m/index.html">返回菜单</a>
        <a id="goSalesOrder" class="btn_my_green" href="#"
           onclick="goSalesOrder()">我的厨房</a>
        <a id="btnCheckout" href="javascript:void(0)" onclick="toCheckout();" class="btn_my_red">保存订单</a>
        <a class="loading btn_my_red" style="display:none;">准备保存订单，请稍等</a>

    </div>
</div>
</div>
<div style="display:none">
<div id="divDlgshowPanel" style="visibility:hidden;position:absolute;overflow: auto;height: 98%">
    <div class="mask_box">
        <div class="content">
            <p class="cl666 cent">成功下单！</p>
            <p class="cl666 cent">请前往餐厅扫描桌台号二维码来使用此订单！</p>
            <p class="img"><img src="${_imgPath}/img_002.png" /></p>
            <div class="btn_mask code"><a class="btn_mask_green" href="javascript:void(0)" onclick="dlgshowPanel_close();">确定</a></div>
            <p class="cl666">提示：<br />请使用微信发现中的"扫一扫"来扫描桌台号二维码！</p>
        </div>
    </div>
</div>



<script type="text/javascript">

var ui_dialog_showPanel;
var ui_dialog_showPanel_hasKeepScene = false;
var ui_dialog_showPanel_needKeepScene = false;

$j(document).ready(function(){
    ui_dialog_showPanel = $j("#divDlgshowPanel");
});
/**
 *
 */
function dlgshowPanel_show(param)
{    ui_dialog_showPanel.css("visibility","visible");

    //"" != null ? "" : "center"
    var position = "" && "" ? [, ] : "";
    position = position ? position :  "center";

    ui_dialog_showPanel.dialog({
        title:"请扫描桌台号二维码",
        modal: true,
        height:'80%',
        width:'80%',
        bgiframe: true,
        buttons: {},
        overlay: { opacity: 0.5, background: "black" },
        closeOnEscape:true,
        closeAfterFun: '',
        position : position
    });

    ui_dialog_showPanel.dialog("open");

}


function dlgshowPanel_close()
{
    ui_dialog_showPanel.dialog("close");
}
function parseDate(dateStr) {
    if (dateStr.indexOf("PM") == -1) {
        return dateStr;
    }
    //2014-01-04 02:28 PM
    dateStr = dateStr.split(" ");
    var dayStr = dateStr[0];
    var timeStr = dateStr[1];
    timeStr = timeStr.split(":");
    timeStr[0] = parseInt(timeStr[0]) + 12;
    optime = dayStr + " " + timeStr[0] + ":" + timeStr[1];
    return optime;
}

//结帐按钮
function toCheckout() {
    dlgshowPanel_show(1);
}

//删除商品项
function deleteItem(productSkuCode, obj) {
    if(confirm("你确定要删除吗？")){
        alert(productSkuCode);
        var id = "#foodLi" +productSkuCode;

        // 1.删除页面的显示
        $j(id).remove();

        // 2.删除cookies的记录
        deleteCookieFoodById("chooseMenu",productSkuCode);
    }
}

//购买数量减1
function quantityMinus(productSkuCode, tabindex) {
    var filter = "span[id=" + productSkuCode +"][name=quantitys][tabindex=" + tabindex + "]";
    var quantityElement = $j(filter);
    var quantity = 1;
    if (quantityElement.text() != "" && parseInt(quantityElement.text()) > 1) {
        quantity = parseInt(quantityElement.text()) - 1;
        quantityElement.text(quantity);
        quantityOnChange(productSkuCode,-1);
    } else {
        deleteItem(productSkuCode, quantityElement);
    }
}

//购买数量加1
function quantityPlus(productSkuCode, tabindex) {

    var filter = "span[id=" + productSkuCode +"][name=quantitys][tabindex=" + tabindex + "]";
    var quantityElement = $j(filter);
    var quantity = 1;
    if (quantityElement.text() != ""){
        quantity = parseInt(quantityElement.text()) + 1;
    }
    quantityElement.text(quantity);
    quantityOnChange(productSkuCode, 1);
}

//更新商品项数量输入框触发事件
function quantityOnChange(productSkuCode,count) {

    // 1.改变cookies的记录
    changeCookieFoodById("chooseMenu",productSkuCode,count);
}


//清空购物车
function clearCart() {
    if (confirm("你确定要清空吗？")) {
        $j("#cookieMenu").html("");
        // 清除菜单的cookies
        $j.cookie("chooseMenu",null);
    }
}


/**
 * 根据食物的id删除cookie菜单中的食物
 * cookie:当前用户的cookie
 * id:当前食物的id
 */
function deleteCookieFoodById(cookie,id){

    // 循环cookie记录
    var history = new Array();
    history = JSON.parse($j.cookie(cookie));

    var data = history;
    // alert("历史记录是:\n" + history);

    var index = -1;
    if (history != null) {
        $j.each(history, function (key, val) {

            if (val.id == id) {
                index = key;
            }
        });
    }

    // 删除当前id
    if(index != -1){
        data.splice(index,1);
    }
    var json = JSON.stringify(data);
    $j.cookie(cookie, json, { expires: 1 })
}


/**
 * 根据食物的id更改cookie菜单中的食物数量
 * cookie:当前用户的cookie
 * id:当前食物的id
 */
function changeCookieFoodById(cookie,id,count){

    // 循环cookie记录
    var history = new Array();
    history = JSON.parse($j.cookie(cookie));

    var data = history;
    // alert("历史记录是:\n" + history);

    if (history != null) {
        $j.each(history, function (key, val) {
            if (val.id == id) {
                val.count = val.count + Number(count);
            }
        });
    }

    var json = JSON.stringify(data);
    $j.cookie(cookie, json, { expires: 1 })

    alert(json);

    refreshPrices();
}

//刷新购物车帐单信息
function refreshPrices() {

}

//刷新购物车帐单信息
function refreshBill() {
    $j("#shippingcartBillDiv").load("/m/cart/shoppingcart.html?doAction=refreshBill&decorator=blank");
    //refreshPromo();
}

//刷新购物车促销信息
function refreshPromo() {
    $j("#shippingcartPromoDiv").load("/m/cart/shoppingcart.html?doAction=refreshPromo&decorator=blank");
}

//刷新商品项信息
function refreshItems() {
    $j("#shoppingcartItemsDiv").load("/m/cart/shoppingcart.html?doAction=refreshItems&decorator=blank");
    refreshPromo();
}

//商品加入购物车后的回调函数
function addToCartCallback(json, sourceEvent) {
    alert("商品已成功添加到购物车");
    refreshItems();
    refreshBill();
}

//商品添加到收藏夹后的回调函数
function addFavoriteProductCallback(json, sourceEvent) {
    promptFavoriteMessage(json, sourceEvent);
    $j("#rpBox2").load("/m/cart/shoppingcart.html?doAction=refreshShoppingcartFavorite&decorator=blank");

}
//删除收藏夹商品的回调函数
function deleteFavoriteCallback() {
    if ($j('#favoriteListDiv li').length == 0) {
        html = '<div class="msg">???shoppingcart.favorite.noItems???</div>';
        $j("#rpBox2").html(html);
    }


}

//显示等待信息，例如“正在读取XXX信息，请稍等”
showWaitMessage = function (info, obj) {
    try {
        if (obj == null) return;
        clearWaitMessage();
        $j(obj).hide();
        $j("<i class='loading'>" + info + "</i>").insertAfter(obj);
    } catch (e) {
        alert(e);
    }
}

//清除等待信息
clearWaitMessage = function (obj) {
    try {
        $j(".loading").remove();
        if (obj != null) $j(obj).show();
    } catch (e) {
        alert(e);
    }
}

//具体促销显示
function getPromoValue(event) {
    $importDwr(function () {
        shoppingcartDwr.getPromoValue(function (jsonText) {
            var str = "";
            var json = eval("(" + jsonText + ")");
            for (var i = 0; i < json.length; i++) {
                str += "<li>" + json[i].messages1 + "</li>";
            }
            ;
            $j("#proms").html(str);
        })
    })
}

//判断输入是否是数字
isNumber = function (e) {
    if ($j.browser.msie) {
        if (((event.keyCode > 47) && (event.keyCode < 58)) || (event.keyCode == 8)) {
            return true;
        } else {
            return false;
        }
    } else {
        if (((e.which > 47) && (e.which < 58)) || (e.which == 8)) {
            return true;
        } else {
            return false;
        }
    }
}

function customerBindPanel_close() {
    dlgcustomerBindPanel_close();
    toCheckout();
}

function customerBindPanelCallback() {

}

function goSalesOrder() {
    window.location = "/m/order/salesOrder.html";
}

function goIndex() {
    window.location = "orderDishes";
}
</script>
<!-- -------- 指定部长 end-------------- -->

<script type="text/javascript">
    var controller;
    $j(document).ready(function () {
    });


    //显示编辑页面
    function showEditPanel(moduleName, obj) {
        $j("#orderDetailSummaryPage").hide();	//隐藏主页
        if (moduleName == "consignee"
                || moduleName == "virtualConsignee"
                || moduleName == "paymentMethod"
                || moduleName == "shippingMethod") {

            controller.edit(moduleName, obj);		//渲染编辑视图
        }
        $j("#" + moduleName + "Page").show();	//显示编辑视图
    }

    //显示主页,隐藏编辑页面
    function showMainPanel(moduleName) {
        $j("#" + moduleName + "Page").hide();	//隐藏编辑视图
        $j("#orderDetailSummaryPage").show();	//显示主页
    }

    function placeOrder(obj) {
        $j(obj).hide();	//隐藏按钮
        $j(".loading").show();

        var ministerId = $j("#ministerId").val();
        ministerData = {
            "ministerId": ministerId
        }
        DWREngine.setAsync(false);
        checkoutDwr.saveMinisterData(ministerData);

        //view.showWaitMessage(__FMT.checkout_loading, obj);
        setTimeout(function () {
            DWREngine.setAsync(true);					//设置ajax为异步解决ie下"loading"信息不显示问题
            checkoutDwr.placeOrder(
                    function (jsonText) {
                        var result = eval('(' + jsonText + ')');
                        if (result.error != null) {
                            alert(result.error);
                            data.error = result.error;
                        } else {
                            window.location = __ctxPath + "/cart/orderReview.html?doAction=checkoutSucc&orderNo=" + result.orderNo;
                        }
                    }
            );
        }, 50);
    }

    //显示 隐藏详细
    function toggleScreen(linkDOM) {
        var jTrThis = $j(linkDOM);
        var toggleButton = jTrThis.attr("objId");
        var jTrFull = $j("#" + toggleButton);
        var img = $j("#img");
        if (jTrFull.is(":hidden")) {
            img.removeClass("icn_appoint");
            img.addClass("icn_appoint_up");
            jTrFull.show();
        } else {
            jTrFull.hide();
            img.removeClass("icn_appoint_up");
            img.addClass("icn_appoint");
        }
    }

    //选择部长
    function chooseMinister(dom, index) {
        var dum = $j(dom);
        var classSpan = $j("#classSpan_" + index);
        var chooseValue = $j(dom).attr("value");
        $j("#ministerId").val(chooseValue);
        $j("#spanTitle").html(dum.text());
        var id = "waiter";
        var aDivs = document.getElementById(id);
        var aSpans = aDivs.getElementsByTagName("a");
        for (i = 0; i < aSpans.length; i++) {
            var aSpan = aSpans[i];
            aSpan.className = "";
        }
        //classSpan.addClass("on");
        $j(dom).addClass("curr");

    }
</script>
<!-- 指定部长 end  -->
</div>
</body>
</html>
