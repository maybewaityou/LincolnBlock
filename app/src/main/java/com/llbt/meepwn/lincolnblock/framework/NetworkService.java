package com.llbt.meepwn.lincolnblock.framework;

import java.util.Map;

import rx.Observable;

/**
 * package: com.llbt.meepwn.lincolnblock.framework
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/12 上午11:13
 * desc:
 */
public interface NetworkService {

    void popActivity();

    Observable sendRequest(String url, int method, Map<String, String> params, Class clazz);

    void cancelRequest();

    void cancelRequestWithUrl(String url);

}
