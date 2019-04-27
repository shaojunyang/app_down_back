package com.example.demo2.service.impl;

import com.example.demo2.common.Const;
import com.example.demo2.common.ServerResponse;
import com.example.demo2.config.HostProperties;
import com.example.demo2.dao.AppMapper;
import com.example.demo2.en.AppWithBLOBs;
import com.example.demo2.util.AliOSSUtil;
import com.example.demo2.util.ChineseToEnglishUtil;
import com.example.demo2.util.UUIDUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
@Service
public class IOSAppServiceImpl {


    @Autowired
    private AppMapper appMapper;
    @Autowired
    private HostProperties hostProperties;

    public String upload(InputStream file, String originalFilename) throws FileNotFoundException {
        String filename = AliOSSUtil.upload(file, originalFilename);
        return filename;
    }


    public ServerResponse<PageInfo<AppWithBLOBs>> list(Integer pageNum, Integer pageSize, String orderBy, String dateangeStartValue, String dateangeEndValue, String keyword) {

//        if (StringUtils.isEmpty(keyword)) {
//            keyword = null;
//        } else {
//            keyword = "%" + keyword + "%";
//        }


        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        // 如果排序参数是空的
        if (!orderBy.isEmpty()) {
            //  如果  orderBy参数 是 price_desc 或者 price_asc
//            if (Const.ProductListOrderBy.PRICE_ASC_DESC.contains(orderBy)) {
            String[] orderByArr = orderBy.split("-");
            PageHelper.orderBy(orderByArr[0] + " " + orderByArr[1]);
//            }
        }


        // 分页

        // sql  根据 用户查询所有的日志列表

        List<AppWithBLOBs> SystemLogList = appMapper.findByNameContaining(keyword);

        // 构造 pageInfo
        PageInfo<AppWithBLOBs> pageInfo = new PageInfo(page.getResult());
        pageInfo.setList(SystemLogList);

        return ServerResponse.createBySuccess(pageInfo);

    }

    public ServerResponse<String> add(AppWithBLOBs app) throws IOException {


        // 解析URL 拼装URL 为PLIST文件
        String plistString = Const.PLIST_TEMPLATE_TEST.replace("${version}", app.getVersion()).replace("${ipa}", app.getAppStrogeUrl()).replace("${title}", app.getName());


        // 把PLIST文件上传到 OSS
        String plistURL = this.uploadPlistFile(plistString, StringUtils.replaceAll(ChineseToEnglishUtil.getPingYin(app.getName()), " +", "") + app.getVersion() + ".plist");


        // 组装PLISt文件为文件下载链接

        String installUrl = "itms-services://?action=download-manifest&url=" + StringUtils.trim(plistURL);

        // 组装文件下载链接为 短链接
        String short_id = UUIDUtil.getUUID();

        app.setShortId(short_id);
        app.setAppPlist(plistURL);
        app.setInstallUrl(installUrl);

        app.setShortIdDesc(hostProperties.getName() + "/#/apps/" + short_id);

        int insert = appMapper.insert(app);
        if (insert > 0) {
            return ServerResponse.createBySuccessMessage("添加成功");
        }
        return ServerResponse.createByErrorMessage("添加失败");

    }

    /**
     * 上传 plist
     *
     * @param plistString
     * @param originalFilename
     * @return
     */

    public String uploadPlistFile(String plistString, String originalFilename) throws IOException {
//        InputStream inputStream = new InputStream() {
//            @Override
//            public int read() throws IOException {
//                return 0;
//            }
//        }


        InputStream in = new ByteArrayInputStream(plistString.getBytes());

        //        FileUtils.
//                File file = new File(plistString);
        String filename = AliOSSUtil.upload(in, originalFilename, "app/plist/");
        return filename;

    }


    public ServerResponse<String> check(AppWithBLOBs app) {

        Integer integer = appMapper.countByIdAndPassword(app.getId(), app.getPassword());

        if (integer > 0) {
            return ServerResponse.createBySuccessMessage("密码正确");
        }

        return ServerResponse.createByErrorMessage("密码错误");
    }

    public ServerResponse<AppWithBLOBs> detail(AppWithBLOBs app) {

        AppWithBLOBs byShortId = appMapper.findByShortId(app.getShortId());
        if (byShortId == null) {
            return ServerResponse.createByErrorMessage("应用不存在");
        }

        return ServerResponse.createBySuccess(byShortId);
    }

    public static void main(String[] args) {
//        URLEncodedUtils.
//        System.out.println(StringUtils.trim("443894 3443 3443"));
//        StringUtilsR.
//        String url = "https://asset-araya.oss-cn-beijing.aliyuncs.com/app/ios/芒果TV HD 4.0.ipa";
//        String decode = URLEncoder.encode(url);
//        System.out.println(decode);
//
//        try {
//            String encode = com.sun.deploy.net.URLEncoder.encode("芒果TV HD 4.0.ipa", "UTF-8");
//            System.out.println(encode);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//

    }

    public ServerResponse<String> update(AppWithBLOBs app) {
        int i = appMapper.updateByPrimaryKeySelective(app);
        if (i > 0) {

            return ServerResponse.createBySuccessMessage("更新成功");
        }
        return ServerResponse.createByErrorMessage("更新失败");
    }
}