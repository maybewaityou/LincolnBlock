package com.llbt.meepwn.lincoinblock.framework;

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
public class NullableValue implements Model, ViewModel, Service, DataModel {

    @Override
    public Observable sendRequest() {
        return Just.sendRequest();
    }
}
