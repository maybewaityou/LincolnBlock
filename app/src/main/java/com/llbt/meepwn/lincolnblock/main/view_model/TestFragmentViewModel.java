package com.llbt.meepwn.lincolnblock.main.view_model;

import android.databinding.ObservableField;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;

import com.llbt.meepwn.lincolnblock.framework.ViewModel;
import com.llbt.meepwn.lincolnblock.main.model.TestFragmentModel;
import com.llbt.meepwn.lincolnblock.main.service.TestFragmentService;

/**
 * package: com.llbt.meepwn.lincolnblock.main.view_model
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/21 上午8:39
 * desc:
 */
public class TestFragmentViewModel extends ViewModel<TestFragmentModel, TestFragmentService> {

    public TestFragmentViewModel(TestFragmentService service, ObservableField<TestFragmentModel> model) {
        super(service, model);
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
