package com.hr.controller;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/fileupload1")
    public String fileupload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传...");

        //使用fileupload组件完成文件上传

        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if(!file.exists()) {
            file.mkdirs();
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = upload.parseRequest(request);
        for(FileItem item : items) {
            //判断当前item对象是不是上传文件项(可能是表单项)
            if(item.isFormField()) {
                //表单项
            }else {
                //上传文件项
                //获取上传文件的名称
                String fileName = item.getName();
                //把文件的名称设置为唯一的值
                String uuid = UUID.randomUUID().toString().replace("-", "");
                fileName = uuid + "_" + fileName;
                //完成文件上传
                item.write(new File(path,fileName));
                //删除临时文件
                item.delete();
            }
        }
        return "success";
    }

    /**
     * SpringMvc提供了MultipartFile对象,该对象表示上传的文件,要求变量名称必须和表单file标签的name属性名称相同
     *
     */
    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("springmvc文件上传...");
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if(!file.exists()) {
            file.mkdirs();
        }

        String fileName = upload.getOriginalFilename();
        //把文件的名称设置为唯一的值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "_" + fileName;
        //完成文件上传
        upload.transferTo(new File(path,fileName));

        return "success";
    }


    /**
     *跨服务器文件上传
     */
    @RequestMapping("/fileupload3")
    public String fileupload3(MultipartFile upload) throws Exception {
        System.out.println("跨服务器文件上传...");

        //定义上传文件服务器路径
        String path = "http://localhost:9090/fileuploadserver_war_exploded/uploads/";

        String fileName = upload.getOriginalFilename();
        //把文件的名称设置为唯一的值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "_" + fileName;
        //完成文件上传, 跨服务器上传
        //创建客户端对象
        Client client = new Client();
        //和上传服务器进行连接
        WebResource webResource = client.resource(path + fileName);
        //上传文件
        webResource.put(upload.getBytes());


        return "success";
    }



}
