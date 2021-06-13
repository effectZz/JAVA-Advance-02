package com.example.demo.no9;

import redis.clients.jedis.JedisPool;

public class PubSubService {

    public static void main(String[] args) {

        JedisPool jedisPool = new JedisPool("47.100.125.213",6379);
        String channelName = "order";

        new Sub().subTest(jedisPool,channelName);
        new Pub().pubTest(jedisPool,channelName);
    }
}
