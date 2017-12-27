package com.paulzhangcc.sharing.lock;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
public interface Lock {
    /**
     * 单个锁有效期(如何设置:通过数据库事物提交的时间作为参考值)
     */
    public static final int DEFAULT_SINGLE_EXPIRE = 100;

    /**
     * 批量锁有效期(如何设置:通过数据库事物提交的时间作为参考值)
     */
    public static final int DEFAULT_BATCH_EXPIRE = 100;
    /**
     * 尝试间隔时间
     */
    public static final int SLEEP = 100;
    /**
     * 如果锁空闲立即返回，否则阻塞等待
     * @param key
     */
    public void lock(String key);

    /**
     * 获取锁,获取立即返回true，否则返回false
     * @param key
     * @return
     */
    public boolean tryLock(String key);

    /**
     * 等待超时前获取锁成功 返回true， 否则返回false
     * @param key
     * @param timeout
     * @param unit
     * @return
     */
    public boolean tryLock(String key, long timeout, TimeUnit unit);

    /**
     * 批量获取锁，全部获取成功返回true,否则返回false
     * @param keys
     * @return
     */
    public boolean tryLock(List<String> keys);

    /**
     * 等待超时前获取锁成功 返回true， 否则返回false
     * @param keys
     * @param timeout
     * @param unit
     * @return
     */
    public boolean tryLock(List<String> keys, long timeout, TimeUnit unit);


    /**
     * 释放锁
     * @param key
     */
    public boolean unLock(String key);
    /**
     * 批量释放锁
     * @param keys
     */
    public void unLock(List<String> keys);
}
