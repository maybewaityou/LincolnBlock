package com.llbt.meepwn.lincolnblock.utils.network;

import android.content.Context;

import com.llbt.meepwn.lincolnblock.framework.types.ModelType;
import com.llbt.meepwn.lincolnblock.library.volley.Request;
import com.llbt.meepwn.lincolnblock.library.volley.Response;
import com.llbt.meepwn.lincolnblock.library.volley.toolbox.StringRequest;
import com.llbt.meepwn.lincolnblock.main.model.UserModel;
import com.llbt.meepwn.lincolnblock.main.model.test_json.JsonModel;
import com.llbt.meepwn.lincolnblock.utils.network.volley.queue.GlobalQueue;

import java.util.Map;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * package: com.llbt.meepwn.lincolnblock.utils.network
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

    public static Observable<ModelType> sendRequest(Context context, String url, int method, Map<String, String> params, Class clazz, Class targetClass) {
        return Observable.create((Observable.OnSubscribe<ModelType>) subscriber -> {
            // TODO 添加访问网络方法
            if (clazz == UserModel.class) {
                subscriber.onNext(new UserModel());
                subscriber.onCompleted();
            } else if (clazz == JsonModel.class) {
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
                subscriber.onNext(ModelAdapter.modelWithJsonString(jsonString, clazz, targetClass));
                subscriber.onCompleted();
            } else {
                sendRequest(context, url, method, params,
                        response -> {
                            subscriber.onNext(ModelAdapter.modelWithJsonString(response, clazz, targetClass));
                            subscriber.onCompleted();
                        },
                        error -> {
                            subscriber.onError(new Throwable(error.getMessage()));
                        });
            }
        })
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread());
    }

    @SuppressWarnings("unchecked")
    private static <T> Request<T> sendRequest(Context context, String url, int method, Map<String, String> params, Response.Listener<String> listener, Response.ErrorListener error) {
        request = new StringRequest(method, url, listener, error);
        request.setTag(url);
        return GlobalQueue.getGlobalQueue(context).add((Request<T>) request);
    }

    public static void cancelRequest() {
        cancelRequestWithUrl(null);
    }

    public static void cancelRequestWithUrl(String url) {
        if (request == null) return;
        if (url == null) {
            request.cancel();
            return;
        }
        GlobalQueue.getGlobalQueue(null).cancelAll(url);
    }

}
