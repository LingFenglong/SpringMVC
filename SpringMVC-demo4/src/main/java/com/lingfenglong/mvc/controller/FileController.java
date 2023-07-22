package com.lingfenglong.mvc.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.templateresource.WebApplicationTemplateResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Controller
public class FileController {
    @GetMapping("/file/download/{fileName}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable("fileName") String fileName, HttpSession session) throws IOException {
        System.out.println("fileName: " + fileName);

        Resource resource = new ServletContextResource(session.getServletContext(), "/static/userfile/" + fileName);
        byte[] bytes = resource.getContentAsByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + resource.getFilename());

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(bytes);
    }

    @PostMapping("/file/upload")
    public String uploadFile(MultipartFile userFile, HttpSession session) throws IOException {
        String fileNameToUse = userFile.getOriginalFilename();
        ServletContext servletContext = session.getServletContext();

        Resource resource = new ServletContextResource(servletContext, "/static/userfile");
        File parentFile = resource.getFile();
        if (parentFile.exists() && parentFile.mkdirs()) {
            return "error";
        }

        File file = new File(parentFile.getPath() + File.separator +  fileNameToUse);
        if (file.exists()) {
            fileNameToUse = UUID.randomUUID().toString().replaceAll("-", "") + "-" + fileNameToUse;
        }

        userFile.transferTo(new File(parentFile.getPath() + File.separator + fileNameToUse));
        return "success";
    }
}
