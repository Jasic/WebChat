<%@ page language="java"
         pageEncoding="GBK" %>
<%@ include file="/WEB-INF/views/common/imports.jsp" %>

<tr>
    <td class="item"><h3>���ͺ��룺</h3></td>
    <td class="value">
        <%--<d:select controlName="sendNumSelect" dataSource="dict" chooseItem="" dictItem="PHONE_CALL_SEND" />--%>
        <select id="sendNumSelect"
                name="sendNumSelect">
            <option value="">-��ѡ��-</option>
            <option value="10000">10000</option>
            <option value="10001">10001</option>
        </select>
        <input type="hidden"
               id="sendNumSelectStr"
               name="sendNumSelectStr"/>
        <label id="expandNumItem"
               class="dn">��׺��չ��
            <input type="text"
                   name="expandNum"
                   id="expandNum"/>
        </label>
        <label id="customSendNumItem"
               class="dn">�����룺
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
    <td class="item no-border"><h3>�������ͣ�</h3></td>
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
               class="dn">������������Ҫ��ǰ<b id="precedeDay"
                                      class="red"></b>��</label>
    </td>
    <td class="tip no-border">
        <div id="contentTypeTip"></div>
    </td>
</tr>


<tr>
    <td class="item">���Է��ͽ��պ��룺</td>
    <td class="value">
        <input type="text"
               class="w200"
               name="testRecvNum"
               id="testRecvNum"/>
        <button type="button"
                id="testButton"
                class="default-button"
                onclick="testSend();">����
        </button>
        <span class="help"
              id="testRecvNumHelp"></span>
    </td>
    <td class="tip">
        <div id="testRecvNumTip"></div>
    </td>
</tr>


<tr>
    <td class="item"><h3>������ϵ�ˣ�</h3></td>
    <td class="value"><input type="text"
                             class="w200"
                             name="contactUser"
                             id="contactUser"/></td>
    <td class="tip">
        <div id="contactUserTip"></div>
    </td>
</tr>
<tr>
    <td class="item"><h3>��ϵ�˵绰��</h3></td>
    <td class="value"><input type="text"
                             class="w200"
                             name="contactPhone"
                             id="contactPhone"/></td>
    <td class="tip">
        <div id="contactPhoneTip"></div>
    </td>
</tr>
<tr>
    <td class="item"><h3>����У���룺</h3></td>
    <td class="value">
        <input type="text"
               class="w200"
               name="smsValidateCode"
               id="smsValidateCode"/>
        <input type="button"
               class="msgValidator"
               id="msgValidator"
               title="�����ȡ�ֻ���֤��"/>
    </td>
    <td class="tip">
        <div id="smsValidateCodeTip"></div>
    </td>
</tr>
