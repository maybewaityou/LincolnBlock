package com.llbt.meepwn.lincoinblock.utils;

/**
 * package: com.llbt.meepwn.lincoinblock.utils
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/20 下午1:11
 * desc:  单例
 */
public class Singleton {

    private volatile static Singleton instance;

    private Singleton() {
        if (instance != null) {
            throw new AssertionError();
        }
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
