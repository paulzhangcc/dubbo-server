package com.paulzhangcc.sharing.message;

import com.paulzhangcc.sharing.message.assembly.MessageContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
@Component
public class SmsFacade {
    @Autowired
    MessageContext messageContext;
    public boolean sendVerificationCode(String mobile,String code){
        messageContext.sendVerificationCode(mobile,code);
        return true;
    }
}
