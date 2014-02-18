<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/pages/common/imports.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <title>${shopId}商户注册</title>
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
                if ($(this).attr("value") == '用户名' || $(this).attr("value") == '密码')
                    $(this).attr("value", "");
            });

            //------------------------------------ 检查手机 --------------------------------------
//            $("#phone").focusin(
//                    function () {
//                        $("#phoneError").text("");
//                        $("#submitError").text("");
//                        $("#br1").remove();
//                        return;
//                    }
//            );
//
//            $("#phone").focusout(
//                    function () {
//                        if (!$("#phone").val().isMobile()) {
//                            $("#phoneError").text("不是完整的11位手机号或者正确的手机号前七位").after("<div id='br1'><br/><div>");
//                            return;
//                        }
//                    }
//            );
//
//            //------------------------------------ 检查密码 --------------------------------------
//            $("#password").focusin(
//                    function () {
//                        $("#passwordError").text("");
//                        $("#br2").remove();
//                        return;
//                    }
//            );
//
//            $("#password").focusout(
//                    function () {
//                        if ($("#password").val().length<4) {
//                            $("#passwordError").text("密码长度必大于等于4").after("<div id='br2'><br/><div>");
//                            return;
//                        }
//                    }
//            );
//
//            $("#repassword").focusin(
//                    function () {
//                        $("#repasswordError").text("");
//                        $("#br3").remove();
//                        return;
//                    }
//            );
//
//            $("#repassword").focusout(
//                    function () {
//                        if ($("#password").val() != $("#repassword").val()) {
//                            $("#repasswordError").text("两次密码不相等").after("<div id='br3'><br/><div>");
//                            return;
//                        }
//                    }
//            );

            //提交
            $("#toregistAction").bind("click", function () {
                if (true) {

//                    // 手机
//                    if (!$("#phone").val().isMobile()) {
//                        $("#phoneError").text("不是完整的11位手机号或者正确的手机号前七位");
//                        return;
//                    }
//
//                    // 密码长度
//                    if ($("#password").val().length<4) {
//                        $("#passwordError").text("密码长度必大于等于4");
//                        return;
//                    }
//
//                    // 重复密码
//                    if ($("#password").val() != $("#repassword").val()) {
//                        $("#repasswordError").text("两次密码不相等");
//                        return;
//                    }

                    $.ajax({
                        type: "POST",
                        url: 'registerAction<c:if  test="${sessionScope.fanInfoId!=null}"><c:out value="?fanInfoId=${sessionScope.fanInfoId}"/></c:if>',
                        data: $("form#registform").serialize(),
                        success: function (msg) {
                            if (msg == 'success') {
                                var url = "successRedirect?type=手机号码[" + $("#phone").val() + "]注册&redirectUrl=customer";
                                location.href = url ;
//                                $.mobile.changePage("successRedirect?type='aa'&redirectUrl='customer'", "slidedown", true, true);
                            } else {
                                $("#submitError").text(msg);
                            }

                        }
                    });
                }
            });
        });


        String.prototype.Trim = function () {
            var m = this.match(/^\s*(\S+(\s+\S+)*)\s*$/);
            return (m == null) ? "" : m[1];
        }

        // 手机号码
        String.prototype.isMobile = function () {
            return (/^(?:13\d|15[89])-?\d{5}(\d{3}|\*{3})$/.test(this.Trim()));
        }

        // 电话号码
        String.prototype.isTel = function () {
            //"兼容格式: 国家代码(2到3位)-区号(2到3位)-电话号码(7到8位)-分机号(3位)"
            //return (/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(this.Trim()));
            return (/^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/.test(this.Trim()));
        }
    </script>

    <style type="text/css">
        p {
            font-size: 1.5em;
            font-weight: bold;
        }

        header div {
            font-size: 1.5em;
        }

        #regist {
            width: 150px;
            height: 50px;
            margin: 5px;
        }
    </style>

    <body>

    <!-- begin first page -->
    <section data-role="page">
        <header data-role="header" data-theme="b" data-type="horizontal">
            <div data-role="controlgroup">
                <nav data-role="navbar">
                    <ul>
                        <li><a href="#page1" class="ui-btn-active">[${shopId}]的会员注册</a></li>
                        <li><a href="#page2">注册商户优惠</a></li>
                    </ul>
                </nav>
            </div>
        </header>
        <div data-role="content" class="content" style="margin: 1%;">
            <form method="post" id="registform">
                <label for="phone">手机号码</label>
                <input type="text" name="phone" required="true" placeholder="填写自己11位的手机号码（必填）" id="phone"/>

                <div id="phoneError"></div>
                <label for="password">密码</label>
                <input type="password" name="password" required="true" placeholder="填写密码（必填）" id="password"/>
                <div id="passwordError"></div>

                <label for="repassword">确认密码</label>
                <input type="password" name="repassword" required="true" placeholder="填写密码（必填）" id="repassword"/>

                <div id="repasswordError"></div>
                <label for="email">邮箱</label>
                <input type="email" name="email" placeholder="填写常用邮箱（选填1）" id="email"/>
                <label for="clientName">昵称</label>
                <input type="text" name="clientName" placeholder="填写自己喜欢的昵称" id="clientName"/>
                <label for="address">住宅地址</label>
                <input type="text" name="address" placeholder="填写自己住宅地址" id="address"/>
                <fieldset data-role="controlgroup">
                    <legend>身份:</legend>
                    <c:forEach var="type" items="${clientTypes}" varStatus="status">
                        <input type="radio" name="indetity" id="indetity-${status.index}"
                               value="indetity-${status.index}"
                                <c:if test="${status.last}">
                                    <c:out value="checked='checked'" escapeXml="true" default="checked='checked'"/>
                                </c:if>
                                />
                        <label for="indetity-${status.index}">${type.type}</label>
                    </c:forEach>
                </fieldset>
                <div>
                    <div id="submitError">
                    </div>
                    <br/>

                    <div>
                        <button type="button" data-role="button" id="toregistAction" data-theme="e">确定</button>
                    </div>
                </div>
            </form>
        </div>
    </section>
    <!-- end first page -->
    </body>
</head>
</html>
