<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/pages/common/imports.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <title>${shopId}商户登录</title>
    <link rel="stylesheet" href="${_cssPath}/jquery.mobile-1.4.0.css"/>
    <link rel="stylesheet" href="${_cssPath}/jqm-demos.css"/>
    <link rel="stylesheet" href="${_cssPath}/idangerous.swiper.css"/>
    <link rel="stylesheet" href="${_cssPath}/common.css"/>
    <link rel="stylesheet" href="${_cssPath}/index.css"/>

    <script language="javascript" src="${_jsPath}/jquery.js"></script>
    <script language="javascript" src="${_jsPath}/jquery.mobile-1.4.0.js"></script>
    <script language="javascript" src="${_jsPath}/idangerous.swiper-1.8.js"></script>

    <script type="text/javascript">
        jQuery(document).ready(function () {
            //输入事件
            $("input[id]").bind("focus", function () {
                if ($(this).attr("id") == 'username' || $(this).attr("id") == 'password')
                    $(this).attr("value", "");
            });
            //提交
            $("#submit").bind("click", function () {
                if (valid()) {
                    $.ajax({
                        type: "POST",
                        url: "http://localhost:8080/note/servlet/Login",
                        data: $("form#loginform").serialize(),
                        success: function (msg) {
                            if (msg == 'success') {
                                $.mobile.changePage("content/first.html", "slidedown", true, true);
                            } else {
                                $.mobile.changePage("content/loginfalse.html", "slidedown", true, true);
                            }

                        }
                    });
                }
            });
        });
        //输入信息验证
        function valid() {
            if ($("#username").attr("value") == '' || $("#password").attr("value") == '') {
                $.mobile.changePage("content/loginfalse.html", "slidedown", true, true);
                return false;
            }
            return true;
        }

        // 注册
        $(function() {
            $("#toregist").click(function(){
                location.href = "register";
            });
        })
        ;
    </script>

    <style type="text/css">
        p {
            font-size: 1.5em;
            font-weight: bold;
        }

        #submit {
            float: right;
            margin: 10px;
        }

        #toregist {
            float: left;
            margin: 10px;
        }
    </style>
    <body>

    <!-- begin first page -->
    <section id="page" data-role="page">
        <div data-role="header" class="header">
            <h1>欢迎光临${shopId}</h1>
        </div>
        <div data-role="content" class="content">
            <div style="margin: 1%">
                <p><font color="#2EB1E8">会员登录</font></p>

                <form method="post" id="loginform">
                    <input type="text" name="username" id="username" placeholder="输入注册时的11位手机号码"/><br>
                    <input type="password" name="password" id="password" placeholder="输入密码"/>
                    <fieldset data-role="controlgroup">
                        <input type="checkbox" name="checkbox-1" id="checkbox-1" class="custom"/>
                        <label for="checkbox-1">保持登录状态</label>
                    </fieldset>
                    <a data-role="button" id="toregist" data-theme="e">注册</a>
                    <a data-role="button" id="submit" data-theme="b">登录</a>
                </form>
            </div>
        </div>
        <div data-role="footer" class="header" style="padding-bottom: 1%">
            <h1>©Lemontree 商户${shopId}</h1>
        </div>
    </section>
    </body>
</head>
</html>