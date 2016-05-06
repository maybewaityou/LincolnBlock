package com.llbt.meepwn.lincolnblock.main.service;

import android.content.Context;

import com.llbt.meepwn.lincolnblock.framework.base.BaseService;
import com.llbt.meepwn.lincolnblock.main.data_model.TestItemDataModel;

/**
 * package: com.llbt.meepwn.lincolnblock.main.service
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/14 下午1:10
 * desc:
 */
public class TestItemService extends BaseService<TestItemDataModel> {

    public TestItemService(Context context) {
        super(context);
    }

    @Override
    public void pushActivityWithDataModel(TestItemDataModel dataModel, Class clazz) {

    }
}
