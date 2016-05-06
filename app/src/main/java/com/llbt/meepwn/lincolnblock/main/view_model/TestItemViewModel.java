package com.llbt.meepwn.lincolnblock.main.view_model;

import android.databinding.ObservableField;
import android.view.View;

import com.llbt.meepwn.lincolnblock.framework.base.BaseViewModel;
import com.llbt.meepwn.lincolnblock.main.model.TestItemModel;
import com.llbt.meepwn.lincolnblock.main.service.TestItemService;

/**
 * package: com.llbt.meepwn.lincolnblock.main.view_model
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/14 下午1:10
 * desc:
 */
public class TestItemViewModel extends BaseViewModel<TestItemModel, TestItemService> {

    public TestItemViewModel(TestItemService service, ObservableField<TestItemModel> model) {
        super(service, model);
    }

    public void handleClick(View view) {
        System.out.println("=====>>>>> " + model.get());
    }

}
