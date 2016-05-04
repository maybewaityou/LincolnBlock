package com.llbt.meepwn.lincoinblock.utils.network.volley.callback;


import com.llbt.meepwn.lincoinblock.library.volley.VolleyError;

/**
 * package: com.llbt.meepwn.lincoinblock.utils.network.volley
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/25 上午6:11
 * desc: 返回失败回调(可以自定义返回结果)
 */
public interface ResponseErrorListener {

    void onErrorResponse(VolleyError error);

}
