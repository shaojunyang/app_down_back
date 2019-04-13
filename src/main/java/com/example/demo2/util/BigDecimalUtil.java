package com.example.demo2.util;

import java.math.BigDecimal;

/**
 * 工具类
 *
 * @author yangshaojun
 * @create 2017-12-07 下午12:04
 **/

public class BigDecimalUtil {
    private BigDecimalUtil() {

    }
    /**
     * 加法
     * @param v1
     * @param v2
     */
    public static BigDecimal add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2);
    }

    /**
     * 减法法
     *
     * @param v1
     * @param v2
     */
    public static BigDecimal sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2);
    }

    /**
     * 乘法法
     *
     * @param v1
     * @param v2
     */
    public static BigDecimal mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2);
    }

    /**
     * 除法
     *
     * @param v1
     * @param v2
     */
    public static BigDecimal div(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        // 四舍五入、保留两位小数
        return b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP);
        //     除不尽的情况
    }


}
