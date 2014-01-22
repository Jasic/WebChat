<%@ page language="java"
         pageEncoding="GBK" %>
<%@ include file="/WEB-INF/views/common/imports.jsp" %>


<tr>
    <td class="item"><h3>发送号码：</h3></td>
    <td class="value">
        <%--<d:select controlName="sendNumSelect" dataSource="dict" dictItem="PHONE_CALL_SEND_TEST" />--%>
        <select id="sendNumSelect"
                name="sendNumSelect">
            <option value="">-请选择-</option>
        </select>
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
              id="sendNumHelp"></span>
    </td>
    <td class="tip">
        <div id="sendNumSelectTip"></div>
        <div id="sendNumTip"></div>
        <div id="expandNumTip"></div>
    </td>
</tr>
<tr>
    <td class="item"><h3>发送时间：</h3></td>
    <td class="value">
        <%--
        <d:select controlName="schdDateSelect" dataSource="dict" chooseItem="" dictItem="TASK_SCHDTYPE" />
        <label id="schdDateItem" class="dn">请输入：
           <input type="text" class="date w150" readonly="readonly" name="schdDate" id="schdDate" onclick="SelectDate(this)" />
        </label>
        --%>
        <select id="dateType"
                name="dateType">
            <option value="0">立即发送</option>
            <option value="1">定时发送</option>
        </select>
        <label id="dateTypeItem"
               class="dn">请选择：
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
    <td class="item"><h3>是否进行黑名单过滤</h3></td>
    <td class="value">
        <input name="filterType"
               type="radio"
               value="0"
               checked="checked"/>不过滤
        <input name="filterType"
               type="radio"
               value="2"/>过滤
    </td>
    <td class="tip">
        <div id="filterTypeTip"></div>
    </td>
</tr>

<tr id="audiorSelectDiv"
    class="dn">
    <td class="item"><h3>短信审核人</h3></td>
    <td class="value">
        <select id="auditor"
                name="auditor">
            <option value="">-请选择-</option>
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
<c:if test="${not empty dayLeft }">
    <tr>
        <td class="item"><h3>今日的余额：</h3></td>
        <td class="value">
            剩余&nbsp;<span class="red"><strong>${dayLeft }</strong></span>&nbsp;条短信
            <span class="help"
                  id="dayLeftHelp"></span>
        </td>
        <td class="tip">
            <div id=""></div>
        </td>
    </tr>
</c:if>
