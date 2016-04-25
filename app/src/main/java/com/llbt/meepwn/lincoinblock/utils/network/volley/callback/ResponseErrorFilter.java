package com.llbt.meepwn.lincoinblock.utils.network.volley.callback;

import org.json.JSONObject;

/**
 * Created by MeePwn on 15/9/2.
 *
 */
public interface ResponseErrorFilter {
    void onErrorFilter(JSONObject errorResponse);
}
