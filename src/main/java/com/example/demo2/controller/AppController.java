package com.example.demo2.controller;

import com.example.demo2.common.ServerResponse;
import com.example.demo2.en.AppWithBLOBs;
import com.example.demo2.service.impl.IOSAppServiceImpl;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@RestController
@RequestMapping("/api/back/app")
public class AppController {

    @Autowired
    private IOSAppServiceImpl appService;

    /**
     * 功能描述: 上传图片
     *
     * @MethodName upload
     * @param: [request, file]
     * @return: com.araya.asset.common.ServerResponse<java.lang.String>
     * @auther: yangshaojun
     * @date: 2018/8/21 下午8:48
     */
    @ResponseBody
    @RequestMapping("/upload")
    public ServerResponse<String> upload(HttpServletRequest request, MultipartFile file) {

        // 判断上传的图片是否为空
        if (file.getSize() == 0) {
            return ServerResponse.createByErrorMessage("没有选择上传图片、图片为空、请重新选择图片上传");
        }

        //原始文件名
        String originalFilename = file.getOriginalFilename();

        try {
            InputStream inputStream = file.getInputStream();

            // 上传文件、获取 上传之后的文件名
            String targetFilename = appService.upload(inputStream, originalFilename);
            if (!StringUtils.isEmpty(targetFilename)) {
                return ServerResponse.createBySuccessMessage(targetFilename);
            }
        } catch (IOException e) {
//            e.printStackTrace();
            log.error("上传文件失败", e.getMessage(), e);
        }

        return ServerResponse.createByErrorMessage("上传文件失败");


    }


    @RequestMapping("/list")
    @ResponseBody
    public ServerResponse<PageInfo<AppWithBLOBs>> list(HttpServletRequest request,
                                                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                       @RequestParam(value = "dateangeStartValue", required = false) String dateangeStartValue,
                                                       @RequestParam(value = "dateangeEndValue", required = false) String dateangeEndValue,
                                                       @RequestParam(value = "keyword", required = false) String keyword,
                                                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                       @RequestParam(value = "orderBy", defaultValue = "create_time-desc") String orderBy
    ) {

        // 查询列表 并返回
        return appService.list(pageNum, pageSize, orderBy, dateangeStartValue, dateangeEndValue, keyword);
    }


    @RequestMapping("/detail")
    @ResponseBody
    public ServerResponse<AppWithBLOBs> detail(HttpServletRequest request,
                                               AppWithBLOBs app
    ) {

        // 查询列表 并返回A
        try {
            return appService.detail(app);
        } catch (Exception e) {
//            e.printStackTrace();
            log.error("查看应用详情错误", e.getMessage(), e);
        }


        return ServerResponse.createByErrorMessage("新建app失败");
    }

    @RequestMapping("/add")
    @ResponseBody
    public ServerResponse<String> add(HttpServletRequest request,
                                      AppWithBLOBs app
    ) {

        // 查询列表 并返回A
        try {
            return appService.add(app);
        } catch (Exception e) {
//            e.printStackTrace();
            log.error("新建app失败", e.getMessage(), e);
        }


        return ServerResponse.createByErrorMessage("新建app失败");
    }

    @RequestMapping("/check")
    @ResponseBody
    public ServerResponse<String> check(HttpServletRequest request,
                                        AppWithBLOBs app
    ) {

        // 查询列表 并返回A
        try {
            return appService.check(app);
        } catch (Exception e) {
            log.error("检查密码异常", e.getMessage(), e);
//            e.printStackTrace();
        }

        return ServerResponse.createByErrorMessage("密码错误");
    }
}
