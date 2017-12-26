package com.paulzhangcc.sharing.message.hanlders;

import com.paulzhangcc.sharing.annotation.NotThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author paul
 * @date 2017/12/26
 */
@NotThreadSafe
public abstract class AbstractSmsSendHanlder implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(AbstractSmsSendHanlder.class);
    /**
     * 是否可以使用
     */
    private boolean canSend = true;
    /**
     * Hanlder 的名称
     */
    private String name;

    public AbstractSmsSendHanlder() {
        name = name();
    }

    protected abstract String name();

    protected abstract Object content();

    public boolean canSend() {
        return canSend;
    }

    public abstract boolean send();

    protected void success() {
        //default
    }

    protected void fail() {
        //default
    }

    @Override
    public void run() {
        if (!canSend) {
            logger.warn("当前Hanlder={}不允许操作,content={}", name, content());
            return;
        }
        boolean send = send();
        if (send) {
            success();
        } else {
            fail();
        }
    }
}
