package com.zzz.miaosha.redis;

public interface KeyPrefix {

    int expireSeconds();

    String getPrefix();
}
