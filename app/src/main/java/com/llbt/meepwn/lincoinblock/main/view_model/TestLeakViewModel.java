package com.llbt.meepwn.lincoinblock.main.view_model;

import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;

import com.llbt.meepwn.lincoinblock.framework.base.BaseViewModel;
import com.llbt.meepwn.lincoinblock.framework.nullable.ModelNullable;
import com.llbt.meepwn.lincoinblock.framework.nullable.ServiceNullable;

/**
 * package: com.llbt.meepwn.lincoinblock.main.view_model
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/5/6 上午9:53
 * desc:
 */
public class TestLeakViewModel extends BaseViewModel<ModelNullable, ServiceNullable> {

    public TestLeakViewModel(Context context) {
        super(context);
    }

    public void handleClick(View view) {
        startAsyncTask();
    }

    void startAsyncTask() {
        new AsyncTask<Void, Void, Void>() {
            @Override protected Void doInBackground(Void... params) {
                // Do some slow work in background
                SystemClock.sleep(5000);
                return null;
            }
        }.execute();
    }

}
