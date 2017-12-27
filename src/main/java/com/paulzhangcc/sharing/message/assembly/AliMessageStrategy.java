package com.paulzhangcc.sharing.message.assembly;

import com.paulzhangcc.sharing.message.hanlders.AliSmsSendHanlder;
import com.paulzhangcc.sharing.message.model.AliSms;
import com.paulzhangcc.sharing.message.queue.TaskQueue;

import static com.paulzhangcc.sharing.message.queue.QueueEnum.SMS_SINGLE;

/**
 *
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
public class AliMessageStrategy implements MessageStrategy {


    @Override
    public boolean sendVerificationCode(String mobile, String code) {
        AliSms aliSms = new AliSms();
        aliSms.setMobile(mobile);
        aliSms.setTemplateCode("10000");
        aliSms.getTemplateParam().put("code","10000");
        TaskQueue.put(new AliSmsSendHanlder(aliSms),SMS_SINGLE);
        return true;
    }
}
