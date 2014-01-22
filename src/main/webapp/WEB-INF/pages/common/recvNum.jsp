<%@ page language="java"
         pageEncoding="GBK" %>

<tr>
    <td class="item"><h3>接收号码：</h3></td>
    <td class="value">
        <input type="hidden"
               id="recvNumType"
               value="1"/>

        <div class="tabs-area"
             id="recvNumTabs">
            <ul class="tabs-menu">
                <li class="current"
                    id="recvNumType_1">直接输入
                </li>
                <li class="seq"
                    id="recvNumType_2">上传文件
                </li>
                <li class=""
                    id="recvNumType_3">列表导入
                </li>
            </ul>
            <div class="tabs-box">
                <div>
                    <div class="file-upload-queue center">
                        <div class="file-upload-header file-name">请在下面的号码框中输入接收号码</div>
                        <div class="file-upload-content long">
                            <textarea rows="3"
                                      cols="50"
                                      class="num"
                                      name="recvNumText"
                                      id="recvNumText"></textarea>
                        </div>
                        <div class="file-upload-desc">提示: 只能输入c网号码</div>
                    </div>
                </div>
                <div class="hide">
                    <div class="file-upload-queue center">
                        <div class="file-upload-header">
                            <div class="l file-name">文件名</div>
                            <div class="r file-size">状态</div>
                            <div class="r file-status">大小</div>
                        </div>
                        <div class="file-upload-content"
                             id="numFileUploadQueue"></div>
                        <div class="file-upload-opt">
                            <div class="l upload-btn-wrapper">
                              <span class="l upload-button add">选择文件
                                <input type="file"
                                       name="numFileUpload"
                                       id="numFileUpload"
                                       class="dn"/>
                              </span>
                                <button type="button"
                                        class="l upload-button-w80 upload"
                                        id="numFileUploadStart">开始上传
                                </button>
                            </div>
                            <button type="button"
                                    id="_clearNumfile_button"
                                    class="l upload-button-w60 clear">清&nbsp;空
                            </button>
                            <div id="numFileTotalPercent"
                                 class="r file-status clearfix">0%
                            </div>
                            <div id="numFileTotalSize"
                                 class="r file-size">0KB
                            </div>
                        </div>
                        <div class="file-upload-desc">提示: 最多可上传 3个文件，只允许上传少于500M的txt文件</div>
                    </div>
                </div>
                <div class="hide">
                    <div class="red pt20 dn">暂不支持</div>
                    <input type="hidden"
                           id="selectItems"
                           name="selectItems"
                           value=""/>
                    <input type="hidden"
                           id="pkgNameStr"
                           name="pkgNameStr"
                           value=""/>
                    <input type="hidden"
                           id="pkgDescStr"
                           name="pkgDescStr"
                           value=""/>
                    <input type="hidden"
                           id="numCountStr"
                           name="numCountStr"
                           value=""/>

                    <div class="file-upload-queue center">
                        <div class="file-upload-header">
                            <div class="l file-name w120">号码包名</div>
                            <div class="l file-size w50">号码数量</div>
                            <div class="l file-name">号码包描述</div>
                        </div>
                        <div class="file-upload-content"
                             id="numpackage-items-content">
                        </div>
                        <div class="file-upload-opt">
                            <div class="l upload-btn-wrapper">
                                <a href="javascript:;"
                                   onclick="loadPackageInfo();"
                                   class="l upload-button add">选择文件 </a>
                            </div>
                            <div id="numCount"
                                 class="r file-size">0
                            </div>
                            <div id="file_upload_per"
                                 class="r file-status clearfix">&nbsp;</div>
                        </div>
                        <div class="file-upload-desc">提示: 从服务器上保存的文件列表中选择号码，最多25个<input type="hidden"
                                                                                        id="surCount"
                                                                                        value="25"/></div>
                    </div>
                </div>
            </div>
        </div>
        <span class="help"
              id="recvNumHelp"></span>
        <br/><span class="red">
                  温馨提示:因为本次系统升级采用了一些新的技术,但浏览器厂家对老版本的产品(例如:(IE 6,IE 7))已经停止技术支撑,对部分新的功能不能有效兼容.所以采用版本旧的浏览器会对大家日常使用造成一定的影响(如上传文件慢,浏览器反应慢都属于该类情况).目前项目组已在登陆页面部署了浏览器下载功能.如果您的浏览器出现以上情况,可以下载使用!感谢大家对我们工作的支持!
                  </span>
    </td>
    <td class="tip">
        <div id="recvNumTip"></div>
    </td>
</tr>
