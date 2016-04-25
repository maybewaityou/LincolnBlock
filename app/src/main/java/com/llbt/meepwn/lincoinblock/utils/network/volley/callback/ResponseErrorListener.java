package com.llbt.meepwn.lincoinblock.utils.network.volley.callback;


import com.llbt.meepwn.lincoinblock.library.volley.VolleyError;

/**
 * Created by MeePwn on 15/8/5.
 * * 返回失败回调（可以自定义返回结果）
 */
public interface ResponseErrorListener {

    void onErrorResponse(VolleyError error);

}
