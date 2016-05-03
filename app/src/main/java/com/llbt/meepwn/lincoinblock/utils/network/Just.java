package com.llbt.meepwn.lincoinblock.utils.network;

import android.content.Context;

import com.llbt.meepwn.lincoinblock.framework.Model;
import com.llbt.meepwn.lincoinblock.library.volley.Request;
import com.llbt.meepwn.lincoinblock.library.volley.Response;
import com.llbt.meepwn.lincoinblock.library.volley.toolbox.StringRequest;
import com.llbt.meepwn.lincoinblock.main.model.UserModel;
import com.llbt.meepwn.lincoinblock.main.model.test_json.TestJsonModel;
import com.llbt.meepwn.lincoinblock.utils.network.volley.queue.GlobalQueue;

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

    /**
     * Supported request methods.
     */
    public interface Method {
        int DEPRECATED_GET_OR_POST = -1;
        int GET = 0;
        int POST = 1;
        int PUT = 2;
        int DELETE = 3;
        int HEAD = 4;
        int OPTIONS = 5;
        int TRACE = 6;
        int PATCH = 7;
    }

    private static Request request;

    public static Observable<Model> sendRequest(Context context, String url, int method, Map<String, String> params, Class clazz) {
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
                sendRequest(context, url, method, params,
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

    @SuppressWarnings("unchecked")
    private static <T> Request<T> sendRequest(Context context, String url, int method, Map<String, String> params, Response.Listener<String> listener, Response.ErrorListener error) {
        request = new StringRequest(method, url, listener, error);
        return GlobalQueue.getGlobalQueue(context).add((Request<T>) request);
    }

    public static void cancelRequest() {
        if (request == null) return;
        request.cancel();
    }

}
