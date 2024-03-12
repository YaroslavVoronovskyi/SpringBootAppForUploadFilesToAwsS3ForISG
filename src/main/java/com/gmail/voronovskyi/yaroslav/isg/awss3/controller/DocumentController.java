package com.gmail.voronovskyi.yaroslav.isg.awss3.controller;

import com.gmail.voronovskyi.yaroslav.isg.awss3.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping("/upload")
    public void saveImage(@RequestParam("file") MultipartFile file) {
        documentService.upload(file);
    }
}
