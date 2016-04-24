package com.llbt.meepwn.lincoinblock.utils.network;

import com.llbt.meepwn.lincoinblock.framework.Model;
import com.llbt.meepwn.lincoinblock.main.model.UserModel;

import java.util.Map;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * package: com.llbt.meepwn.lincoinblock.utils.network
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/13 下午3:06
 * desc: 发送网络请求
 */
public class Just {

    public static Observable sendRequest(String url, Map<String, String> params, Class clazz) {
        return Observable.create((Observable.OnSubscribe<Model>) subscriber -> {
            // TODO 添加访问网络方法
            if (clazz == UserModel.class) {
                subscriber.onNext(new UserModel());
                subscriber.onCompleted();
                return;
            }
            String jsonString = "{\n" +
                    "    \"name\": \"MeePwn\",\n" +
                    "    \"age\": \"2333333\",\n" +
                    "    \"lastName\": \"Chunnan\",\n" +
                    "    \"dog\": {\n" +
                    "        \"dogName\": \"doge\",\n" +
                    "        \"age\": \"11\"\n" +
                    "    },\n" +
                    "    \"books\": [\n" +
                    "        {\n" +
                    "            \"bookName\": \"Swift\",\n" +
                    "            \"price\": \"¥65\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"bookName\": \"Objective C\",\n" +
                    "            \"price\": \"¥45\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"bookName\": \"iOS\",\n" +
                    "            \"price\": \"¥85\"\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}";
            subscriber.onNext(ModelAdapter.modelWithJsonString(jsonString, clazz));
            subscriber.onCompleted();
//            subscriber.onError(new Throwable("网络请求失败"));
        })
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread());
    }

}
