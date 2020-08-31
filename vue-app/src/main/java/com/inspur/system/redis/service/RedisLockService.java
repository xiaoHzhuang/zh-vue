package com.inspur.system.redis.service;

import com.inspur.constant.RedisConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

@Component
public class RedisLockService {

    private Logger logger = LoggerFactory.getLogger(RedisLockService.class);

    @Autowired
    private RedisLockRegistry redisLockRegistry;

    public void lock(String lockKey) {
        Lock lock = obtainLock(lockKey);
        lock.lock();
    }

    public boolean tryLock(String lockKey) {
        Lock lock = obtainLock(lockKey);
        return lock.tryLock();
    }

    public boolean tryLock(String lockKey, long seconds) {
        Lock lock = obtainLock(lockKey);
        try {
            return lock.tryLock(seconds, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            return false;
        }
    }

    public void unlock(String lockKey) {
        try {
            Lock lock = obtainLock(lockKey);
            lock.unlock();
            redisLockRegistry.expireUnusedOlderThan(RedisConstant.DEFAULT_EXPIRE_UNUSED);
        } catch (Exception e) {
            logger.error("分布式锁 [{}] 释放异常", lockKey, e);
        }
    }

    private Lock obtainLock(String lockKey) {
        return redisLockRegistry.obtain(lockKey);
    }

}
