package com.codeforcoder.controller;

import com.codeforcoder.service.AwsS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AwsS3Controller {

    @Autowired
    AwsS3Service awsS3Service;

    @GetMapping
    public String awsUpload() {
        String g = "[\n" +
                "    {\n" +
                "        \"name\": \"firstName\",\n" +
                "        \"type\": \"string\",\n" +
                "        \"value\": \"\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"lastName\",\n" +
                "        \"type\": \"string\",\n" +
                "        \"value\": \"\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"age\",\n" +
                "        \"type\": \"number\",\n" +
                "        \"value\": null\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"isStudent\",\n" +
                "        \"type\": \"boolean\",\n" +
                "        \"value\": false\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"address\",\n" +
                "        \"type\": \"object\",\n" +
                "        \"fields\": [\n" +
                "            {\n" +
                "                \"name\": \"street\",\n" +
                "                \"type\": \"string\",\n" +
                "                \"value\": \"\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"city\",\n" +
                "                \"type\": \"string\",\n" +
                "                \"value\": \"\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"zipcode\",\n" +
                "                \"type\": \"string\",\n" +
                "                \"value\": \"\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"hobbies\",\n" +
                "        \"type\": \"array\",\n" +
                "        \"items\": {\n" +
                "            \"type\": \"string\",\n" +
                "            \"value\": \"\"\n" +
                "        }\n" +
                "    }\n" +
                "]";

        awsS3Service.uploadJsonData("my.json", g);
        return "SUCCESS";
    }
}
