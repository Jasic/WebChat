<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/common/imports.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <title>地址管理</title>

    <link rel="stylesheet" href="${_cssPath}/jquery.mobile-1.4.0.css" />
    <link rel="stylesheet" href="${_cssPath}/jqm-demos.css" />
    <link rel="stylesheet" href="${_cssPath}/idangerous.swiper.css" />
    <link rel="stylesheet" href="${_cssPath}/common.css" />
    <link rel="stylesheet" href="${_cssPath}/address.css" />

    <script language="javascript" src="${_jsPath}/jquery.js"></script>
    <script language="javascript" src="${_jsPath}/jquery.mobile-1.4.0.js"></script>


    <script type="text/javascript">
        $(function() {
            $("#edit-btn").click(function(){
                if ($(this).text() == "编辑") {
                    $(this).text("取消");
                    $(".addres-func").removeClass("dn");
                } else {
                    $(this).text("编辑");
                    $(".addres-func").addClass("dn");
                }
            });

            $("#deleteAddress").click(function(){
                var isDelete = window.confirm("是否删除地址？");
            });

            $("#editAddress").click(function(){
                location.href = "editAddress?";
            });

            $("#addAddress").click(function(){
                location.href = "editAddress";
            });

        });
    </script>

</head>

<body>
<div data-role="page">
    <div data-role="content" class="content">

        <!-- 地址列表 -->
        <div class="ui-corner-all custom-corners">
            <div class="ui-body ui-body-a ui-bar-self">
                <p>公司地址 13312345678</p>
                <p>天河东路111号三楼</p>
                <div class="addres-func dn">
                    <span id="deleteAddress">删除</span>
                    <span id="editAddress">编辑</span>
                </div>
            </div>
        </div>

        <button class="ui-btn ui-corner-all" id="addAddress">新增地址</button>

    </div>
    <!-- /content -->

    <div data-role="footer" class="footer">
        <button id="edit-btn" data-role="none" class="ui-btn-self">编辑</button>
    </div>
    <!-- /footer -->

</div>
</body>
</html>
