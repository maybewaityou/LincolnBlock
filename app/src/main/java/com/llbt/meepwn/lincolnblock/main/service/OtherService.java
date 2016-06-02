package com.llbt.meepwn.lincolnblock.main.service;

import android.content.Context;

import com.llbt.meepwn.lincolnblock.framework.base.Service;
import com.llbt.meepwn.lincolnblock.main.data_model.OtherItemDataModel;

/**
 * package: com.llbt.meepwn.lincolnblock.main.service
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/20 上午10:58
 * desc:
 */
public class OtherService extends Service<OtherItemDataModel> {

    public OtherService(Context context) {
        super(context);
    }

    @Override
    public void pushActivityWithDataModel(OtherItemDataModel dataModel, Class clazz) {

    }

}
