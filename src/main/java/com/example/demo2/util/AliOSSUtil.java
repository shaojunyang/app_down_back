package com.example.demo2.util;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

/**
 * @author yangshaojun
 * @ClassName AliOSSUtil
 * @Description
 * @create 2018-08-22 上午 9:42
 * @Version 1.0
 **/


public class AliOSSUtil {

    private final static Logger log = LoggerFactory.getLogger(AliOSSUtil.class);

    /****************阿里云OSS上传文件配置****************/
    private static String END_POINT = "oss-cn-beijing.aliyuncs.com";

    private static String ACCESS_KEY_ID = "LTAIG7QmGEJBhGMk";
    private static String ACCESS_KEY_SECRET = "c0UNF1vdLUUDGFl2DdSh8p6Q4DF6nZ";
    private static String BUCKET_NAME = "asset-araya";
    // 文件访问域名
    private static String FILE_HOST = "https://asset-araya.oss-cn-beijing.aliyuncs.com/";


    /**
     * 方法描述:上传文件
     *
     * @param file 文件对象
     * @return
     * @author leon 2016年12月16日 上午11:40:34
     */
    public static String upload(File file) {
        if (file == null) {
            return null;
        }
        // 创建OSS客户端
        OSSClient ossClient = new OSSClient(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        try {
            // 判断文件容器是否存在，不存在则创建
            if (!ossClient.doesBucketExist(BUCKET_NAME)) {
                ossClient.createBucket(BUCKET_NAME);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(BUCKET_NAME);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            // 创建文件路径

//            String fileUrl = DateTimeUtil.dateToStr(new Date()) + "/" + UUIDUtil.getUUID();

            String fileUrl = UUIDUtil.getUUID();
            // 上传文件
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(BUCKET_NAME, fileUrl, file));
            if (null != result) {
                log.info("上传文件成功,文件路径 " + FILE_HOST + fileUrl);
                return FILE_HOST + fileUrl;
            }
        } catch (OSSException oe) {
            log.error(oe.getMessage());
        } catch (ClientException ce) {
            log.error(ce.getMessage());
        } finally {
            // 关闭OSS服务，一定要关闭
            ossClient.shutdown();
        }
        return null;

    }

    /**
     * 方法描述:上传文件
     *
     * @param file 文件对象
     * @return
     * @author leon 2016年12月16日 上午11:40:34
     */
    public static String upload(File file, String originalFilename) {
        if (file == null) {
            return null;
        }
        // 创建OSS客户端
        OSSClient ossClient = new OSSClient(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        try {
            // 判断文件容器是否存在，不存在则创建
            if (!ossClient.doesBucketExist(BUCKET_NAME)) {
                ossClient.createBucket(BUCKET_NAME);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(BUCKET_NAME);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            // 创建文件路径

//            String fileUrl = DateTimeUtil.dateToStr(new Date()) + "/" + UUIDUtil.getUUID();

            // 创建文件路径
            String fileUrl = null;
            try {
                fileUrl = "app/plist/" + URLEncoder.encode(originalFilename, "UTF-8");
            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
                log.error("URL编码失败");
            }
//            String fileUrl = UUIDUtil.getUUID();
            // 上传文件
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(BUCKET_NAME, fileUrl, file));
            if (null != result) {
                log.info("上传文件成功,文件路径 " + FILE_HOST + fileUrl);
                return FILE_HOST + fileUrl;
            }
        } catch (OSSException oe) {
            log.error(oe.getMessage(), oe);
        } catch (ClientException ce) {
            log.error(ce.getMessage(), ce);
        } finally {
            // 关闭OSS服务，一定要关闭
            ossClient.shutdown();
        }
        return null;
    }

    /**
     * 方法描述:上传文件
     *
     * @param inputStream      文件流
     * @param originalFilename
     * @return
     * @throws FileNotFoundException
     * @author leon 2016年12月26日 下午3:33:13
     */
    public static String upload(InputStream inputStream, String originalFilename, String dir) throws FileNotFoundException {
        if (inputStream == null) {
            return null;
        }
        // 创建OSS客户端
        OSSClient ossClient = new OSSClient(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        try {
            // 判断文件容器是否存在，不存在则创建
            if (!ossClient.doesBucketExist(BUCKET_NAME)) {
                ossClient.createBucket(BUCKET_NAME);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(BUCKET_NAME);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            // 创建文件路径
            String fileUrl = originalFilename;
//            try {
//                fileUrl = dir + URLEncoder.encode(originalFilename, "UTF-8");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//                log.error("URL编码失败");
//            }
            // 上传文件
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(BUCKET_NAME, fileUrl, inputStream));
            if (null != result) {

                log.info("上传文件成功,文件路径 " + FILE_HOST + fileUrl);
                return FILE_HOST + fileUrl;
            }
        } catch (OSSException oe) {
            log.error(oe.getMessage());
        } catch (ClientException ce) {
            log.error(ce.getMessage());
        } finally {
            // 关闭OSS服务，一定要关闭
            ossClient.shutdown();
        }
        return null;

    }

    /**
     * 方法描述:上传文件
     *
     * @param inputStream      文件流
     * @param originalFilename
     * @return
     * @throws FileNotFoundException
     * @author leon 2016年12月26日 下午3:33:13
     */
    public static String upload(InputStream inputStream, String originalFilename) {
        if (inputStream == null) {
            return null;
        }
        // 创建OSS客户端
        OSSClient ossClient = new OSSClient(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        try {
            // 判断文件容器是否存在，不存在则创建
            if (!ossClient.doesBucketExist(BUCKET_NAME)) {
                ossClient.createBucket(BUCKET_NAME);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(BUCKET_NAME);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            // 创建文件路径
//            String fileUrl = null;
//            try {
            String fileUrl = "app/ios/" + originalFilename;
//                        + URLEncoder.encode(originalFilename, "UTF-8");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//                log.error("URL编码失败");
//            }
            // 上传文件


            PutObjectResult result = ossClient.putObject(new PutObjectRequest(BUCKET_NAME, fileUrl, inputStream));
            if (null != result) {


                Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
//                String url = ossClient.generatePresignedUrl(BUCKET_NAME, fileUrl, expiration).toString();
                URL generatePresignedUrl = ossClient.generatePresignedUrl(BUCKET_NAME, fileUrl, expiration);

//                String path = generatePresignedUrl.getPath();

                log.info("上传文件成功,文件路径 " + FILE_HOST + fileUrl);
                return FILE_HOST + fileUrl;
//                return FILE_HOST + path;
            }
        } catch (OSSException oe) {
            log.error("上传文件失败");
            log.error(oe.getMessage());
        } catch (ClientException ce) {
            log.error("上传文件失败");
            log.error(ce.getMessage());
        } finally {
            // 关闭OSS服务，一定要关闭
            ossClient.shutdown();
        }
        return null;

    }

    public static void main(String[] args) {
//        File file = new File("C:\\Users\\HiWin10\\Searches\\Downloads\\img\\arrows.png");
//        String upload = AliOSSUtil.upload(file);
//        System.out.println(upload);
    }

}
