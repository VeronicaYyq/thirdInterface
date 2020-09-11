package com.example.oneclick.login.controller;





import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.oneclick.login.vo.LoginVO;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;

public class OneClickLogin {



    @RequestMapping("/login")
    @ResponseBody
    public String getProductName(LoginVO request) throws Exception {

        HttpPost httpPost = new HttpPost("https://api.253.com/open/flashsdk/mobile-query");

        //httpClient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        //请求体格式
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("token","lpck");
        String charSet = "UTF-8";
        //请求参数JSON序列化
        String jsonInfo = JSON.toJSONString(request);
        StringEntity entity = new StringEntity(jsonInfo, charSet);
        httpPost.setEntity(entity);
        CloseableHttpResponse response = null;

        try {
            response = httpclient.execute(httpPost);
            StatusLine status = response.getStatusLine();
            int state = status.getStatusCode();
            //响应状态码为200
            if (state == HttpStatus.SC_OK) {
                HttpEntity responseEntity = response.getEntity();
                String jsonString = EntityUtils.toString(responseEntity);
                System.out.println(jsonString);
               return "请求成功";
            }
            else{
                return "500,请求失败!";
            }
        }
        //资源释放
        finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
              /*  JSONObject jo = JSONObject.parseObject(respContent);
                System.out.println("=============="+jo);
                JSONObject jsonobj = JSONObject.fromObject(jo);
                net.sf.json.JSONArray jsonArray1 = jsonobj.getJSONArray("需要获取的json中的属性");
                for(int i=0;i<jsonArray1.size();i++)
                {
                    String productName = (String)jsonArray1.getJSONObject(i).get("json数组中某一个属性");
                    System.out.println(productName);
                    productList.add(productName);
                }*/


    }
}
