<%@ page language="java"
         pageEncoding="GBK" %>
<%@ include file="/WEB-INF/views/common/imports.jsp" %>

<tr>
    <td class="item"><h3>发送号码：</h3></td>
    <td class="value">
        <%--<d:select controlName="sendNumSelect" dataSource="dict" chooseItem="" dictItem="PHONE_CALL_SEND" />--%>
        <select id="sendNumSelect"
                name="sendNumSelect">
            <option value="">-请选择-</option>
            <option value="10000">10000</option>
            <option value="10001">10001</option>
        </select>
        <input type="hidden"
               id="sendNumSelectStr"
               name="sendNumSelectStr"/>
        <label id="expandNumItem"
               class="dn">后缀扩展：
            <input type="text"
                   name="expandNum"
                   id="expandNum"/>
        </label>
        <label id="customSendNumItem"
               class="dn">请输入：
            <input type="text"
                   name="sendNum"
                   id="sendNum"/>
        </label>
        <span class="help"
              id="sendNumSelectHelp"></span>
    </td>
    <td class="tip">
        <div id="sendNumSelectTip"></div>
        <div id="sendNumTip"></div>
        <div id="expandNumTip"></div>
    </td>
</tr>

<tr>
    <td class="item no-border"><h3>内容类型：</h3></td>
    <td class="value no-border">
        <d:select controlName="contentType"
                  dataSource="scContentTypeList"
                  chooseItem=""
                  keyColumn="id"
                  valueColumn="contentType"
                  relateColumn="precedeDay"/>
        <span class="help"
              id="contentTypeHelp"></span>
        <label id="contentTypeTipItem"
               class="dn">此内容类型需要提前<b id="precedeDay"
                                      class="red"></b>天</label>
    </td>
    <td class="tip no-border">
        <div id="contentTypeTip"></div>
    </td>
</tr>


<tr>
    <td class="item">测试发送接收号码：</td>
    <td class="value">
        <input type="text"
               class="w200"
               name="testRecvNum"
               id="testRecvNum"/>
        <button type="button"
                id="testButton"
                class="default-button"
                onclick="testSend();">测试
        </button>
        <span class="help"
              id="testRecvNumHelp"></span>
    </td>
    <td class="tip">
        <div id="testRecvNumTip"></div>
    </td>
</tr>


<tr>
    <td class="item"><h3>任务联系人：</h3></td>
    <td class="value"><input type="text"
                             class="w200"
                             name="contactUser"
                             id="contactUser"/></td>
    <td class="tip">
        <div id="contactUserTip"></div>
    </td>
</tr>
<tr>
    <td class="item"><h3>联系人电话：</h3></td>
    <td class="value"><input type="text"
                             class="w200"
                             name="contactPhone"
                             id="contactPhone"/></td>
    <td class="tip">
        <div id="contactPhoneTip"></div>
    </td>
</tr>
<tr>
    <td class="item"><h3>短信校验码：</h3></td>
    <td class="value">
        <input type="text"
               class="w200"
               name="smsValidateCode"
               id="smsValidateCode"/>
        <input type="button"
               class="msgValidator"
               id="msgValidator"
               title="点击获取手机验证码"/>
    </td>
    <td class="tip">
        <div id="smsValidateCodeTip"></div>
    </td>
</tr>
