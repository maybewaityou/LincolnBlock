package com.llbt.meepwn.lincoinblock.main.view_model;

import android.databinding.ObservableField;
import android.view.View;

import com.llbt.meepwn.lincoinblock.framework.base.BaseViewModel;
import com.llbt.meepwn.lincoinblock.main.model.OtherItemModel;
import com.llbt.meepwn.lincoinblock.main.service.OtherItemService;

/**
 * package: com.llbt.meepwn.lincoinblock.main.view_model
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/14 下午1:32
 * desc:
 */
public class OtherItemViewModel extends BaseViewModel<OtherItemModel, OtherItemService> {

    public OtherItemViewModel(OtherItemService service, ObservableField<OtherItemModel> model) {
        super(service, model);
    }

    public void handleClick(View view) {
        System.out.println("=====>>>>> " + model.get());
    }

}
