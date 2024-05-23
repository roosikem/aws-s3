package com.codeforcoder.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("spring.cloud.aws")
public class AwsProperties {
    @Value("${spring.cloud.aws.region.static}")
    private String region;
    @Value("${spring.cloud.aws.credentials.access-key}")
    private String access;

    @Value("${spring.cloud.aws.credentials.secret-key}")
    private String secret;

    @Value("${spring.cloud.aws.s3.bucket}")
    private String bucket;

}

