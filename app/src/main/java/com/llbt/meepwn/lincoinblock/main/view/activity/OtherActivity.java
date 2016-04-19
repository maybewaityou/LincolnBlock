package com.llbt.meepwn.lincoinblock.main.view.activity;

import android.databinding.ObservableField;
import android.os.Bundle;
import android.widget.ListView;

import com.llbt.meepwn.lincoinblock.main.view.adapter.OtherAdapter;
import com.llbt.meepwn.lincoinblock.R;
import com.llbt.meepwn.lincoinblock.framework.base.BaseActivity;
import com.llbt.meepwn.lincoinblock.main.model.OtherModel;
import com.llbt.meepwn.lincoinblock.main.service.OtherService;
import com.llbt.meepwn.lincoinblock.main.view_model.OtherViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * package: com.llbt.meepwn.lincoinblock
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/6 下午4:56
 * <p>
 * desc:
 */
public class OtherActivity extends BaseActivity<OtherModel, OtherViewModel, OtherService> {

    private List<OtherViewModel> dataList;
    private OtherAdapter adapter;
    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_other);

        initialize();
    }

    private void initialize() {
        initData();
        initTitle();
        setupTitle();
        initViews();
        setupViews();
    }

    private void initData() {
        dataList = new ArrayList<>();
        for (int i = 0; i < 20; i ++) {
            OtherModel otherModel = new OtherModel();
            otherModel.getAge().set("== age =>>> " + i);
            otherModel.getName().set("== Jake =>>> " + i);
            ObservableField<OtherModel> itemModel = new ObservableField<>(otherModel);
            OtherService service = new OtherService(this);
            OtherViewModel viewModel = new OtherViewModel(service, itemModel);
            dataList.add(viewModel);
        }
        adapter = new OtherAdapter(this, dataList);
    }

    private void initTitle() {

    }

    private void setupTitle() {

    }

    private void initViews() {
        listView = (ListView) findViewById(R.id.listView);
    }

    private void setupViews() {
        listView.setAdapter(adapter);
    }

}