package com.example.oneclick.login.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class LoginVO implements Serializable {

    private String appId;

    private String token;

    private String clientIp;

    private String encryptType;

    private String outId;

    private String sign;


}
