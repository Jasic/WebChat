<%@ page language="java"
         pageEncoding="GBK" %>

<tr>
    <td colspan="3"
        class="step-bg"><h1 class="step-title">填写客服信息</h1></td>
</tr>
<tr>
    <td class="item">客服附件：</td>
    <td class="value">
        <div class="file-upload-queue">
            <div class="file-upload-header">
                <div class="l file-name">文件名</div>
                <div class="r file-size">状态</div>
                <div class="r file-status">大小</div>
            </div>
            <div class="file-upload-content"
                 id="explainDescFileUploadQueue"></div>
            <div class="file-upload-opt">
                <div class="l upload-btn-wrapper">
                        <span class="l upload-button add">选择文件
                          <input type="file"
                                 name="explainDescFileUpload"
                                 id="explainDescFileUpload"/>
                        </span>
                    <button type="button"
                            class="l upload-button-w80 upload"
                            id="explainDescFileUploadStart">开始上传
                    </button>
                </div>
                <button type="button"
                        id="_clearExplain_button"
                        class="l upload-button-w60 clear">清&nbsp;空
                </button>
                <div id="explainDescFileTotalPercent"
                     class="r file-status clearfix">0%
                </div>
                <div id="explainDescFileTotalSize"
                     class="r file-size">0KB
                </div>
            </div>
            <div class="file-upload-desc">提示：最多可上传3个文件，只允许上传少于50M的文件</div>
        </div>
    </td>
    <td class="tip">
        <div id="explainDescFileTip"></div>
    </td>
</tr>
<tr>
    <td class="item"><h3>发送对象筛选依据：</h3></td>
    <td class="value"><input type="text"
                             class="w200"
                             name="userDesc"
                             id="userDesc"/></td>
    <td class="tip">
        <div id="userDescTip"></div>
    </td>
</tr>
<tr>
    <td class="item"><h3>任务描述：</h3></td>
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
