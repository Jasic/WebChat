<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/common/imports.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <title>编辑地址</title>

    <link rel="stylesheet" href="${_cssPath}/jquery.mobile-1.4.0.css" />
    <link rel="stylesheet" href="${_cssPath}/jqm-demos.css" />
    <link rel="stylesheet" href="${_cssPath}/idangerous.swiper.css" />
    <link rel="stylesheet" href="${_cssPath}/common.css" />
    <link rel="stylesheet" href="${_cssPath}/address.css" />

    <script language="javascript" src="${_jsPath}/jquery.js"></script>
    <script language="javascript" src="${_jsPath}/jquery.mobile-1.4.0.js"></script>

    <script type="text/javascript">
        $(function() {

            $("#cancel").click(function(){
                location.href = "address.html";
            });

        });
    </script>

</head>

<body>
<div data-role="page">
    <div data-role="content" class="content">

        <form action="editAddress.html">
            <button id="cancel" data-role="none" class="ui-btn-self-cancel" type="button">取消</button>
            <button id="save" data-role="none" class="ui-btn-self float-r" type="submit">保存</button>

            <div class="ui-corner-all custom-corners edit-address-from">
                <div class="ui-body ui-body-a ui-bar-self">
                    <label for="name">姓名:</label>
                    <input type="text" name="name" id="name" data-role="none" class="ui-input-self" value="" />
                </div>
                <div class="ui-body ui-body-a ui-bar-self">
                    <label for="mobile">手机:</label>
                    <input type="text" name="mobile" id="mobile" data-role="none" class="ui-input-self" value="" />
                </div>
                <div class="ui-body ui-body-a ui-bar-self">
                    <label for="address">送餐地址:</label>
                    <input type="text" name="address" id="address" data-role="none" class="ui-input-self" value="" />
                </div>
            </div>
        </form>

    </div>
    <!-- /content -->

</div>
</body>
</html>
