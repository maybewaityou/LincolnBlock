package com.llbt.meepwn.lincoinblock.framework.base;

import android.content.Context;

import com.llbt.meepwn.lincoinblock.framework.DataModel;
import com.llbt.meepwn.lincoinblock.framework.Service;
import com.llbt.meepwn.lincoinblock.utils.network.Just;

import java.lang.ref.WeakReference;

import rx.Observable;

/**
 * package: com.llbt.meepwn.lincoinblock.framework.base
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/12 下午12:46
 * desc: 进行页面间跳转 && 发送网络请求
 */
public abstract class BaseService<DM extends DataModel> implements Service {

    protected WeakReference<Context> context;

    public BaseService(Context context) {
        this.context = new WeakReference<>(context);
    }

    public Context getContext() {
        return context.get();
    }

    @Override
    public Observable sendRequest() {
        return Just.sendRequest();
    }

    protected abstract void pushActivityWithDataModel(DM dataModel, Class clazz);

}
