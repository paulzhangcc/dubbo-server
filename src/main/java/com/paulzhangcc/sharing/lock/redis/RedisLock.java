package com.paulzhangcc.sharing.lock.redis;

import com.paulzhangcc.sharing.lock.Lock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 通过redis实现锁
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
@Component
public class RedisLock implements Lock {
    private final static Logger logger = LoggerFactory.getLogger(RedisLock.class);


    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void lock(String key) {

    }

    @Override
    public boolean tryLock(String key) {
        return tryLock(key, 0L, null);
    }

    @Override
    public boolean tryLock(String key, long timeout, TimeUnit unit) {
        try {
            //系统计时器的当前值，以毫微秒为单位。
            long nano = System.nanoTime();
            do {
                logger.debug("try lock key: " + key);
                //设置key占位，成功返回ture
                if (redisTemplate.opsForValue().setIfAbsent(key, key)) {
                    //设置锁失效时间
                    redisTemplate.expire(key, DEFAULT_SINGLE_EXPIRE, TimeUnit.SECONDS);
                    logger.debug("get lock, key: " + key + " , expire in " + DEFAULT_SINGLE_EXPIRE + " seconds.");
                    //成功获取锁，返回true
                    return Boolean.TRUE;
                } else { // 存在锁,循环等待锁
                    if (logger.isDebugEnabled()) {
                        String desc = (String) redisTemplate.opsForValue().get(key);
                        logger.debug("key: " + key + " locked by another business：" + desc);
                    }
                }
                if (timeout <= 0) {
                    //没有设置超时时间，直接退出等待
                    break;
                }
                Thread.sleep(SLEEP);
            } while ((System.nanoTime() - nano) < unit.toNanos(timeout));
        } catch (Exception e) {
            logger.error("获取"+key+"锁异常！", e);
        }
        return Boolean.FALSE;
    }

    @Override
    public boolean tryLock(List<String> keys) {
        return tryLock(keys, 0L, null);
    }

    @Override
    public boolean tryLock(List<String> keys, long timeout, TimeUnit unit) {
        try {
            //需要的锁
            Map<String, String> mkeys = new HashMap<>(keys.size());
            long nano = System.nanoTime();
            for (String key : keys) {
                mkeys.put(key, key);
            }
            do {
                logger.debug("try lock keys: " + keys);
                // 提交redis执行计数,批量处理完成返回
                if (redisTemplate.opsForValue().multiSetIfAbsent(mkeys)) {
                    for (String key : keys) {
                        //设置锁失效时间
                        redisTemplate.expire(key, DEFAULT_BATCH_EXPIRE, TimeUnit.SECONDS);
                    }

                    return Boolean.TRUE;
                } else {
                    // 资源占用未成功
                    logger.debug("keys: " + keys + " locked by another business：");
                }

                if (timeout <= 0) {
                    break;
                }
                Thread.sleep(SLEEP);
            } while ((System.nanoTime() - nano) < unit.toNanos(timeout));

        }  catch (Exception e) {
            logger.error("批量获取锁异常！", e);
        }
        return Boolean.FALSE;
    }

    @Override
    public boolean unLock(String key) {
        redisTemplate.delete(key);
        return Boolean.TRUE;
    }

    @Override
    public void unLock(List<String> keys) {
        redisTemplate.delete(keys);
    }
}
