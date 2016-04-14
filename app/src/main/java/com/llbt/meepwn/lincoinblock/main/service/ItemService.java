package com.llbt.meepwn.lincoinblock.main.service;

import android.content.Context;

import com.llbt.meepwn.lincoinblock.framework.base.BaseService;
import com.llbt.meepwn.lincoinblock.main.data_model.ItemDataModel;

/**
 * package: com.llbt.meepwn.lincoinblock.main.service
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/14 下午1:10
 * desc:
 */
public class ItemService extends BaseService<ItemDataModel> {

    public ItemService(Context context) {
        super(context);
    }

    @Override
    protected void pushActivityWithDataModel(ItemDataModel dataModel, Class clazz) {

    }
}
