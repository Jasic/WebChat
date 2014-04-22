<%@ page import="com.lemontree.common.GlobalConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/common/imports.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

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

            // 删除地址
            $(".deleteAddress").click(function(){
                var index = $(this).find("input").val();
                var isDelete = window.confirm("是否删除地址[" +index+"]？" );
                if(isDelete){
                    $.ajax({
                        type: "POST",
                        url: "addressAction",
                        data: "pid=" + index + '<%="&"+GlobalConstants.EDIT_ADDRESS_TYPE+"=" + GlobalConstants.ADDRESS_DELETE%>',
                        success: function (msg) {
                            if (msg == 'success') {
                                window.location = "address";
                            } else {
                                alert(msg);
                            }
                        }
                    });
                }
            });

//            // 编辑地址
//            $(".editAddress").click(function(){
//                var index = $(this).find("input").val();
//                var isDelete = window.confirm("是否编辑地址[" +index+"]？" );
//                var formIndex = $(this).attr("id");
//                if(isDelete){
//                    $.ajax({
//                        type: "POST",
//                        url: "editAddress",
//                        data: "",
//                        success: function (msg) {
//                            if (msg == 'success') {
//                                window.location = "address";
//                            } else {
//                                alert(msg);
//                            }
//                        }
//                    });
//                }
//            });

//            $(".editAddress").click(function(){
//            });

            $("#addAddress").click(function(){
                location.href = "editAddress?<%=GlobalConstants.EDIT_ADDRESS_TYPE + "=" + GlobalConstants.ADDRESS_ADD%>";
            });

        });
    </script>

</head>

<body>
<div data-role="page">
    <div data-role="content" class="content">
        <div data-role="header"
             data-position="inline"
             data-backbtn="false">
            <a id="logout" onclick="location.history"
               data-icon="cancle"
               class="ui-btn-left">返回</a>
            <h1>个人外卖地址</h1>

        </div>
        <!-- 地址列表 -->
        <div class="ui-corner-all custom-corners">
            <div class="ui-body ui-body-a ui-bar-self">
                <c:if test="${addresses==null || fn:length(addresses)==0}">
                   <div style="color: RED;text-align: center"> <c:out value="没有外卖地址"/></div>
                </c:if>
                <c:forEach begin="0" step="1" items="${addresses}" var="address" varStatus="status">
                    <form id="form${status.count}">
                        <div id="add${status.count}" class="UI-BODY">
                             <span>外卖地址信息${status.count}:</span>
                             <span id="name${status.index}"><p>${address.clientname}</p>
                             </span>
                             <span id="phone${status.index}"><p>${address.phone}</p>
                             </span>
                             <span id="address${status.index}"><p>${address.address}</p>
                             </span>
                         </div>
                        <div class="addres-func dn">
                            <span class="deleteAddress">删除
                                <input type="hidden"  <%="name=" + GlobalConstants.ADDRESS_DELETE%> value="${address.pid}"/>
                            </span>
                            <span id="${status.count}" class="editAddress" onclick="location.href='editAddress?pid=${address.pid}&name=${address.clientname}&phone=${address.phone}&address=${address.address}&<%=GlobalConstants.EDIT_ADDRESS_TYPE+"="+GlobalConstants.ADDRESS_UPDATE%>'">编辑
                                <input type="hidden" <%="name=" + GlobalConstants.ADDRESS_UPDATE%> value="${address.pid}" />
                            </span>
                         </div>
                    </form>
                </c:forEach>
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
