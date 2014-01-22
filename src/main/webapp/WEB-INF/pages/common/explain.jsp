<%@ page language="java"
         pageEncoding="GBK" %>

<tr>
    <td colspan="3"
        class="step-bg"><h1 class="step-title">��д�ͷ���Ϣ</h1></td>
</tr>
<tr>
    <td class="item">�ͷ�������</td>
    <td class="value">
        <div class="file-upload-queue">
            <div class="file-upload-header">
                <div class="l file-name">�ļ���</div>
                <div class="r file-size">״̬</div>
                <div class="r file-status">��С</div>
            </div>
            <div class="file-upload-content"
                 id="explainDescFileUploadQueue"></div>
            <div class="file-upload-opt">
                <div class="l upload-btn-wrapper">
                        <span class="l upload-button add">ѡ���ļ�
                          <input type="file"
                                 name="explainDescFileUpload"
                                 id="explainDescFileUpload"/>
                        </span>
                    <button type="button"
                            class="l upload-button-w80 upload"
                            id="explainDescFileUploadStart">��ʼ�ϴ�
                    </button>
                </div>
                <button type="button"
                        id="_clearExplain_button"
                        class="l upload-button-w60 clear">��&nbsp;��
                </button>
                <div id="explainDescFileTotalPercent"
                     class="r file-status clearfix">0%
                </div>
                <div id="explainDescFileTotalSize"
                     class="r file-size">0KB
                </div>
            </div>
            <div class="file-upload-desc">��ʾ�������ϴ�3���ļ���ֻ�����ϴ�����50M���ļ�</div>
        </div>
    </td>
    <td class="tip">
        <div id="explainDescFileTip"></div>
    </td>
</tr>
<tr>
    <td class="item"><h3>���Ͷ���ɸѡ���ݣ�</h3></td>
    <td class="value"><input type="text"
                             class="w200"
                             name="userDesc"
                             id="userDesc"/></td>
    <td class="tip">
        <div id="userDescTip"></div>
    </td>
</tr>
<tr>
    <td class="item"><h3>����������</h3></td>
    <td class="value">
        <input type="text"
               class="w200"
               name="taskDesc"
               id="taskDesc"/>
        <input type="hidden"
               name="isTest"
               id="isTest"
               value="false"/>
    </td>
    <td class="tip">
        <div id="taskDescTip"></div>
    </td>
</tr>
