package com.example.wxpay.model;

import lombok.Data;
import lombok.ToString;

/**
 * @Author: yyq
 * @Date 4:02 下午 2020/12/9
 * @Description:
 */

@Data
@ToString
public class Wxconfig {
    /**
     * appid
     */
    private String appid;
    /**
     * 商户号
     */
    private String partnerid;
    /**
     * 随机字符串
     */
    private String nonceStr;
    /**
     * 签名
     */
    private String sign;
    /**
     * 商品描述
     */
    private String prepayid;
    /**
     * 扩展字段
     */
    private String extra;

    private String timestamp;


}
