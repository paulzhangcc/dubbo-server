package com.paulzhangcc.demo.event.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import static com.paulzhangcc.demo.spring.DemoSpringConfig.ASYNC_LISTENER;


/**
 *
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
@Component
@Async(ASYNC_LISTENER)
public class DemoListener implements ApplicationListener<DemoEvent> {
    private static final Logger logger = LoggerFactory.getLogger(DemoListener.class);
    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        logger.info("接收到消息:{}",demoEvent);
    }
}
