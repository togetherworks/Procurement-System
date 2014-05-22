package com.ncs.iframe4.ps.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;


public class RegisterUploadAction implements Serializable {



    private static final long serialVersionUID = 1L;
    //get upload all upload files
    private List fileList = new ArrayList();
    //single saved file name for upload or download
    private String saveFileName = null;

    private String name;
    private String sex;
    private String password;
    private String email;
    private String imagePath;


    public RegisterUploadAction() {
        this.sex = "Male";
    }

    public String getSaveFileName() {
        return saveFileName;
    }

    public void setSaveFileName(String saveFileName) {
        this.saveFileName = saveFileName;
    }

    public List getFileList() {
        return fileList;
    }

    public void setFileList(List fileList) {
        this.fileList = fileList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


    /**
     *
     */

    public String register() {

        FacesContext context = FacesContext.getCurrentInstance();
        String savePath = System.getProperty("java.io.tmpdir") + File.separator;
        for (int i = 0; i < fileList.size(); i++) {
            FileItem fileItem = (FileItem) fileList.get(i);
            if (fileItem.getName() != null && !fileItem.getName().equals("")) {
                //set to  saveFileName attribute
                saveFileName= processFileName(fileItem.getName());
                savePath = savePath + saveFileName;
                try {
                    fileItem.write(new File(savePath));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return "uploadSuccess";
    }

    private String processFileName(String fileName) {
        if (fileName.indexOf(File.separator) > -1) {
            return fileName.substring(fileName.lastIndexOf(File.separator) + 1, fileName.length());
        } else {
            return fileName;
        }
    }


    public String download() {
        Map paramMaps = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String fileName = (String) paramMaps.get("fileName");   //get from page parameter
        String path = System.getProperty("java.io.tmpdir") + File.separator;
        try {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.responseComplete();
            String contentType = "application/x-download";
            HttpServletResponse response = (HttpServletResponse) ctx.getExternalContext().getResponse();
            response.setContentType(contentType);
            StringBuffer contentDisposition = new StringBuffer();
            contentDisposition.append("attachment;");
            contentDisposition.append("filename=\"");
            contentDisposition.append(fileName);
            contentDisposition.append("\"");
            response.setHeader("Content-Disposition", new String(contentDisposition.toString().getBytes(System.getProperty("file.encoding")), "iso8859_1"));
            ServletOutputStream out = response.getOutputStream();
            byte[] bytes = new byte[0xffff];
            InputStream is = new FileInputStream(new File(path + fileName));
            int b = 0;
            while ((b = is.read(bytes, 0, 0xffff)) > 0) {
                out.write(bytes, 0, b);
            }
            is.close();
            out.flush();
            ctx.responseComplete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
