package com.itheima.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

//阿里存储工具类
public class OssUtil {

    //==========================下面五项配置修改成自己的========================//
    //区域
    private static final String endpoint = "oss-cn-beijing.aliyuncs.com";
    //访问id
    private static final String accessKeyId = "密钥id";
    //访问秘钥
    private static final String accessKeySecret = "密钥";
    //桶名称
    private static final String bucketName = "tanhua-zzz";
    //访问URL
    private static final String url = "https://tanhua-zzz.oss-cn-beijing.aliyuncs.com";


    //文件上传
    public static String upload(String fileName, InputStream inputStream) {

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 上传文件流。
        // <yourObjectName>表示上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如 images/2020/11/11/asdf.jpg。
        String objectName = "images/" + new SimpleDateFormat("yyyy/MM/dd").format(new Date())
                + "/" + System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));

        // meta设置请求头,解决访问图片地址直接下载
        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentType(getContentType(fileName.substring(fileName.lastIndexOf("."))));
        ossClient.putObject(bucketName, objectName, inputStream, meta);

        // 关闭OSSClient。
        ossClient.shutdown();

        return url + "/" + objectName;
    }

    public static String getContentType(String FilenameExtension) {
        if (FilenameExtension.equalsIgnoreCase(".bmp")) {
            return "image/bmp";
        }
        if (FilenameExtension.equalsIgnoreCase(".gif")) {
            return "image/gif";
        }
        if (FilenameExtension.equalsIgnoreCase(".jpeg") ||
                FilenameExtension.equalsIgnoreCase(".jpg") ||
                FilenameExtension.equalsIgnoreCase(".png")) {
            return "image/jpg";
        }
        return "image/jpg";
    }

//    public static void main(String[] args) throws FileNotFoundException {
//        System.out.println(upload("1.jpg", new FileInputStream("c:\\upload\\1.jpg")));
//    }
}