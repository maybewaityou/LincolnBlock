package com.llbt.meepwn.lincoinblock.framework.base;

import com.llbt.meepwn.lincoinblock.framework.DataModel;
import com.llbt.meepwn.lincoinblock.framework.Model;
import com.llbt.meepwn.lincoinblock.framework.Service;
import com.llbt.meepwn.lincoinblock.framework.ViewModel;
import com.llbt.meepwn.lincoinblock.utils.network.Just;

import rx.Observable;

/**
 * package: com.llbt.meepwn.lincoinblock.framework
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/20 上午11:07
 * desc:
 */
public abstract class NullableValue implements Model, ViewModel, Service, DataModel {

    @Override
    public Observable sendRequest(Class clazz) {
        return Just.sendRequest(clazz);
    }
}
