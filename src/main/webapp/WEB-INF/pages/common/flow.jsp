<%@ page language="java"
         pageEncoding="GBK" %>
<%@ include file="/WEB-INF/views/common/imports.jsp" %>

<tr>
    <td colspan="3"
        class="step-bg"><h1 class="step-title">��д���̹ܿ���Ϣ</h1></td>
</tr>
<tr>
    <td class="item"><h3>����ʱ�䣺</h3></td>
    <td class="value">
        <input type="text"
               class="date w150"
               readonly="readonly"
               name="schdDate"
               id="schdDate"
               onclick="SelectDate(this)"
               onchange="dateControlChange(this)"/> ��
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
    <td class="item"><h3>�շ���ʱ��Σ�</h3></td>
    <td class="value">
        <input type="radio"
               name="sendtimeId"
               value="1"
               checked="checked"/>&nbsp;ϵͳĬ��
        <input type="radio"
               name="sendtimeId"
               value="0"/>&nbsp;24Сʱ
        <span class="help"
              id="sendTimeHelp"></span>
    </td>
    <td class="tip">
        <div id="sendtimeIdTip"></div>
    </td>
</tr>

<tr>
    <td class="item"><h3>�������ʣ�</h3></td>
    <td class="value">
        <select name="sendDurSelect"
                id="sendDurSelect">
            <option value="0">ϵͳĬ������</option>
            <option value="-1">�Զ�������</option>
        </select>
        <label id="customSendDurItem"
               class="dn">�����뷢��ʱ��
            <input type="text"
                   class="w50"
                   name="sendDur"
                   id="sendDur"
                   value="0"/> Сʱ
            &nbsp;ת����&nbsp;����ʱ����<span class="tip blue"
                                      id="sendDurTransformTip"></span>
        </label>
        <span class="help"
              id="sendDurHelp"></span>
    </td>
    <td class="tip">
        <div id="sendDurTip"></div>
    </td>
</tr>
        
