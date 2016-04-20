package com.llbt.meepwn.lincoinblock.main.view_model;

import android.databinding.ObservableField;
import android.view.View;
import android.widget.AdapterView;

import com.llbt.meepwn.lincoinblock.framework.base.BaseViewModel;
import com.llbt.meepwn.lincoinblock.framework.nullable.ModelNullable;
import com.llbt.meepwn.lincoinblock.main.model.OtherItemModel;
import com.llbt.meepwn.lincoinblock.main.service.OtherItemService;
import com.llbt.meepwn.lincoinblock.main.service.OtherService;
import com.llbt.meepwn.lincoinblock.main.view.adapter.OtherAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * package: com.llbt.meepwn.lincoinblock.main.view_model
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/20 上午10:54
 * desc:
 */
public class OtherViewModel extends BaseViewModel<ModelNullable, OtherService> implements AdapterView.OnItemClickListener {

    private OtherAdapter adapter;

    public OtherViewModel(OtherService service) {
        super(service);
    }

    public OtherAdapter fetchAdapter() {
        List<OtherItemViewModel> dataList = new ArrayList<>();
        for (int i = 0; i < 20; i ++) {
            OtherItemModel otherModel = new OtherItemModel();
            otherModel.getAge().set("== age =>>> " + i);
            otherModel.getName().set("== Jake =>>> " + i);
            ObservableField<OtherItemModel> itemModel = new ObservableField<>(otherModel);
            OtherItemService itemService = new OtherItemService(service.getContext());
            OtherItemViewModel viewModel = new OtherItemViewModel(itemService, itemModel);
            dataList.add(viewModel);
        }
        adapter = new OtherAdapter(service.getContext(), dataList);
        return adapter;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        System.out.println("== adapter ===>>>>> " + adapter.getDataList().get(i).getModel().get());
    }

}
