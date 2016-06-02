package com.llbt.meepwn.lincolnblock.framework.base;

import android.content.Context;
import android.databinding.ObservableField;

import com.llbt.meepwn.lincolnblock.framework.ModelType;
import com.llbt.meepwn.lincolnblock.framework.ServiceType;
import com.llbt.meepwn.lincolnblock.framework.ViewModelType;
import com.llbt.meepwn.lincolnblock.framework.application.LincolnApplication;

/**
 * package: com.llbt.meepwn.lincolnblock.framework
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/12 上午11:34
 * desc: 处理业务逻辑
 */
public class BaseViewModel<M extends ModelType, S extends ServiceType> implements ViewModelType {

    protected ObservableField<M> model;
    protected S service;

    public BaseViewModel(Context context) {
        LincolnApplication.getRefWatcher(context).watch(this);
    }

    public BaseViewModel(S service) {
        this.service = service;
        LincolnApplication.getRefWatcher(service.getContext()).watch(this);
    }

    public BaseViewModel(S service, ObservableField<M> model) {
        this.service = service;
        this.model = model;
        LincolnApplication.getRefWatcher(service.getContext()).watch(this);
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    public ObservableField<M> getModel() {
        return model;
    }

}
