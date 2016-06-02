package com.llbt.meepwn.lincolnblock.framework.base;

import android.annotation.SuppressLint;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.jude.swipbackhelper.SwipeBackHelper;
import com.llbt.meepwn.lincolnblock.framework.Model;
import com.llbt.meepwn.lincolnblock.framework.ServiceType;
import com.llbt.meepwn.lincolnblock.framework.ViewModelType;
import com.llbt.meepwn.lincolnblock.framework.permission.PermissionRequest;
import com.tbruyelle.rxpermissions.Permission;
import com.tbruyelle.rxpermissions.RxPermissions;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * package: com.llbt.meepwn.lincolnblock.framework
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/12 上午10:50
 * desc:
 */
@SuppressLint("Registered")
public class BaseActivity<M extends Model, VM extends ViewModelType, S extends ServiceType> extends FragmentActivity implements PermissionRequest {

    protected ObservableField<M> model;
    protected VM viewModel;
    protected S service;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SwipeBackHelper.onCreate(this);

//        SwipeBackHelper.getCurrentPage(this)//获取当前页面
//                .setSwipeBackEnable(true)//设置是否可滑动
//                .setSwipeEdge(200)//可滑动的范围。px。200表示为左边200px的屏幕
//                .setSwipeEdgePercent(0.2f)//可滑动的范围。百分比。0.2表示为左边20%的屏幕
//                .setSwipeSensitivity(0.5f)//对横向滑动手势的敏感程度。0为迟钝 1为敏感
//                .setScrimColor(Color.BLUE)//底层阴影颜色
//                .setClosePercent(0.8f)//触发关闭Activity百分比
//                .setSwipeRelateEnable(false)//是否与下一级activity联动(微信效果)。默认关
//                .setSwipeRelateOffset(500)//activity联动时的偏移量。默认500px。
//                .setDisallowInterceptTouchEvent(true)//不抢占事件，默认关（事件将先由子View处理再由滑动关闭处理）
//                .addListener(new SwipeListener() {//滑动监听
//
//                    @Override
//                    public void onScroll(float percent, int px) {//滑动的百分比与距离
//                    }
//
//                    @Override
//                    public void onEdgeTouch() {//当开始滑动
//                    }
//
//                    @Override
//                    public void onScrollToClose() {//当滑动关闭
//                    }
//                });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SwipeBackHelper.onPostCreate(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SwipeBackHelper.onDestroy(this);
    }

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
