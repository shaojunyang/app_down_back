package com.example.demo2.common;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * 常量类
 *
 * @author
 * @create 2017-11-24 下午8:38
 **/

public class Const {
    //    session 中表示当前用户的常量
    public static final String CURRENT_USER = "currentUser";
    public static final String CURRENT_COMPANY = "currentCompany";
    public static final String EMAIL = "email";
    public static final String USERNAME = "username";
    public static final String COMPANY = "COMPANY";
    public static final Integer USER_EXTIME = 60 * 60 * 24;
//    public static StringBuilder PLIST_TEMPLATE_TEST= "";

    public static final String PLIST_TEMPLATE_TEST = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">\n" +
            "<plist version=\"1.0\">\n" +
            "<dict>\n" +
            "    <key>items</key>\n" +
            "    <array>\n" +
            "        <dict>\n" +
            "            <key>assets</key>\n" +
            "            <array>\n" +
            "                <dict>\n" +
            "                    <key>kind</key>\n" +
            "                    <string>software-package</string>\n" +
            "                    <key>url</key>\n" +
            "                    <string>${ipa}</string>\n" +
            "                </dict>\n" +
            "                <dict>\n" +
            "                    <key>kind</key>\n" +
            "                    <string>display-image</string>\n" +
            "                    <key>url</key>\n" +
            "                    <string>https://asset-araya.oss-cn-beijing.aliyuncs.com/app/png/ios.jpg</string>\n" +
            "                </dict>\n" +
            "                <dict>\n" +
            "                    <key>kind</key>\n" +
            "                    <string>full-size-image</string>\n" +
            "                    <key>url</key>\n" +
            "                    <string>https://asset-araya.oss-cn-beijing.aliyuncs.com/app/png/ios.jpg</string>\n" +
            "                </dict>\n" +
            "            </array>\n" +
            "            <key>metadata</key>\n" +
            "            <dict>\n" +
            "                <key>bundle-identifier</key>\n" +
            "                <string>com.ianisme.myapp</string>\n" +
            "                <key>bundle-version</key>\n" +
            "                <string>${version}</string>\n" +
            "                <key>kind</key>\n" +
            "                <string>software</string>\n" +
            "                <key>title</key>\n" +
            "                <string>${title}</string>\n" +
            "            </dict>\n" +
            "        </dict>\n" +
            "    </array>\n" +
            "</dict>\n" +
            "</plist>";
    public static final Object HOST = "";


    public interface ProductListOrderBy {
        Set<String> PRICE_ASC_DESC = Sets.newHashSet("price_desc", "price_asc");

    }


    //    定义接口 属性 表示 角色  可以在 外部直接调用
    public interface Role {
        int ROLE_CUSTOMER = 0;//普通用户
        int ROLE_ADMIN = 1;//管理员
    }


    //    定义接口 资产状态
    public interface ASSET_STATUS {
        int ALL = 0;//所有
        int USE_STATUS = 10;//在用状态
        int LEAVE_UNUSED = 20;//闲置状态
        int REPAIR = 30; //维修状态
        int USE_LESS = 40; // 报废状态
        int PENDING = 50; // 待审核状态
        int APPLY_RECEIVE = 60; // 员工手机端 申请领用中
        int APPLY_RETURN_STOCK = 70; // 员工手机端 申请退库中
    }

    //  资产来源
    public enum AssetSource {
        PURCHASE("自购", 0),
        LEASE("租赁", 10),
        GIVE("赠送", 20),
        BORROW("借用", 30),
        HOME_GROWN("自产", 40),
        OTHER("其他", 50);


        private String value;
        private int code;

