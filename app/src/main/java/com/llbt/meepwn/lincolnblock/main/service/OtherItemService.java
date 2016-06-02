package com.llbt.meepwn.lincolnblock.main.service;

import android.content.Context;

import com.llbt.meepwn.lincolnblock.framework.base.Service;
import com.llbt.meepwn.lincolnblock.main.data_model.OtherItemDataModel;

/**
 * package: com.llbt.meepwn.lincolnblock.main.service
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/14 下午1:30
 * desc:
 */
public class OtherItemService extends Service<OtherItemDataModel> {

    public OtherItemService(Context context) {
        super(context);
    }

    @Override
    public void pushActivityWithDataModel(OtherItemDataModel dataModel, Class clazz) {

    }

}
