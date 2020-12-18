package com.example.wxpay.model;

import com.github.wxpay.sdk.WXPayConfig;
import org.springframework.util.ClassUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author saodiseng
 * @date 2019/2/18
 */
public class WXConfigUtil implements WXPayConfig {
    private byte[] certData;
    public static final String APP_ID = "wxacb1e306b6359924";
    public static final String KEY = "yEJSZ0hvqGt7lSlFYSgWin0e6nUdZdri";
    public static final String MCH_ID = "1489139382";
  /*  public WXConfigUtil() throws Exception {
        String certPath = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"/weixin/apiclient_cert.p12";//从微信商户平台下载的安全证书存放的路径
        File file = new File(certPath);
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
    }*/

    @Override
    public String getAppID() {
        return APP_ID;
    }

    //parnerid，商户号
    @Override
    public String getMchID() {
        return MCH_ID;
    }

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 10000;
    }
}

