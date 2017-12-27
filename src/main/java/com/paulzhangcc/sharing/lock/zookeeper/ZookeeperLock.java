package com.paulzhangcc.sharing.lock.zookeeper;

import com.paulzhangcc.sharing.lock.Lock;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
public class ZookeeperLock implements Lock {
    @Override
    public void lock(String key) {

    }

    @Override
    public boolean tryLock(String key) {
        return false;
    }

    @Override
    public boolean tryLock(String key, long timeout, TimeUnit unit) {
        return false;
    }

    @Override
    public boolean tryLock(List<String> keys) {
        return false;
    }

    @Override
    public boolean tryLock(List<String> keys, long timeout, TimeUnit unit) {
        return false;
    }

    @Override
    public boolean unLock(String key) {
        return false;
    }

    @Override
    public void unLock(List<String> keys) {

    }
}
