package com.llbt.meepwn.lincoinblock.utils.network.volley.callback;

import org.json.JSONObject;

/**
 * Created by MeePwn on 15/8/5.
 * 返回成功回调（可以自定义返回结果）
 */
public interface ResponseListener {

    void onResponse(JSONObject response);

}
