package com.llbt.meepwn.lincoinblock.utils.network;

import com.llbt.meepwn.lincoinblock.framework.Model;
import com.llbt.meepwn.lincoinblock.main.model.UserModel;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * package: com.llbt.meepwn.lincoinblock.utils.network
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/13 下午3:06
 * desc:
 */
public class Just {

    public static Observable sendRequest() {
        return Observable.create((Observable.OnSubscribe<Model>) subscriber -> {
            // TODO 添加访问网络方法
            subscriber.onNext(new UserModel());
            subscriber.onCompleted();
            
//            subscriber.onError(new Throwable("网络请求失败", null));
        })
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread());
    }

}
