package com.paulzhangcc.sharing.message.assembly;

/**
 *
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
public interface MessageStrategy {
    boolean sendVerificationCode(String mobile,String code);
}
