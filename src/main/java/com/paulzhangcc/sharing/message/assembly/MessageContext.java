package com.paulzhangcc.sharing.message.assembly;

import org.springframework.stereotype.Component;

/**
 * @author paul
 * @date 2017/12/26
 */
@Component
public class MessageContext implements MessageStrategy{
    private MessageStrategy messageStrategy = null;

    public MessageContext(){
        this.messageStrategy = new AliMessageStrategy();
    }
    public MessageContext(MessageStrategy messageStrategy) {
        this.messageStrategy = messageStrategy;
    }

    @Override
    public boolean sendVerificationCode(String mobile, String code) {
        return messageStrategy.sendVerificationCode(mobile,code);
    }
}
