<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%@ include file="/WEB-INF/pages/common/imports.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <title>我的菜单</title>

    <link rel="stylesheet" href="${_cssPath}/jquery.mobile-1.4.0.css"/>
    <link rel="stylesheet" href="${_cssPath}/jqm-demos.css"/>
    <link rel="stylesheet" href="${_cssPath}/idangerous.swiper.css"/>
    <link rel="stylesheet" href="${_cssPath}/common.css"/>
    <link rel="stylesheet" href="${_cssPath}/record.css"/>

    <script language="javascript" src="${_jsPath}/jquery.js"></script>
    <script language="javascript" src="${_jsPath}/jquery.mobile-1.4.0.js"></script>
    <script language="javascript" src="${_jsPath}/jquery.cookie.js"></script>


    <script type="text/javascript">
        $(function () {
            // 提取cookie记录
            var chooseMenu = $.cookie("chooseMenu");
            var current = new Array();
            current = JSON.parse(chooseMenu);

            alert(chooseMenu);
            alert(current);
            var html = "<li>";
            //回调函数有两个参数,第一个是元素索引,第二个为当前值
            $.each(current,function(key,val){
               var obj =  val;
               html += obj.name + ", " + obj.count + ", " + obj.id + ", " + obj.price;
                html +="<div>";
                html +="<span>菜单</span>";
                html +="<span>" + obj.name+"</span>";
                html +="</div>";
                html +="<div>";
                html +="<span>金额:<span class='orange'>￥"+ Number(obj.price)*Number(obj.count) + "</span></span>";
                html +="</div>";
            });
            html +="<button data-role='none' class='float-r'>删除</button>";
            html +="<button data-role='none' class='float-r'>修改</button>";
            html +="<button data-role='none' class='float-r'>下单</button>";
            html += "<\li>";
            alert(html);
            $("#cookieMenu").html(html);
        })
    </script>

</head>

<body>
<div data-role="page">

    <div role="main" class="ui-content order-ui-content">

        <div data-role="tabs" id="tabs">
            <div data-role="navbar">
                <ul>
                    <li>
                        <a href="#record" data-ajax="false">点餐记录</a>
                    </li>
                    <li>
                        <a href="#waitEvaluate" data-ajax="false">待评价</a>
                    </li>
                </ul>
            </div>

            <div id="record">
                <ul data-role="listview" data-inset="true">

                    <li id="cookieMenu">
                        <div>
                            <span>点餐时间 2013-12-1 17:00:00</span>

                            <div>

                                <span>海龙阁酒楼</span>
                                <span>鱼香肉丝、乌鸡炖汤</span>
                            </div>
                            <div>
                                <span>金额:<span class="orange">￥50.00</span></span>
                                <button data-role="none" class="float-r">删除</button>
                                <button data-role="none" class="float-r">修改</button>
                                <button data-role="none" class="float-r">下单</button>
                            </div>
                        </div>
                    </li>
                    <li id="order">

                    </li>
                </ul>
            </div>


            <div id="waitEvaluate">
                <ul data-role="listview" data-inset="true">
                    <li>
                        <div>
                            <span>点餐时间 2013-12-1 17:00:00</span>

                            <div>
                                <span>海龙阁酒楼</span>
                                <span>鱼香肉丝、乌鸡炖汤</span>
                            </div>
                            <div>
                                <span>金额:<span class="orange">￥50.00</span></span>
                                <button data-role="none" class="float-r">删除</button>
                                <button data-role="none" class="float-r">评价</button>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>

        </div>

    </div>
    <!-- /content -->

</div>
<!-- /page -->
</body>
</html>

