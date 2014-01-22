<%@ page language="java"
         pageEncoding="GBK" %>
<%@ include file="/WEB-INF/views/common/imports.jsp" %>

<tr>
    <td colspan="3"
        class="step-bg"><h1 class="step-title">填写流程管控信息</h1></td>
</tr>
<tr>
    <td class="item"><h3>发送时间：</h3></td>
    <td class="value">
        <input type="text"
               class="date w150"
               readonly="readonly"
               name="schdDate"
               id="schdDate"
               onclick="SelectDate(this)"
               onchange="dateControlChange(this)"/> 至
        <input type="text"
               class="date w150"
               readonly="readonly"
               name="expDate"
               id="expDate"
               onclick="SelectDate(this)"/>
        <span class="help"
              id="sendDateHelp"></span>
    </td>
    <td class="tip">
        <div id="sendDateTip"></div>
    </td>
</tr>

<tr class="dn">
    <td class="item"><h3>日发送时间段：</h3></td>
    <td class="value">
        <input type="radio"
               name="sendtimeId"
               value="1"
               checked="checked"/>&nbsp;系统默认
        <input type="radio"
               name="sendtimeId"
               value="0"/>&nbsp;24小时
        <span class="help"
              id="sendTimeHelp"></span>
    </td>
    <td class="tip">
        <div id="sendtimeIdTip"></div>
    </td>
</tr>

<tr>
    <td class="item"><h3>发送速率：</h3></td>
    <td class="value">
        <select name="sendDurSelect"
                id="sendDurSelect">
            <option value="0">系统默认速率</option>
            <option value="-1">自定义速率</option>
        </select>
        <label id="customSendDurItem"
               class="dn">请输入发送时长
            <input type="text"
                   class="w50"
                   name="sendDur"
                   id="sendDur"
                   value="0"/> 小时
            &nbsp;转换后&nbsp;发送时长：<span class="tip blue"
                                      id="sendDurTransformTip"></span>
        </label>
        <span class="help"
              id="sendDurHelp"></span>
    </td>
    <td class="tip">
        <div id="sendDurTip"></div>
    </td>
</tr>
        
