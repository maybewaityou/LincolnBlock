package com.llbt.meepwn.lincolnblock.main.view.activity;

import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.llbt.meepwn.lincolnblock.R;
import com.llbt.meepwn.lincolnblock.framework.base.BaseActivity;
import com.llbt.meepwn.lincolnblock.main.model.TestItemModel;
import com.llbt.meepwn.lincolnblock.main.service.TestItemService;
import com.llbt.meepwn.lincolnblock.main.view.adapter.RecycleViewAdapter;
import com.llbt.meepwn.lincolnblock.main.view_model.TestItemViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * package: com.llbt.meepwn.lincolnblock
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/5 上午11:10
 * <p/>
 * desc:
 */
public class TestActivity extends BaseActivity<TestItemModel, TestItemViewModel, TestItemService> {

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
            TestItemModel model = new TestItemModel();
            model.getText().set("====>>>> " + i);
            ObservableField<TestItemModel> itemModel = new ObservableField<>(model);
            TestItemService service = new TestItemService(this);
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