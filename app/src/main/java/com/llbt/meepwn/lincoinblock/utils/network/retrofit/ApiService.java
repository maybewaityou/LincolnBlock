package com.llbt.meepwn.lincoinblock.utils.network.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * package: com.llbt.meepwn.lincoinblock.utils.network.retrofit
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/27 上午5:54
 * desc:
 */
public interface ApiService {

    @GET("https://api.github.com")
    Call<Github> fetchData();

}
