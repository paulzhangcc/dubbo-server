package com.paulzhangcc.sharing.message.hanlders;

import com.paulzhangcc.sharing.message.model.MessageDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author paul
 * @date 2017/12/26
 */
public class SmsPutDbHandler extends AbstractSmsSendHanlder{
    private static Logger logger = LoggerFactory.getLogger(SmsPutDbHandler.class);
    public List<MessageDO> source;
    public SmsPutDbHandler(){

    }
    public SmsPutDbHandler(List<MessageDO> source) {
        this.source = source;
    }

    @Override
    protected String name() {
        return "数据入库";
    }

    @Override
    protected Object content() {
        return source;
    }

    @Override
    public boolean send() {
        logger.info("数据入库的内容:{}",source);
        return true;
    }
}
