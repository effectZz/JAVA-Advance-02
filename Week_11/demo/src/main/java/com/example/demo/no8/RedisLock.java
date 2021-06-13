package com.example.demo.no8;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;

public class RedisLock {

    private RedisLock(){};

    private static RedisLock redisLock = new RedisLock();

    private JedisPool jedisPool = new JedisPool("47.100.125.213",6379);

    public static RedisLock getInstance() {
        return redisLock;
    }

    /**
     * 加锁
     */
    public boolean lock(String lockValue, long seconds) {
        try(Jedis jedis = jedisPool.getResource()) {
            // 相当于设置一个规范，可应用到其他键值对
            SetParams params = new SetParams();
            // 过期时间seconds
            params.ex(seconds);
            // 创建键值对之前先判断是否存在，存在则不创建
            params.nx();
            return "OK".equals(jedis.set(lockValue, lockValue, params));
        }
    }

    /**
     * 释放锁
     */
    public boolean release(String lock) {
        String luaScript = "if redis.call('get',KEYS[1]) == ARGV[1] then " + "return redis.call('del',KEYS[1]) else return 0 end";
        try(Jedis jedis = jedisPool.getResource()) {
            return jedis.eval(luaScript, Collections.singletonList(lock), Collections.singletonList(lock)).equals(1L);
        }
    }
}
