package com.llbt.meepwn.lincoinblock.main.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.llbt.meepwn.lincoinblock.R;
import com.llbt.meepwn.lincoinblock.databinding.OtherBinding;
import com.llbt.meepwn.lincoinblock.framework.base.BaseActivity;
import com.llbt.meepwn.lincoinblock.framework.nullable.ModelNullable;
import com.llbt.meepwn.lincoinblock.main.service.OtherService;
import com.llbt.meepwn.lincoinblock.main.view_model.OtherViewModel;

/**
 * package: com.llbt.meepwn.lincoinblock
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/6 下午4:56
 * <p>
 * desc:
 */
public class OtherActivity extends BaseActivity<ModelNullable, OtherViewModel, OtherService> {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OtherBinding binding = DataBindingUtil.setContentView(this, R.layout.act_other);
        service = new OtherService(this);
        viewModel = new OtherViewModel(service);
        binding.listView.setAdapter(viewModel.fetchAdapter());
        binding.listView.setOnItemClickListener(viewModel);
    }

}