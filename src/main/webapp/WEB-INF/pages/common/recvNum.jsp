<%@ page language="java"
         pageEncoding="GBK" %>

<tr>
    <td class="item"><h3>���պ��룺</h3></td>
    <td class="value">
        <input type="hidden"
               id="recvNumType"
               value="1"/>

        <div class="tabs-area"
             id="recvNumTabs">
            <ul class="tabs-menu">
                <li class="current"
                    id="recvNumType_1">ֱ������
                </li>
                <li class="seq"
                    id="recvNumType_2">�ϴ��ļ�
                </li>
                <li class=""
                    id="recvNumType_3">�б���
                </li>
            </ul>
            <div class="tabs-box">
                <div>
                    <div class="file-upload-queue center">
                        <div class="file-upload-header file-name">��������ĺ������������պ���</div>
                        <div class="file-upload-content long">
                            <textarea rows="3"
                                      cols="50"
                                      class="num"
                                      name="recvNumText"
                                      id="recvNumText"></textarea>
                        </div>
                        <div class="file-upload-desc">��ʾ: ֻ������c������</div>
                    </div>
                </div>
                <div class="hide">
                    <div class="file-upload-queue center">
                        <div class="file-upload-header">
                            <div class="l file-name">�ļ���</div>
                            <div class="r file-size">״̬</div>
                            <div class="r file-status">��С</div>
                        </div>
                        <div class="file-upload-content"
                             id="numFileUploadQueue"></div>
                        <div class="file-upload-opt">
                            <div class="l upload-btn-wrapper">
                              <span class="l upload-button add">ѡ���ļ�
                                <input type="file"
                                       name="numFileUpload"
                                       id="numFileUpload"
                                       class="dn"/>
                              </span>
                                <button type="button"
                                        class="l upload-button-w80 upload"
                                        id="numFileUploadStart">��ʼ�ϴ�
                                </button>
                            </div>
                            <button type="button"
                                    id="_clearNumfile_button"
                                    class="l upload-button-w60 clear">��&nbsp;��
                            </button>
                            <div id="numFileTotalPercent"
                                 class="r file-status clearfix">0%
                            </div>
                            <div id="numFileTotalSize"
                                 class="r file-size">0KB
                            </div>
                        </div>
                        <div class="file-upload-desc">��ʾ: �����ϴ� 3���ļ���ֻ�����ϴ�����500M��txt�ļ�</div>
                    </div>
                </div>
                <div class="hide">
                    <div class="red pt20 dn">�ݲ�֧��</div>
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
                            <div class="l file-name w120">�������</div>
                            <div class="l file-size w50">��������</div>
                            <div class="l file-name">���������</div>
                        </div>
                        <div class="file-upload-content"
                             id="numpackage-items-content">
                        </div>
                        <div class="file-upload-opt">
                            <div class="l upload-btn-wrapper">
                                <a href="javascript:;"
                                   onclick="loadPackageInfo();"
                                   class="l upload-button add">ѡ���ļ� </a>
                            </div>
                            <div id="numCount"
                                 class="r file-size">0
                            </div>
                            <div id="file_upload_per"
                                 class="r file-status clearfix">&nbsp;</div>
                        </div>
                        <div class="file-upload-desc">��ʾ: �ӷ������ϱ�����ļ��б���ѡ����룬���25��<input type="hidden"
                                                                                        id="surCount"
                                                                                        value="25"/></div>
                    </div>
                </div>
            </div>
        </div>
        <span class="help"
              id="recvNumHelp"></span>
        <br/><span class="red">
                  ��ܰ��ʾ:��Ϊ����ϵͳ����������һЩ�µļ���,����������Ҷ��ϰ汾�Ĳ�Ʒ(����:(IE 6,IE 7))�Ѿ�ֹͣ����֧��,�Բ����µĹ��ܲ�����Ч����.���Բ��ð汾�ɵ��������Դ���ճ�ʹ�����һ����Ӱ��(���ϴ��ļ���,�������Ӧ�������ڸ������).Ŀǰ��Ŀ�����ڵ�½ҳ�沿������������ع���.�����������������������,��������ʹ��!��л��Ҷ����ǹ�����֧��!
                  </span>
    </td>
    <td class="tip">
        <div id="recvNumTip"></div>
    </td>
</tr>
