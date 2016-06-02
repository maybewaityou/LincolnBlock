package com.llbt.meepwn.lincolnblock.main.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.llbt.meepwn.lincolnblock.R;
import com.llbt.meepwn.lincolnblock.framework.base.ActivityController;
import com.llbt.meepwn.lincolnblock.framework.nullable.ModelNullable;
import com.llbt.meepwn.lincolnblock.framework.nullable.ServiceNullable;
import com.llbt.meepwn.lincolnblock.framework.nullable.ViewModelNullable;
import com.llbt.meepwn.lincolnblock.main.view.fragment.TestFragment;

/**
 * package: com.llbt.meepwn.lincolnblock.main.view.activity
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/21 上午6:49
 * desc:
 */
public class TestFragmentActivity extends ActivityController<ModelNullable, ViewModelNullable, ServiceNullable> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_frag_test);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new TestFragment()).commit();
    }
}
