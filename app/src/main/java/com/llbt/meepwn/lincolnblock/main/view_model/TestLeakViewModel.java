package com.llbt.meepwn.lincolnblock.main.view_model;

import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;

import com.llbt.meepwn.lincolnblock.framework.ViewModel;
import com.llbt.meepwn.lincolnblock.framework.nullable.ModelNullable;
import com.llbt.meepwn.lincolnblock.framework.nullable.ServiceNullable;

/**
 * package: com.llbt.meepwn.lincolnblock.main.view_model
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/5/6 上午9:53
 * desc:
 */
public class TestLeakViewModel extends ViewModel<ModelNullable, ServiceNullable> {

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
