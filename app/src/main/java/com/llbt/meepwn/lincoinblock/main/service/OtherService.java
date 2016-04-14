package com.llbt.meepwn.lincoinblock.main.service;

import android.content.Context;

import com.llbt.meepwn.lincoinblock.framework.base.BaseService;
import com.llbt.meepwn.lincoinblock.main.data_model.OtherDataModel;

/**
 * package: com.llbt.meepwn.lincoinblock.main.service
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/14 下午1:30
 * desc:
 */
public class OtherService extends BaseService<OtherDataModel> {

    public OtherService(Context context) {
        super(context);
    }

    @Override
    protected void pushActivityWithDataModel(OtherDataModel dataModel, Class clazz) {

    }

}
