package com.example.demo2.util;

import com.aliyun.oss.OSSClient;
import com.example.demo2.common.CloudConstant;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @author yangshaojun
 * @ClassName AliyunUtils
 * @Description
 * @create 2018-08-22 上午 9:31
 * @Version 1.0
 **/

public class AliyunUtils {

    private static AliyunUtils aliyun;

    private AliyunUtils() {

    }

    public static synchronized AliyunUtils getInstance() {
        if (aliyun == null) {
            aliyun = new AliyunUtils();
        }
        return aliyun;
    }

    /**
     * 上传byte数组
     *
     * @param fileByte
     * @param fileKey
     */
    public void uploadByte(byte[] fileByte, String fileKey) {
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(CloudConstant.ENDPOINT, CloudConstant.ACCESSKEYID, CloudConstant.ACCESSKEYSECRET);
        // 上传byte数组
        ossClient.putObject(CloudConstant.BUCKET, fileKey, new ByteArrayInputStream(fileByte));
        // 关闭client
        ossClient.shutdown();
    }

    /**
     * 上传文件流
     *
     * @param inputStream
     * @param fileKey
     */
    public void uploadInputStream(InputStream inputStream, String fileKey) {
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(CloudConstant.ENDPOINT, CloudConstant.ACCESSKEYID, CloudConstant.ACCESSKEYSECRET);
        // 上传文件流
        ossClient.putObject(CloudConstant.BUCKET, fileKey, inputStream);
        // 关闭client
        ossClient.shutdown();
    }

    /**
     * 删除文件
     *
     * @param fileKey
     */
    public void deleteFile(String fileKey) {
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(CloudConstant.ENDPOINT, CloudConstant.ACCESSKEYID, CloudConstant.ACCESSKEYSECRET);
        // 删除文件
        ossClient.deleteObject(CloudConstant.BUCKET, fileKey);
        // 关闭client
        ossClient.shutdown();
    }

    //base64字符串转化成图片
    @SuppressWarnings("restriction")
    public static byte[] BASE64DecoderStringToByte(String imgStr) {   //对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) //图像数据为空
            return null;
        sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
        try {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            return b;
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
//        AliyunUtils.getInstance().uploadByte(BASE64DecoderStringToByte(base64), "aabb.jpg");
//        AliyunUtils.getInstance().uploadInputStream();
    }
}
