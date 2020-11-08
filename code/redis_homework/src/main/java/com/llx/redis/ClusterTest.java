package com.llx.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

public class ClusterTest {
    public static void main(String[] args) {

        JedisPoolConfig config = new JedisPoolConfig();
        Set<HostAndPort> jedisClusterNode = new HashSet<>();
        jedisClusterNode.add(new HostAndPort("192.168.41.140", 7001));
        jedisClusterNode.add(new HostAndPort("192.168.41.140", 7002));
        jedisClusterNode.add(new HostAndPort("192.168.41.141", 7001));
        jedisClusterNode.add(new HostAndPort("192.168.41.141", 7002));
        jedisClusterNode.add(new HostAndPort("192.168.41.142", 7001));
        jedisClusterNode.add(new HostAndPort("192.168.41.142", 7002));
        jedisClusterNode.add(new HostAndPort("192.168.41.143", 7001));
        jedisClusterNode.add(new HostAndPort("192.168.41.143", 7002));
        JedisCluster jcd = new JedisCluster(jedisClusterNode, config);
        jcd.set("name:001", "zhaoyun");
        String value = jcd.get("name:001");
        System.out.println(value);
    }
}
