package com.llbt.meepwn.lincoinblock.framework.application;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * package: com.llbt.meepwn.lincoinblock.framework.application
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/5/5 下午5:08
 * desc: LincolnApplication
 */
public class LincolnApplication extends Application {

    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();

        appConfig();
    }

    private void appConfig() {
        // 检查内存泄露
        refWatcher = LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context) {
        LincolnApplication application = (LincolnApplication) context.getApplicationContext();
        return application.refWatcher;
    }

}
