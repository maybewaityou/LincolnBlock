package com.llbt.meepwn.lincoinblock.framework.base;

import android.databinding.ObservableField;

import com.llbt.meepwn.lincoinblock.framework.Model;
import com.llbt.meepwn.lincoinblock.framework.Service;
import com.llbt.meepwn.lincoinblock.framework.ViewModel;

/**
 * package: com.llbt.meepwn.lincoinblock.framework
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/12 上午11:34
 * desc: 处理业务逻辑
 */
public class BaseViewModel<M extends Model, S extends Service> implements ViewModel {

    protected ObservableField<M> model;
    protected S service;

    public BaseViewModel(S service) {
        this.service = service;
    }

    public BaseViewModel(S service, ObservableField<M> model) {
        this.service = service;
        this.model = model;
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
