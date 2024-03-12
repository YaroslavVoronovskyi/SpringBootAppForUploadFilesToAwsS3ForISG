package com.gmail.voronovskyi.yaroslav.isg.awss3.service;

import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {

    String upload(MultipartFile file);
}
