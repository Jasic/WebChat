<%@ page language="java"
         pageEncoding="GBK" %>
<%@ include file="/WEB-INF/views/common/imports.jsp" %>

<script type="text/javascript">

    // 初始化页面
    $(document).ready(function () {
        // 下载客服附件
        $("span[id='_downloadAttachment']").click(function () {
            var path = $(this).closest(".queue-file").find("#attachmentPath").val();
            var outName = $(this).text();
            _downloadFile(path, outName);
        });
    });

</script>

<tr>
    <td class="item">客服文件下载:</td>
    <td colspan="2"
        class="detail">
        <c:if test="${not empty tFlmAttachmentList}">
            <c:forEach items="${tFlmAttachmentList}"
                       var="tFlmAttachment"
                       varStatus="s">
                <div class="queue-file">
                      <span id="_downloadAttachment"
                            class="opt-span">
                        <c:if test="${not empty tFlmAttachment.origName}"> ${tFlmAttachment.origName} </c:if>
                        <c:if test="${empty tFlmAttachment.origName}"> ${tFlmAttachment.currName} </c:if>
                      </span>
                    <input type="hidden"
                           id="attachmentPath"
                           disabled="disabled"
                           value="${tFlmAttachment.realPath}/${tFlmAttachment.currName}"/>
                </div>
            </c:forEach>
        </c:if>
        <c:if test="${empty tFlmAttachmentList}">无 </c:if>
    </td>
</tr>
