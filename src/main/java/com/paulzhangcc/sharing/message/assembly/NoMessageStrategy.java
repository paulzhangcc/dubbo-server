package com.paulzhangcc.sharing.message.assembly;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author paul
 * @date 2017/12/26
 */
public class NoMessageStrategy implements MessageStrategy {
    private static Logger logger = LoggerFactory.getLogger(NoMessageStrategy.class);
    @Override
    public boolean sendVerificationCode(String mobile, String code) {
        logger.info("手机号:[{}]短信验证码:[{}]",mobile,code);
        return true;
    }
}
