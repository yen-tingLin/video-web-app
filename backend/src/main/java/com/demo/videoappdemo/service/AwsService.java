package com.demo.videoappdemo.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AwsService implements FileService {

    public static final String BUCKET_NAME = "lyns-projects";
    private final AmazonS3Client awsS3Client;

    @Override
    public String uploadFile(MultipartFile file) {

        // Prepare a key for a file
        String fileNameExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());
        String key = UUID.randomUUID().toString() + "." + fileNameExtension;

        ObjectMetadata mataData = new ObjectMetadata();
        mataData.setContentLength(file.getSize());
        mataData.setContentType(file.getContentType());

        try {
            awsS3Client.putObject(BUCKET_NAME, key, file.getInputStream(), mataData);
        } catch(IOException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Failed to upload the file");
        }

        awsS3Client.setObjectAcl(BUCKET_NAME, key, CannedAccessControlList.PublicRead);

        return awsS3Client.getResourceUrl(BUCKET_NAME, key);
    }
}
