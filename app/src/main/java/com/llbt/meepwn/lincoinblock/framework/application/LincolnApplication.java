package com.llbt.meepwn.lincoinblock.framework.application;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * package: com.llbt.meepwn.lincoinblock.framework.application
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/5/5 下午5:08
 * desc: LincolnApplication
 */
public class LincolnApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        appConfig();
    }

    private void appConfig() {
        // 检查内存泄露
        LeakCanary.install(this);
    }
}
