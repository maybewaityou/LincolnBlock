package com.llbt.meepwn.lincoinblock.framework.base;

import android.databinding.ObservableField;
import android.support.v4.app.FragmentActivity;

import com.llbt.meepwn.lincoinblock.framework.Model;
import com.llbt.meepwn.lincoinblock.framework.Service;
import com.llbt.meepwn.lincoinblock.framework.ViewModel;

/**
 * package: com.llbt.meepwn.lincoinblock.framework
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/12 上午10:50
 * desc:
 */
public class BaseActivity<M extends Model, VM extends ViewModel, S extends Service> extends FragmentActivity {

    protected ObservableField<M> model;
    protected VM viewModel;
    protected S service;

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

}
