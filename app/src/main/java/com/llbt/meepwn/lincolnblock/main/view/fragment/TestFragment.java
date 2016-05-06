package com.llbt.meepwn.lincolnblock.main.view.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.llbt.meepwn.lincolnblock.R;
import com.llbt.meepwn.lincolnblock.databinding.TestFragmentBinding;
import com.llbt.meepwn.lincolnblock.framework.base.BaseFragment;
import com.llbt.meepwn.lincolnblock.main.model.TestFragmentModel;
import com.llbt.meepwn.lincolnblock.main.service.TestFragmentService;
import com.llbt.meepwn.lincolnblock.main.view_model.TestFragmentViewModel;

/**
 * package: com.llbt.meepwn.lincolnblock.main.view.fragment
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/21 上午6:49
 * desc:
 */
public class TestFragment extends BaseFragment<TestFragmentModel, TestFragmentViewModel, TestFragmentService> {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TestFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.frag_test, container, false);
        TestFragmentService service = new TestFragmentService(getActivity());
        ObservableField<TestFragmentModel> model = new ObservableField<>(new TestFragmentModel());
        TestFragmentViewModel viewModel = new TestFragmentViewModel(service, model);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

}
