package com.llbt.meepwn.lincoinblock.main.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.llbt.meepwn.lincoinblock.R;
import com.llbt.meepwn.lincoinblock.framework.base.BaseActivity;
import com.llbt.meepwn.lincoinblock.framework.nullable.ModelNullable;
import com.llbt.meepwn.lincoinblock.framework.nullable.ServiceNullable;
import com.llbt.meepwn.lincoinblock.framework.nullable.ViewModelNullable;
import com.llbt.meepwn.lincoinblock.main.view.fragment.TestFragment;

/**
 * package: com.llbt.meepwn.lincoinblock.main.view.activity
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/21 上午6:49
 * desc:
 */
public class TestFragmentActivity extends BaseActivity<ModelNullable, ViewModelNullable, ServiceNullable> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_frag_test);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new TestFragment()).commit();
    }
}
