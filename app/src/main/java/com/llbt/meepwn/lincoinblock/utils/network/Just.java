package com.llbt.meepwn.lincoinblock.utils.network;

import android.content.Context;

import com.llbt.meepwn.lincoinblock.framework.Model;
import com.llbt.meepwn.lincoinblock.library.volley.Request;
import com.llbt.meepwn.lincoinblock.library.volley.Response;
import com.llbt.meepwn.lincoinblock.library.volley.toolbox.StringRequest;
import com.llbt.meepwn.lincoinblock.library.volley.toolbox.Volley;
import com.llbt.meepwn.lincoinblock.main.model.UserModel;
import com.llbt.meepwn.lincoinblock.main.model.test_json.TestJsonModel;

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

    public static Observable<Model> sendRequest(Context context, String url, Map<String, String> params, Class clazz) {
        return Observable.create((Observable.OnSubscribe<Model>) subscriber -> {
            // TODO 添加访问网络方法
            if (clazz == UserModel.class) {
                subscriber.onNext(new UserModel());
                subscriber.onCompleted();
            } else if (clazz == TestJsonModel.class) {
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
            } else {
                sendRequest(context, url, params,
                        response -> {
                            subscriber.onNext(ModelAdapter.modelWithJsonString(response, clazz));
                            subscriber.onCompleted();
                        },
                        error -> subscriber.onError(new Throwable(error.getMessage())));
            }
        })
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread());
    }

    private static void sendRequest(Context context, String url, Map<String, String> params, Response.Listener<String> listener, Response.ErrorListener error) {
        StringRequest request = new StringRequest(Request.Method.GET, url, listener, error);
        Volley.newRequestQueue(context).add(request);
    }

}
