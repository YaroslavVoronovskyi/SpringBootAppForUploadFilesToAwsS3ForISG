package com.gmail.voronovskyi.yaroslav.isg.awss3.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.gmail.voronovskyi.yaroslav.isg.awss3.config.AWSClientConfig;
import com.gmail.voronovskyi.yaroslav.isg.awss3.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final AmazonS3 amazonS3;
    private final AWSClientConfig awsClientConfig;

    @Override
    public String upload(MultipartFile file) {
        File localFile = convertMultipartFileToFile(file);
        amazonS3.putObject(new PutObjectRequest(awsClientConfig.getBucketName(), file.getOriginalFilename(), localFile));
        return file.getOriginalFilename();
    }

    private File convertMultipartFileToFile(MultipartFile file) {
        File convertedFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            Files.copy(file.getInputStream(), convertedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return convertedFile;
    }
}
