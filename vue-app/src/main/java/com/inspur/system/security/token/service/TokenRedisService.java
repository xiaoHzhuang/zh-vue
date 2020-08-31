package com.inspur.system.security.token.service;

import com.inspur.constant.TokenConstant;
import com.inspur.system.redis.service.RedisOptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenRedisService {
    @Autowired
    private RedisOptService redisOptService;

    /**
     * 保存token至redis中
     *
     * @param token  token
     * @param userId 用户id
     */
    public void saveTokenwithExpireTime(String token, String userId) {
        //token保存至redis中
        redisOptService.set(userId, token, TokenConstant.REDIS_TOKEN_EXPIRATION);
    }

    /**
     * 获取保存至redis中的entry
     *
     * @param userId 用户id
     * @return
     */
    public String getToken(String userId) {
        return (String) redisOptService.get(userId);
    }

    /**
     * 刷寻过期时间
     *
     * @param tokenKey
     */
    public void refreshExpireTime(String tokenKey) {
        redisOptService.expire(tokenKey, TokenConstant.REDIS_TOKEN_EXPIRATION);
    }

    /**
     * 删除指定的token
     *
     * @param tokenKey
     * @return
     */
    public boolean deleteToken(String tokenKey) {
        return redisOptService.deleteKey(tokenKey);
    }

    /**
     * redis中是否存在对应的token
     *
     * @param tokenKey
     * @return
     */
    public boolean hasTokenKey(String tokenKey) {
        return redisOptService.hasKey(tokenKey);
    }

    /**
     * 获取剩余过期时间
     *
     * @param tokenKey
     * @return
     */
    public long getTokenExpireTime(String tokenKey) {
        return redisOptService.getExpire(tokenKey);
    }
}
