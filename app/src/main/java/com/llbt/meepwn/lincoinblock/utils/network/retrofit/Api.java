package com.llbt.meepwn.lincoinblock.utils.network.retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * package: com.llbt.meepwn.lincoinblock.utils.network.retrofit
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/27 上午5:56
 * desc:
 */
public class Api {

    public static void send() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);
        service.fetchData().enqueue(new Callback<Github>() {
            @Override
            public void onResponse(Call<Github> call, Response<Github> response) {
                System.out.println("== response.body() ===>>>>> " + response.body());
            }

            @Override
            public void onFailure(Call<Github> call, Throwable t) {
                System.out.println("== error ===>>>>> " + t);
            }
        });
    }

}
