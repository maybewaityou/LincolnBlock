package com.llbt.meepwn.lincoinblock.framework.base;

import android.annotation.SuppressLint;
import android.databinding.ObservableField;
import android.support.v4.app.FragmentActivity;

import com.llbt.meepwn.lincoinblock.framework.Model;
import com.llbt.meepwn.lincoinblock.framework.PermissionRequest;
import com.llbt.meepwn.lincoinblock.framework.Service;
import com.llbt.meepwn.lincoinblock.framework.ViewModel;
import com.tbruyelle.rxpermissions.Permission;
import com.tbruyelle.rxpermissions.RxPermissions;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * package: com.llbt.meepwn.lincoinblock.framework
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/12 上午10:50
 * desc:
 */
@SuppressLint("Registered")
public class BaseActivity<M extends Model, VM extends ViewModel, S extends Service> extends FragmentActivity implements PermissionRequest {

    protected ObservableField<M> model;
    protected VM viewModel;
    protected S service;

    @Override
    public Observable<Boolean> requestPermission(String permission) {
        return RxPermissions.getInstance(service.getContext())
                .request(permission)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Permission> requestMutablePermission(String... permission) {
        return RxPermissions.getInstance(service.getContext())
                .requestEach(permission)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (viewModel == null) return;
        viewModel.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (viewModel == null) return;
        viewModel.onPause();
    }

}
