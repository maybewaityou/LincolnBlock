package com.llbt.meepwn.lincoinblock.main.view.activity

import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.os.Bundle
import com.llbt.meepwn.lincoinblock.R
import com.llbt.meepwn.lincoinblock.databinding.MainBinding
import com.llbt.meepwn.lincoinblock.framework.base.BaseActivity
import com.llbt.meepwn.lincoinblock.main.model.UserModel
import com.llbt.meepwn.lincoinblock.main.service.UserService
import com.llbt.meepwn.lincoinblock.main.view_model.UserViewModel

class MainActivity : BaseActivity<UserModel, UserViewModel, UserService>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<MainBinding>(this, R.layout.activity_main)
        model = ObservableField(UserModel())
        service = UserService(this)
        viewModel = UserViewModel(service, model)
        binding.viewModel = viewModel
    }

}
