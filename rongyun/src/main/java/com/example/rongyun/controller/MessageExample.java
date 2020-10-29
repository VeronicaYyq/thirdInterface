package com.example.rongyun.controller;

import io.rong.RongCloud;
import io.rong.messages.CustomTxtMessage;
import io.rong.messages.TxtMessage;
import io.rong.messages.UserInfo;
import io.rong.messages.VoiceMessage;
import io.rong.methods.message._private.Private;
import io.rong.methods.message.chatroom.Chatroom;
import io.rong.methods.message.discussion.Discussion;
import io.rong.methods.message.group.Group;
import io.rong.methods.message.history.History;
import io.rong.methods.message.system.MsgSystem;
import io.rong.models.message.*;
import io.rong.models.response.HistoryMessageResult;
import io.rong.models.response.ResponseResult;
import io.rong.util.GsonUtil;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;


/**
 * 消息发送示例
 *
 * @author RongCloud
 * @version 3.0.0
 */
@Service
public class MessageExample {
    /**
     * 此处替换成您的appKey
     */
    private static final String appKey = "25wehl3u2gyqw";
    /**
     * 此处替换成您的appSecret
     */
    private static final String appSecret = "8alc8jTmbfJI";


    public RongCloud getRongCloud() {

        RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret);
        return  rongCloud;
    }

}
