package com.llbt.meepwn.lincoinblock.utils.network.volley.request;

import com.llbt.meepwn.lincoinblock.library.volley.AuthFailureError;
import com.llbt.meepwn.lincoinblock.library.volley.NetworkResponse;
import com.llbt.meepwn.lincoinblock.library.volley.Response;
import com.llbt.meepwn.lincoinblock.library.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * package: com.llbt.meepwn.lincoinblock.main
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/26 上午5:25
 * desc:
 */
public class JsonPostRequest extends JsonObjectRequest {

    /**
     * 自定义构造，访问网络接口时，直接使用此构造
     *
     * @param jsonRequest 请求体
     * @param listener    接口成功回调
     */
    public JsonPostRequest(int method, String url, JSONObject jsonRequest, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(method, url, jsonRequest, listener, errorListener);
    }

    public JsonPostRequest(String url, JSONObject jsonRequest, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(url, jsonRequest, listener, errorListener);
    }


    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("AJAX", "Y");
//        String cookie = BaseApplication.getInstance().getCookie();
//        if (!"".equals(cookie)||!"null".equals(cookie)||cookie != null) {
//            headers.put("Cookie", cookie);
//        }
        return headers;
    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
//        if (BaseApplication.getInstance().getCookie() != null ) {
//            return super.parseNetworkResponse(response);
//        }

//        for (String s : response.headers.keySet()) {
//            if (s.contains("Set-Cookie")) {
//                BaseApplication.getInstance().setCookie(response.headers.get(s));
//                break;
//            }
//        }

        return super.parseNetworkResponse(response);
    }
}
