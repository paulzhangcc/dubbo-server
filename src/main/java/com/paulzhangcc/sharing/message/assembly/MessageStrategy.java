package com.paulzhangcc.sharing.message.assembly;

/**
 * @author paul
 * @date 2017/12/26
 */
public interface MessageStrategy {
    boolean sendVerificationCode(String mobile,String code);
}
