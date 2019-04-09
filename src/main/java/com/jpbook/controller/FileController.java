package com.jpbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileController {
    @RequestMapping("TestFile")
    @ResponseBody
    public Integer TestFile(MultipartFile file) throws IllegalStateException, IOException {
        String originalFilename = file.getOriginalFilename();
        if (!file.isEmpty()) {
            // 文件保存路径
            String filePath = "F:\\PICS\\" + file.getOriginalFilename();
            // 转存文件
            file.transferTo(new File(filePath));
        }
        return 1;
    }
}