        AssetSource(String value, int code) {
            this.value = value;
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum CompanyAuthStatus {
        AUTH(1, "认证"),
        UN_AUTH(0, "未认证");
        private String value;
        private Integer code;

        CompanyAuthStatus(Integer code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public Integer getCode() {
            return code;
        }
    }

    public enum ProductStatusEnum {
        ON_SALE(1, "在线");
        private String value;
        private int code;

        ProductStatusEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum REPAIR_FINSH_IS {
        UN_SINSH(0, "维修中"),
        FINSH(1, "维修完成");
        private String value;
        private int code;

        REPAIR_FINSH_IS(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum ADMIN_STATUS {
        ENABLE(1, "启用"),
        DISABLE(0, "禁用");

        private int code;
        private String value;

        ADMIN_STATUS() {
        }

        ADMIN_STATUS(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }


    public interface Cart {
        int CHECKED = 1;// 购物车选中状态
        int UN_CHECKED = 0;//购物车未选

        // 限制成功 和 限制失败
        String LIMIT_NUM_FAIL = "LIMIT_NUM_FAIL";
        String LIMIT_NUM_SUCCESS = "LIMIT_NUM_SUCCESS";

    }

    //资产处理类型
    public enum ASSET_HANDLE_TYPE {
        ASSET_JOIN_STOCK(0, "资产入库"),
        ASSET_CLEAN(10, "清理报废"),
        ASSET_RETURN_STOCK(20, "资产退库"),
        ASSET_RECEIVE(30, "资产领用"),
        ASSET_REPAIR(40, "资产维修"),
        ASSET_TRANSITION(50, "资产转移"),
        ASSET_INVENTORY(60, "资产盘点");

        ASSET_HANDLE_TYPE(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private int code;
        private String value;


        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }


    }


    //资产 盘点状态
    public enum ASSET_INVENTORY_STATUS {
        //        0 未盘 1 已盘 2 盘亏 3存疑
        ASSET_INVENTORY_NOT(0, "未盘"),
        ASSET_INVENTORY_KUI(2, "盘亏"),
        ASSET_INVENTORY_CUI_YI(3, "存疑"),
        ASSET_INVENTORY_YES(1, "已盘");

        ASSET_INVENTORY_STATUS(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private int code;
        private String value;


        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }


    }


    // 管理员类型
    public enum CATEGORY_STATUS {
        CUSTOM_TYPE(0, "用户自定义资产类别"),
        SYSTEM_TYPE(1, "系统预定义资产类别");

        CATEGORY_STATUS(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private int code;
        private String value;


        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }


    }


    // 管理员类型
    public enum ADMIN_TYPE {
        ROOT_ADMIN(0, "高级管理员"),
        COMMON_ADMIN(1, "普通管理员");

        ADMIN_TYPE(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private int code;
        private String value;


        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }


    }


    // 消息类型
    public enum MESSAGE_STATUS {
        UN_READ(0, "未读"),
        READ(1, "已读"),
        RECYCLE(2, "回收站");

        MESSAGE_STATUS(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private int code;
        private String value;


        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }

    }


    // 是否绑定微信


    // 是否绑定微信
    public enum IS_BIND_WEI_XIN {
        UN_ALREADY_WEIXIN(0, "未绑定微信"),
        ALREADY_WEIXIN(1, "已绑定微信");

        IS_BIND_WEI_XIN(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private int code;
        private String value;


        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }

    }


    // 申请状态
    public enum APPLY_STATUS {
        APPLY(0, "申请中"),
        APPROVAL(1, "已批准");

        APPLY_STATUS(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private int code;
        private String value;


        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }

    }

    // 消息类型
    public enum MESSAGE_TYPE {
        SYSTEM_MESSAGE(0, "系统消息"),
        COMMON_MESSAGE(1, "普通消息");

        MESSAGE_TYPE(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private int code;
        private String value;


        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }


    }

    //资产 单状态
    public enum INVENTORY_ORDER_STATUS {
        NORMAL(0, "盘点中"),
        DISCREPANT(1, "已完成");

        INVENTORY_ORDER_STATUS(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private int code;
        private String value;


        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }


    }

    //资产 盘点 结果
    public enum ASSET_INVENTORY_RESULT {
        ASSET_NORMAL(0, "正常"),
        DISCREPANT(1, "信息不符"),
        DAMAGE(2, "损坏"),
        LOSE(3, "遗失"),
        OTHER(4, "其他");

        ASSET_INVENTORY_RESULT(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private int code;
        private String value;


        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }


    }


    public enum OrderStatusEnum {
        CANCELED(0, "已取消"),
        NO_PAY(10, "未支付"),
        PAID(20, "已付款"),
        SHIPPED(40, "已发货"),
        ORDER_SUCCESS(50, "订单完成"),
        ORDER_CLOSE(60, "订单关闭");

        OrderStatusEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private int code;
        private String value;


        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }

        // 把 对象 code码的 汉字描述返回回去
        public static OrderStatusEnum codeOf(int code) {
            for (OrderStatusEnum orderStatusEnum : values()) {
                if (orderStatusEnum.getCode() == code) {
                    return orderStatusEnum;
                }
            }
            throw new RuntimeException("没有找到对应的枚举");

        }

    }

    public interface AlipayCallback {
        String TRADE_STATUS_WAIT_BUYER_PAY = "WAIT_BUYER_PAY";
        String TRADE_STATUS_TRADE_SUCCESS = "TRADE_SUCCESS";

        String RESPONSE_SUCCESS = "success";
        String RESPONSE_FAILED = "failed";
    }


    public enum PayPlatformEnum {
        ALIPAY(1, "支付宝");

        PayPlatformEnum(int code, String value) {
            this.value = value;
            this.code = code;
        }

        private int code;
        private String value;


        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }


    public enum PaymentTypeEnum {
        ONLINE_PAY(1, "在线支付");

        private int code;
        private String value;

        public int getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }

        PaymentTypeEnum(int code, String value) {

            this.code = code;
            this.value = value;
        }

        // 把 对象 code码的 汉字描述返回回去
        public static PaymentTypeEnum codeOf(int code) {
            for (PaymentTypeEnum paymentTypeEnum : values()) {
                if (paymentTypeEnum.getCode() == code) {
                    return paymentTypeEnum;
                }
            }
            throw new RuntimeException("没有找到对应的枚举");

        }
    }


}
