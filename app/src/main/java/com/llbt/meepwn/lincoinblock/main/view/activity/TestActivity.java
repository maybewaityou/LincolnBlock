package com.llbt.meepwn.lincoinblock.main.view.activity;

import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.llbt.meepwn.lincoinblock.R;
import com.llbt.meepwn.lincoinblock.framework.base.BaseActivity;
import com.llbt.meepwn.lincoinblock.main.view.adapter.RecycleViewAdapter;
import com.llbt.meepwn.lincoinblock.main.model.ItemModel;
import com.llbt.meepwn.lincoinblock.main.service.ItemService;
import com.llbt.meepwn.lincoinblock.main.view_model.TestItemViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * package: com.llbt.meepwn.lincoinblock
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/5 上午11:10
 * <p/>
 * desc:
 */
public class TestActivity extends BaseActivity<ItemModel, TestItemViewModel, ItemService> {

    private List<TestItemViewModel> dataList;
    private RecycleViewAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_test);

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
        for (int i=0; i<20; i++) {
            ItemModel model = new ItemModel();
            model.getText().set("====>>>> " + i);
            ObservableField<ItemModel> itemModel = new ObservableField<>(model);
            ItemService service = new ItemService(this);
            TestItemViewModel viewModel = new TestItemViewModel(service, itemModel);
            dataList.add(viewModel);
        }
    }

    private void initTitle() {

    }

    private void setupTitle() {

    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
    }

    private void setupViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecycleViewAdapter(this, dataList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}