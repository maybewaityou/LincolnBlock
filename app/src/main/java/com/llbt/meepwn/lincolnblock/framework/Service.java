package com.llbt.meepwn.lincolnblock.framework;

import android.app.Activity;
import android.content.Context;

import com.llbt.meepwn.lincolnblock.framework.types.DataModelType;
import com.llbt.meepwn.lincolnblock.framework.permission.PermissionRequest;
import com.llbt.meepwn.lincolnblock.framework.types.ServiceType;
import com.llbt.meepwn.lincolnblock.framework.application.LincolnApplication;
import com.llbt.meepwn.lincolnblock.utils.network.Just;
import com.tbruyelle.rxpermissions.Permission;
import com.tbruyelle.rxpermissions.RxPermissions;

import java.lang.ref.WeakReference;
import java.util.Map;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * package: com.llbt.meepwn.lincolnblock.framework.base
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/12 下午12:46
 * desc: 进行页面间跳转 && 发送网络请求
 */
public abstract class Service<DM extends DataModelType> implements ServiceType<DM>, PermissionRequest {

    protected WeakReference<Context> context;

    public Service(Context context) {
        this.context = new WeakReference<>(context);
        LincolnApplication.getRefWatcher(context).watch(this);
    }

    @Override
    public Context getContext() {
        return context.get();
    }

    @Override
    public Observable sendRequest(String url, int method, Map<String, String> params, Class clazz) {
        return Just.sendRequest(context.get(), url, method, params, clazz);
    }

    @Override
    public void cancelRequest() {
        Just.cancelRequest();
    }

    @Override
    public void cancelRequestWithUrl(String url) {
        Just.cancelRequestWithUrl(url);
    }

    @Override
    public Observable<Boolean> requestPermission(String permission) {
        return RxPermissions.getInstance(context.get())
                .request(permission)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Permission> requestMutablePermission(String... permission) {
        return RxPermissions.getInstance(context.get())
            .requestEach(permission)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void popActivity() {
        ((Activity)context.get()).finish();
    }

}
