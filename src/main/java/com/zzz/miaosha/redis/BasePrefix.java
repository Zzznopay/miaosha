package com.zzz.miaosha.redis;

public abstract class BasePrefix implements KeyPrefix {

    private int expireSeconds;

    private String Prefix;

    public BasePrefix(String prefix) {
        this(0,prefix);//0代表永不过期
    }

    public BasePrefix(int expireSeconds, String Prefix) {
        this.expireSeconds = expireSeconds;
        this.Prefix = Prefix;
    }

    @Override
    //默认0代表永不过期
    public int expireSeconds() {
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className + ":" + Prefix;
    }
}
