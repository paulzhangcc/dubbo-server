package com.paulzhangcc.sharing.message.hanlders;

import com.paulzhangcc.sharing.annotation.NotThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
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

    /**
     * handler 名称
     * @return
     */
    protected abstract String name();

    /**
     * handler 处理的内容
     * @return
     */
    protected abstract Object content();

    public boolean canSend() {
        return canSend;
    }

    /**
     * handler 执行内容
     * @return
     */
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
