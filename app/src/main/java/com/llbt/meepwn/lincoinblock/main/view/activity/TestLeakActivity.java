package com.llbt.meepwn.lincoinblock.main.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.llbt.meepwn.lincoinblock.R;
import com.llbt.meepwn.lincoinblock.databinding.LeakBinding;
import com.llbt.meepwn.lincoinblock.framework.base.BaseActivity;
import com.llbt.meepwn.lincoinblock.framework.nullable.ModelNullable;
import com.llbt.meepwn.lincoinblock.framework.nullable.ServiceNullable;
import com.llbt.meepwn.lincoinblock.main.view_model.TestLeakViewModel;

/**
 * package: com.llbt.meepwn.lincoinblock.main.view.activity
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/5/6 上午9:52
 * desc:
 */
public class TestLeakActivity extends BaseActivity<ModelNullable, TestLeakViewModel, ServiceNullable> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LeakBinding binding = DataBindingUtil.setContentView(this, R.layout.act_leak_test);
        TestLeakViewModel viewModel = new TestLeakViewModel(this);
        binding.setViewModel(viewModel);
    }

}
