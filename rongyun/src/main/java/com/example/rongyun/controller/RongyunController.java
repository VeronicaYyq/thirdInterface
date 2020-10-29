package com.example.rongyun.controller;

import io.rong.RongCloud;
import io.rong.messages.TxtMessage;
import io.rong.messages.UserInfo;
import io.rong.methods.message.history.History;
import io.rong.methods.message.system.MsgSystem;
import io.rong.methods.user.User;
import io.rong.models.message.SystemMessage;
import io.rong.models.response.HistoryMessageResult;
import io.rong.models.response.ResponseResult;
import io.rong.models.response.TokenResult;
import io.rong.models.user.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yyq
 * @Date 4:39 下午 2020/10/9
 * @Description:
 */
@RestController
public class RongyunController {
    @Autowired
    private MessageExample messageExample;


    private static final UserInfo userinfo = new UserInfo("rc1", "rc_user1",
            "http://www.rongcloud.cn/images/logo.png", "");
   /* private static final TxtMessage txtMessage = new TxtMessage("hello", "helloExtra");
    private static final VoiceMessage voiceMessage = new VoiceMessage("hello", "helloExtra", 20L);*/


    private static final TxtMessage txtMessage1 = new TxtMessage("hello", "helloExtra", userinfo);

    @PostMapping("/sendMsg")
    public Object sendMsg() {

        RongCloud rongCloud = messageExample.getRongCloud();


        MsgSystem system = rongCloud.message.system;


        /**
         * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/message/system.html#send
         * <p>
         * 前端传回targetId
         * <p>
         * 发送系统消息
         */
        String[] targetIds = {"2651280140445094444"};
        SystemMessage systemMessage = new SystemMessage()
                .setSenderId(userinfo.getId())
                .setTargetId(targetIds)
                .setObjectName(txtMessage1.getType())
                .setContent(txtMessage1);

        try {
            ResponseResult result = system.send(systemMessage);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
        /*  *//**
         * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/message/system.html#sendTemplate
         *
         * 发送系统模板消息方法
         *
         */
      /*
        Reader reader = null ;
        try {
            reader =new BufferedReader( new InputStreamReader(MessageExample.class.getClassLoader().getResourceAsStream("jsonsource/message/TemplateMessage.json")));
            TemplateMessage template = (TemplateMessage)GsonUtil.fromJson(reader, TemplateMessage.class);
            ResponseResult systemTemplateResult = system.sendTemplate(template);
            System.out.println("send system template message:  " + systemTemplateResult.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(null != reader){
                reader.close();
            }
        }

        *//**
         * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/message/system.html#sendTemplate
         *
         * 发送系统模板消息方法
         *
         */
        /*
        BroadcastMessage message = new BroadcastMessage()
                .setSenderId("Hji8yh76")
                .setObjectName(txtMessage.getType())
                .setContent(txtMessage)
                .setPushContent("this is a push")
                .setPushData("{'pushData':'hello'}")
                .setOs("iOS");
        ResponseResult broadcastResult = rongCloud.message.system.broadcast(message);
        System.out.println("send broadcast:  " + broadcastResult.toString());


        *//**
         * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/message/private.html#send
         *
         * 发送单聊消息
         * */
        /*
        PrivateMessage privateMessage = new PrivateMessage()
                .setSenderId("2609751433442958892")
                .setTargetId(targetIds)
                .setObjectName(voiceMessage.getType())
                .setContent(voiceMessage)
                .setPushContent("")
                .setPushData("{\"pushData\":\"hello\"}")
                .setCount("4")
                .setVerifyBlacklist(0)
                .setIsPersisted(0)
                .setIsCounted(0)
                .setIsIncludeSender(0);
        ResponseResult privateResult = Private.send(privateMessage);
        System.out.println("send private message:  " + privateResult.toString());


        *//**
         * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/message/private.html#recall
         *
         * 撤回单聊消息
         * */
        /*
        RecallMessage recallMessage = new RecallMessage()
                .setSenderId("2609751433442958892")
                .setTargetId("2651280140445094444")
                .setuId("5H6P-CGC6-44QR-VB3R")
                .setSentTime("1519444243981");
        ResponseResult recallPrivateResult = (ResponseResult)Private.recall(recallMessage);
        System.out.println("recall private:  " + recallPrivateResult.toString());*/

        /**
         * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/message/history.html#get
         * 消息是在一个小时之后生成（四点过才能查看三点到四点之间的数据）
         * <p>
         * 获取历史消息日志文件
         */


    }

    @GetMapping("/getHistory")
    public Object getHistory() {
        RongCloud rongCloud = messageExample.getRongCloud();

        History history = rongCloud.message.history;
        HistoryMessageResult historyMessageResult = null;
        try {
            historyMessageResult = (HistoryMessageResult) history.get("2020100915");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return historyMessageResult;
    }

    @GetMapping("/getToken")
    public String getToken() {
        RongCloud rongCloud = messageExample.getRongCloud();
        User User = rongCloud.user;

        /**
         * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/user/user.html#register
         *
         * 注册用户，生成用户在融云的唯一身份标识 Token
         */
        UserModel user = new UserModel()
                .setId("userId")//用户的唯一标识
                .setName("username")//用户昵称
                .setPortrait("http://www.rongcloud.cn/images/logo.png");//用户头像
        TokenResult result = null;
        try {
            result = User.register(user);

            //// 用户 Token，可以保存应用内，长度在 256 字节以内.用户 Token，可以保存应用内，长度在 256 字节以内。
            //	String token;
            //	// 用户 Id，与输入的用户 Id 相同.
            //	String userId;
            //TODO 后续就是将客户生成的唯一标识存入数据库，并根据公司需求拓展数据返回给前端
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result.toString();
    }


}
