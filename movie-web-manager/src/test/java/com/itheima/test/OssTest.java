package com.itheima.test;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class OssTest {
    public static void main(String[] args) throws FileNotFoundException {
        // 区域
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";

        //秘钥
        String accessKeyId = "密钥id";
        String accessKeySecret = "密钥";

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 上传文件
        InputStream inputStream = new FileInputStream("C:\\upload\\1.jpg");
        ossClient.putObject("tanhua-gxm", "haha.jpg", inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();
    }
}