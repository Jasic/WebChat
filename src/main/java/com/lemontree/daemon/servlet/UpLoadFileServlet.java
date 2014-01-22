package com.lemontree.daemon.servlet;

import com.lemontree.util.FileUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by JasicMacBook on 13-12-15.
 */
public class UpLoadFileServlet extends HttpServlet {

    public static String UNZIP_FILE_DIR = "/tmp/test";
    public static String UNZIP_FILE_SUFFIX = ".zip";

    private static Logger logger = LoggerFactory.getLogger(UpLoadFileServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);

        if (!isMultipart) {
            return;
        }

        resp.setCharacterEncoding("UTF-8");
        // Create a factory for disk-based file items
        File temp = new File(UNZIP_FILE_DIR + "/temp");
        temp.mkdirs();

        DiskFileItemFactory factory = new DiskFileItemFactory(10240, temp);

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Set overall request size constraint,no limited
        upload.setSizeMax(-1);

        // Parse the request
        try {
            List<FileItem> items = upload.parseRequest(req);
            // Process the uploaded items
            Iterator<FileItem> iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = iter.next();

                if (!item.isFormField()) {
                    String fileName = item.getName();
                    File iFile = new File(UNZIP_FILE_DIR + "/recv/" + fileName);
                    if (!iFile.exists()) {

                        iFile.getParentFile().mkdirs();
                        iFile.createNewFile();
                    }
                    logger.info(fileName);
                    item.write(iFile);

                    resp.getWriter().append("上传文件[" + iFile.getName() + "]成功\n");

                    if (fileName.toLowerCase().endsWith(UNZIP_FILE_SUFFIX)) {

                        File destFile = new File(UNZIP_FILE_DIR + "/unzip/" + fileName.replace(UNZIP_FILE_SUFFIX, ""));
                        destFile.mkdirs();

                        boolean unzip = FileUtil.unzip(iFile, destFile);
                        if (unzip) {
                            resp.getWriter().append("解压缩[" + fileName + "]成功\n");
                        } else {
                            resp.getWriter().append("解压缩[" + fileName + "]失败\n");
                        }
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.getWriter().flush();
    }

}
