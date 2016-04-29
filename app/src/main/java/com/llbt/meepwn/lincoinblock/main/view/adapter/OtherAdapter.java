package com.llbt.meepwn.lincoinblock.main.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.llbt.meepwn.lincoinblock.R;
import com.llbt.meepwn.lincoinblock.databinding.OtherItemBinding;
import com.llbt.meepwn.lincoinblock.main.view_model.OtherItemViewModel;

import java.util.List;

/**
 * package: com.llbt.meepwn.lincoinblock.main.view.adapter
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/29 下午3:48
 * desc:
 */
public class OtherAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater inflater;
	private List<OtherItemViewModel> dataList;

	public OtherAdapter(Context context, List<OtherItemViewModel> dataList) {
		this.context = context;
		this.inflater = LayoutInflater.from(context);
		this.dataList = dataList;
	}

	@Override
	public int getCount() {
		return dataList.size();
	}

	@Override
	public Object getItem(int position) {
		return dataList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		OtherItemBinding binding;
		if (convertView == null) {
			binding = DataBindingUtil.inflate(inflater, R.layout.other, parent, false);
			convertView = binding.getRoot();
			convertView.setTag(binding);
		} else {
			binding = (OtherItemBinding) convertView.getTag();
		}
		OtherItemViewModel viewModel = dataList.get(position);
		binding.setViewModel(viewModel);
		binding.executePendingBindings();
		return convertView;
	}

	public List<OtherItemViewModel> getDataList() {
		return dataList;
	}

	public void updateDataList(List<OtherItemViewModel> dataList) {
		this.dataList = dataList;
		notifyDataSetChanged();
	}

}
