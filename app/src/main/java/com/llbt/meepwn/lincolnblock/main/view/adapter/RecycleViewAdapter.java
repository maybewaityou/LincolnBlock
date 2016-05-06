package com.llbt.meepwn.lincolnblock.main.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.llbt.meepwn.lincolnblock.R;
import com.llbt.meepwn.lincolnblock.databinding.ItemBinding;
import com.llbt.meepwn.lincolnblock.main.view_model.TestItemViewModel;

import java.util.List;

/**
 * package: com.llbt.meepwn.lincolnblock.main.view.adapter
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/29 下午4:20
 * desc:
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

	private List<TestItemViewModel> dataList;
	private Context context;
	private LayoutInflater inflater;

	public RecycleViewAdapter(Context context, List<TestItemViewModel> dataList) {
		this.dataList = dataList;
		this.context = context;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public RecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		ItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.item, parent, false);
		RecycleViewAdapter.ViewHolder holder = new ViewHolder(binding.getRoot());
		holder.binding = binding;
		return holder;
	}

	@Override
	public void onBindViewHolder(RecycleViewAdapter.ViewHolder holder, int position) {
		TestItemViewModel viewModel = dataList.get(position);
		holder.binding.setViewModel(viewModel);
		holder.binding.executePendingBindings();
	}

	@Override
	public int getItemCount() {
		return dataList.size();
	}

	class ViewHolder extends RecyclerView.ViewHolder {
		ItemBinding binding;

		public ViewHolder(View itemView) {
			super(itemView);
		}
	}

}
