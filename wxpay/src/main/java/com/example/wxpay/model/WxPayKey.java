package com.example.wxpay.model;


public enum WxPayKey {


    BODY("body", "商品描述"),
    FEE_TYPE("fee_type", "货币类型"),
    TOTAL_FEE("total_fee", "总金额"),
    SPBILL_CREATE_IP("spbill_create_ip", "下单ip"),
    TRADE_TYPE("trade_type", "交易类型"),
    NONCE_STR("nonce_str", "随机字符串"),
    TIME_EXPIRE("time_expire", "过期时间"),
    NOTIFY_URL("notify_url", "回调url"),
    CODE_URL("code_url", "二维码url"),
    MWEB_URL("mweb_url", "h5  url"),
    APPID("appid", "appid"),
    PACKAGEWX("package", "签名描述"),
    PARTNERID("partnerid", "商户id"),
    MCH_ID("mch_id","商户id"),
    PREPAYID("prepayid", "随机字符串"),
    prepay_id("prepay_id", "微信预订单号"),
    TIMESTAMP("timestamp", "时间戳"),
    APPSIGN("appSign", "app签名"),
    H5("H5Sign", "h5 签名"),
    NONCESTR("noncestr", "随机字符串"),
    OUT_TRADE_NO("out_trade_no", "订单号"),
    ATTACH("attach", "业务系统参数"),
    OPENID("openid", "openid"),
    TRANSACTION_ID("transaction_id", "微信订单号"),
    RESULT_CODE("result_code", "业务结果 SUCCESS/FAIL"),
    TRADE_STATE("trade_state", "SUCCESS—支付成功 REFUND—转入退款 NOTPAY—未支付 CLOSED—已关闭  REVOKED—已撤销（刷卡支付） USERPAYING--用户支付中  PAYERROR--支付失败(其他原因，如银行返回失败)"),
    SIGN("sign", "签名"),
    ERR_CODE("err_code", "错误代码"),
    ACCESS_TOKEN("access_token", "access_token"),
    TICKET("ticket", "js sdk ticket"),
    JSAPI_TICKET("jsapi_ticket", "js sdk ticket"),
    url("url", "url"),
    signType_md5("signType", "md5 类型签名");


    private String type;
    private String name;

    WxPayKey(String type, String title) {
        this.type = type;
        this.name = title;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static WxPayKey generateByType(Integer type) {

        WxPayKey[] values = WxPayKey.values();

        for (WxPayKey value : values) {

            if (value.getType().equals(type)) {
                return value;
            }
        }

        return null;
    }
}
