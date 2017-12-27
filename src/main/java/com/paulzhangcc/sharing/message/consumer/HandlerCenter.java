package com.paulzhangcc.sharing.message.consumer;

import com.paulzhangcc.sharing.message.queue.QueueEnum;
import com.paulzhangcc.sharing.message.queue.TaskQueue;
import com.paulzhangcc.sharing.util.ExecutorsHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
@Component
public class HandlerCenter implements InitializingBean {
    private static Logger logger = LoggerFactory.getLogger(HandlerCenter.class);
    private static Map<QueueEnum, Executor> executorMap = new HashMap<>();

    private Executor executor;

    public HandlerCenter() {
        for (QueueEnum qe : QueueEnum.values()) {
            executorMap.put(qe, ExecutorsHelper.generator(qe + "-hanlder", 5, 50));
        }
        executor = ExecutorsHelper.generator("boss-hanlder", QueueEnum.values().length + 1, 50);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for (QueueEnum qe : QueueEnum.values()) {
            executor.execute(new BossHanlder(executorMap.get(qe), TaskQueue.getQueue(qe)));
        }
        logger.info("=============>>> Message hanlders is running ...");
    }

    class BossHanlder implements Runnable {
        private Logger logger = LoggerFactory.getLogger(BossHanlder.class);
        private Executor executor;
        private LinkedBlockingQueue<Runnable> queue;

        public BossHanlder(Executor executor, LinkedBlockingQueue<Runnable> queue) {
            this.executor = executor;
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    executor.execute(queue.take());
                } catch (InterruptedException e) {
                    logger.error("线程冲断！ {}", e);
                }
            }
        }
    }

}
