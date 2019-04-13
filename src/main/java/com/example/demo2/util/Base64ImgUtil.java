package com.example.demo2.util;

import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author yangshaojun
 * @ClassName Base64ImgUtil
 * @Description 图片转换base64编码工具栏
 * @create 2018-10-11 下午4:02
 * @Version 1.0
 **/

public class Base64ImgUtil {


    /**
     * 功能描述:  图片转换为 img64字符串
     *
     * @MethodName getImg64
     * @param: [file]
     * @return: java.lang.String
     * @auther: yangshaojun
     * @date: 2018/10/11 下午4:09
     */
    public static String getImg64(File file) {

        byte[] data = null;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(file);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);// 返回Base64编码过的字节数组字符串
    }

    /**
     * 功能描述:  图片转换为 img64字符串
     *
     * @MethodName getImg64
     * @param: [imgPath]
     * @return: java.lang.String
     * @auther: yangshaojun
     * @date: 2018/10/11 下午4:10
     */
    public static String getImg64(String imgPath) {

        byte[] data = null;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);// 返回Base64编码过的字节数组字符串
    }

    /**
     * 功能描述:  img64字符串 转换为图片
     *
     * @MethodName Img64SaveToImgFile
     * @param: [img64Str, imgPath]
     * @return: boolean
     * @auther: yangshaojun
     * @date: 2018/10/11 下午4:10
     */
    public static boolean Img64SaveToImgFile(String img64Str, String imgPath) {
        if (img64Str == null) // 图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] bytes = decoder.decodeBuffer(img64Str);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpeg图片
            OutputStream out = new FileOutputStream(imgPath);
            out.write(bytes);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * 功能描述:  将一张网络图片转化成Base64字符串
     *
     * @MethodName GetImageStrFromUrl
     * @param: [imgURL]
     * @return: java.lang.String
     * @auther: yangshaojun
     * @date: 2018/10/11 下午4:10
     */
    public static String GetImageStrFromUrl(String imgURL) {
        ByteArrayOutputStream data = new ByteArrayOutputStream();
        try {
            // 创建URL
            URL url = new URL(imgURL);
            byte[] by = new byte[1024];
            // 创建链接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            InputStream is = conn.getInputStream();
            // 将内容读取内存中
            int len = -1;
            while ((len = is.read(by)) != -1) {
                data.write(by, 0, len);
            }
            // 关闭流
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data.toByteArray());
    }


    /**
     * 功能描述: 对SpringMVC上传的图片进行BASE64编码
     * @MethodName getImg64
     * @param: [file]
     * @return: java.lang.String
     * @auther: yangshaojun
     * @date: 2018/10/11 下午4:35
     */
    public static String getImg64(MultipartFile file) {
        BASE64Encoder encoder = new BASE64Encoder();
        // 通过base64来转化图片
        String data = null;
        try {
            data = encoder.encode(file.getBytes());
            return data;
        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;
    }
}
