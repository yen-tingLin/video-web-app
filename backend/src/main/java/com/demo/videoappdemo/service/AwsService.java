package com.demo.videoappdemo.service;

import org.springframework.web.multipart.MultipartFile;

public class AwsService implements FileService {

    @Override
    public String uploadFile(MultipartFile file) {
        // Upload file to AWS S3
        return "";
    }
}
