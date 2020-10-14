package com.zzz.miaosha.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "redis")
public class RedisConfig {
    /**
     * redis服务器地址
     */
    private String host;
    /**
     * redis服务器端口
     */
    private int port;
    /**
     * 连接超时时间
     */
    private int timeout;
    /**
     * redis服务器连接密码
     */
    private String password;
    /**
     * 连接池最大连接数
     */
    private int poolMaxTotal;
    /**
     * 连接池中的最大空闲连接
     */
    private int poolMaxIdle;
    /**
     * 连接池最大阻塞等待时间
     */
    private int poolMaxWait;

    public RedisConfig() {
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoolMaxTotal() {
        return poolMaxTotal;
    }

    public void setPoolMaxTotal(int poolMaxTotal) {
        this.poolMaxTotal = poolMaxTotal;
    }

    public int getPoolMaxIdle() {
        return poolMaxIdle;
    }

    public void setPoolMaxIdle(int poolMaxIdle) {
        this.poolMaxIdle = poolMaxIdle;
    }

    public int getPoolMaxWait() {
        return poolMaxWait;
    }

    public void setPoolMaxWait(int poolMaxWait) {
        this.poolMaxWait = poolMaxWait;
    }

    @Override
    public String toString() {
        return "RedisConfig{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", timeout=" + timeout +
                ", password='" + password + '\'' +
                ", poolMaxTotal=" + poolMaxTotal +
                ", poolMaxIdle=" + poolMaxIdle +
                ", poolMaxWait=" + poolMaxWait +
                '}';
    }
}
