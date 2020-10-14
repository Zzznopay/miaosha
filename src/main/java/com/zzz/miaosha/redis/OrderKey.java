package com.zzz.miaosha.redis;

public class OrderKey extends BasePrefix {
    public static OrderKey getMiaoshaOrderByUidGid = new OrderKey(0,"moug");

    public OrderKey(int expireSeconds, String getPrefix) {
        super(expireSeconds, getPrefix);
    }
}
