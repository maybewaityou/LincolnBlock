package com.llbt.meepwn.lincoinblock.framework;

import android.content.Context;

import java.util.Map;

import rx.Observable;

/**
 * package: com.llbt.meepwn.lincoinblock.framework
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/12 上午11:13
 * desc:
 */
public interface Service<DM extends DataModel> {

    Context getContext();

    void pushActivityWithDataModel(DM dataModel, Class clazz);

    void popActivity();

    Observable sendRequest(String url, int method, Map<String, String> params, Class clazz);
}
