package com.paulzhangcc.sharing.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义生成ExecutorService
 * @author paul
 * @date 2017/12/26
 */
public class ExecutorsHelper {
    static class CustomThreadFactory implements ThreadFactory {
        private static Logger logger = LoggerFactory.getLogger(CustomThreadFactory.class);
        private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private String namePrefix;

        CustomThreadFactory(String namePrefix) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            this.namePrefix = namePrefix + "-pool-" +
                    POOL_NUMBER.getAndIncrement() +
                    "-thread-";
        }
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            logger.info("系统创建线程成功,线程名称:{}", t.getName());
            return t;
        }
    }

    public static ExecutorService generator(String prefix, int coreSize, int max) {
        return new ThreadPoolExecutor(coreSize, coreSize,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),
                new CustomThreadFactory(prefix));
    }
}
