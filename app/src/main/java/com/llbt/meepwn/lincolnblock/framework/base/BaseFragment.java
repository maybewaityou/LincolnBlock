package com.llbt.meepwn.lincolnblock.framework.base;

import android.databinding.ObservableField;
import android.support.v4.app.Fragment;

import com.llbt.meepwn.lincolnblock.framework.ModelType;
import com.llbt.meepwn.lincolnblock.framework.ServiceType;
import com.llbt.meepwn.lincolnblock.framework.ViewModelType;
import com.llbt.meepwn.lincolnblock.framework.application.LincolnApplication;

/**
 * package: com.llbt.meepwn.lincolnblock.framework.base
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/21 上午6:50
 * desc:
 */
public class BaseFragment<M extends ModelType, VM extends ViewModelType, S extends ServiceType> extends Fragment {

    protected ObservableField<M> model;
    protected VM viewModel;
    protected S service;

    @Override
    public void onDestroy() {
        super.onDestroy();
        LincolnApplication.getRefWatcher(getActivity()).watch(this);
    }
}
