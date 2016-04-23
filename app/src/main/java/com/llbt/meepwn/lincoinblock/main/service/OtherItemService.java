package com.llbt.meepwn.lincoinblock.main.service;

import android.content.Context;

import com.llbt.meepwn.lincoinblock.framework.base.BaseService;
import com.llbt.meepwn.lincoinblock.main.data_model.OtherItemDataModel;

/**
 * package: com.llbt.meepwn.lincoinblock.main.service
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/14 下午1:30
 * desc:
 */
public class OtherItemService extends BaseService<OtherItemDataModel> {

    public OtherItemService(Context context) {
        super(context);
    }

    @Override
    public void pushActivityWithDataModel(OtherItemDataModel dataModel, Class clazz) {

    }

}
