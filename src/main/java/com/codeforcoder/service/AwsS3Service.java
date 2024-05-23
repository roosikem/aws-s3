package com.codeforcoder.service;

import com.codeforcoder.config.AwsProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class AwsS3Service {

    private final S3Client s3Client;
    private final AwsProperties awsProperties;

    public AwsS3Service(@Qualifier("s3Client") S3Client s3Client, AwsProperties awsProperties) {
        this.s3Client = s3Client;
        this.awsProperties = awsProperties;
    }

    public String uploadJsonData(String key, String jsonData) {

        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(awsProperties.getBucket())
                .key(key)
                .contentType("application/json")
                .build();

        s3Client.putObject(putObjectRequest, RequestBody.fromBytes(jsonData.getBytes())
                );
        return key;
    }
}

