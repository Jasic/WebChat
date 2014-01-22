<%@ page language="java"
         pageEncoding="GBK" %>
<%@ include file="/WEB-INF/views/common/imports.jsp" %>


<tr>
    <td class="item"><h3>���ͺ��룺</h3></td>
    <td class="value">
        <%--<d:select controlName="sendNumSelect" dataSource="dict" dictItem="PHONE_CALL_SEND_TEST" />--%>
        <select id="sendNumSelect"
                name="sendNumSelect">
            <option value="">-��ѡ��-</option>
        </select>
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
              id="sendNumHelp"></span>
    </td>
    <td class="tip">
        <div id="sendNumSelectTip"></div>
        <div id="sendNumTip"></div>
        <div id="expandNumTip"></div>
    </td>
</tr>
<tr>
    <td class="item"><h3>����ʱ�䣺</h3></td>
    <td class="value">
        <%--
        <d:select controlName="schdDateSelect" dataSource="dict" chooseItem="" dictItem="TASK_SCHDTYPE" />
        <label id="schdDateItem" class="dn">�����룺
           <input type="text" class="date w150" readonly="readonly" name="schdDate" id="schdDate" onclick="SelectDate(this)" />
        </label>
        --%>
        <select id="dateType"
                name="dateType">
            <option value="0">��������</option>
            <option value="1">��ʱ����</option>
        </select>
        <label id="dateTypeItem"
               class="dn">��ѡ��
            <input type="text"
                   class="date w150"
                   readonly="readonly"
                   name="schdDate"
                   id="schdDate"
                   onclick="SelectDate(this)"/>
        </label>
    </td>
    <td class="tip">
        <div id="sendDateTip"></div>
    </td>
</tr>
<tr>
    <td class="item"><h3>�Ƿ���к���������</h3></td>
    <td class="value">
        <input name="filterType"
               type="radio"
               value="0"
               checked="checked"/>������
        <input name="filterType"
               type="radio"
               value="2"/>����
    </td>
    <td class="tip">
        <div id="filterTypeTip"></div>
    </td>
</tr>

<tr id="audiorSelectDiv"
    class="dn">
    <td class="item"><h3>���������</h3></td>
    <td class="value">
        <select id="auditor"
                name="auditor">
            <option value="">-��ѡ��-</option>
        </select>
    </td>
    <td class="tip">
        <div id="auditorTip"></div>
    </td>
</tr>

<tr class="dn">
    <td>
        <input type="hidden"
               id="contentType"
               name="contentType"
               value="-1"/>
        <input type="hidden"
               id="sendtimeId"
               name="sendtimeId"
               value="0"/>
        <input type="hidden"
               id="sendDur"
               name="sendDur"
               value="0"/>
        <input type="hidden"
               id="expDate"
               name="expDate"/>
        <b id="precedeDay"
           class="dn">0</b>
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
<c:if test="${not empty dayLeft }">
    <tr>
        <td class="item"><h3>���յ���</h3></td>
        <td class="value">
            ʣ��&nbsp;<span class="red"><strong>${dayLeft }</strong></span>&nbsp;������
            <span class="help"
                  id="dayLeftHelp"></span>
        </td>
        <td class="tip">
            <div id=""></div>
        </td>
    </tr>
</c:if>
