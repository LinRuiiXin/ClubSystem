package com.lx.utils;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.File;

public class ServletFileUploadUtil {
    public static ServletFileUpload getServletFileUpload(){
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        File file = new File("D:/upload");
        if(!file.exists()){
            file.mkdir();
        }
        fileItemFactory.setRepository(file);
        fileItemFactory.setSizeThreshold(1024*1024*5);
        ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
        fileUpload.setFileSizeMax(1024*1024*10);
        return fileUpload;
    }
}
