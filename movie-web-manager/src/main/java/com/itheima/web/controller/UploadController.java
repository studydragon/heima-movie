package com.itheima.web.controller;

import com.itheima.util.OssUtil;
import com.itheima.util.VodUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UploadController {

    //图片上传
    @RequestMapping("/upload/image")
    public String uploadImage(MultipartFile uploadImage) throws IOException {
        String imagePath = OssUtil.upload(uploadImage.getOriginalFilename(), uploadImage.getInputStream());
        System.out.println("文件上传完毕,访问路径是:" + imagePath);

        return imagePath;
    }

    //视频上传
    @RequestMapping("/upload/video")
    public String uploadVideo(MultipartFile uploadVideo) throws IOException {
        String videoId = VodUtil.uploadVideo(uploadVideo.getOriginalFilename(), uploadVideo.getInputStream());
        System.out.println("文件上传完毕,视频ID是:" + videoId);
        return videoId;
    }

}
