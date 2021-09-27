package com.itheima.util;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.req.UploadVideoRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyun.vod.upload.resp.UploadVideoResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.vod.model.v20170321.*;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;

public class VodUtil {

    //区域
    private static final String regionId = "cn-shanghai";
    //访问id
    private static final String accessKeyId = "密钥id";
    //访问秘钥
    private static final String accessKeySecret = "密钥";

    //初始化
    public static DefaultAcsClient initVodClient() {
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        return new DefaultAcsClient(profile);
    }

    //上传视频,返回视频id
    public static String uploadVideo(String fileName, InputStream inputStream) {
        String title = fileName.substring(0, fileName.lastIndexOf("."));
        UploadStreamRequest request = new UploadStreamRequest(
                accessKeyId, accessKeySecret, title, fileName, inputStream);
        UploadVideoImpl uploader = new UploadVideoImpl();
        UploadStreamResponse response = uploader.uploadStream(request);
        String videoId = response.getVideoId();
        return videoId;
    }

    //根据视频id查询
    public static GetPlayInfoResponse getPlayInfo(String videoId) throws Exception {
        GetPlayInfoRequest request = new GetPlayInfoRequest();
        request.setVideoId(videoId);
        return initVodClient().getAcsResponse(request);
    }

    //获取播放凭证函数
    public static GetVideoPlayAuthResponse getVideoPlayAuth(String videoId) throws Exception {
        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
        request.setVideoId(videoId);
        return initVodClient().getAcsResponse(request);
    }

    //删除视频
    public static DeleteVideoResponse deleteVideo(String[] videoIds) throws Exception {
        DeleteVideoRequest request = new DeleteVideoRequest();
        //支持传入多个视频ID，多个用逗号分隔
        request.setVideoIds(StringUtils.join(videoIds, ","));
        return initVodClient().getAcsResponse(request);
    }
}