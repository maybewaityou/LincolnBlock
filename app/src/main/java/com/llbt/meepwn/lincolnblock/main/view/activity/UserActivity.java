package com.llbt.meepwn.lincolnblock.main.view.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.llbt.meepwn.lincolnblock.R;
import com.llbt.meepwn.lincolnblock.databinding.MainBinding;
import com.llbt.meepwn.lincolnblock.framework.base.BaseActivity;
import com.llbt.meepwn.lincolnblock.main.model.UserModel;
import com.llbt.meepwn.lincolnblock.main.service.UserService;
import com.llbt.meepwn.lincolnblock.main.view_model.UserViewModel;

/**
 * package: com.llbt.meepwn.lincolnblock.main.view.activity
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/29 下午2:57
 * desc:
 */
@SuppressWarnings("unchecked")
public class UserActivity extends BaseActivity<UserModel, UserViewModel, UserService> {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
		model = new ObservableField(new UserModel());
		service = new UserService(this);
		viewModel = new UserViewModel(service, model);
		binding.setViewModel(viewModel);
	}
}
