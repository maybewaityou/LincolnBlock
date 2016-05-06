package com.llbt.meepwn.lincolnblock.utils.network.volley.callback;

import org.json.JSONObject;

/**
 * package: com.llbt.meepwn.lincolnblock.utils.network.volley
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/25 上午6:11
 * desc: 返回成功回调(可以过滤返回结果)
 */
public interface ResponseErrorFilter {

    void onErrorFilter(JSONObject errorResponse);

}
