package com.llbt.meepwn.lincoinblock.main.view.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.llbt.meepwn.lincoinblock.R
import com.llbt.meepwn.lincoinblock.databinding.OtherItemBinding
import com.llbt.meepwn.lincoinblock.main.view_model.OtherItemViewModel

/**
 * package: com.llbt.meepwn.lincoinblock
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/6 下午5:06
 * desc:
 */
class OtherAdapter(context: Context, private var dataList: List<OtherItemViewModel>) : BaseAdapter() {
    private val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return dataList.size
    }

    override fun getItem(position: Int): Any {
        return dataList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @Suppress("NAME_SHADOWING")
    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup): View {
        var convertView = convertView
        val binding: OtherItemBinding
        if (convertView == null) {
            binding = DataBindingUtil.inflate<OtherItemBinding>(inflater, R.layout.other, viewGroup, false)
            convertView = binding.root
            convertView!!.tag = binding
        } else {
            binding = convertView.tag as OtherItemBinding
        }
        val viewModel = dataList[position]
        binding.viewModel= viewModel
        binding.executePendingBindings()

        return convertView
    }

    fun getDataList() : List<OtherItemViewModel>{
        return dataList
    }

    fun updateWithDataList(dataList: List<OtherItemViewModel>) {
        this.dataList = dataList
        notifyDataSetChanged()
    }

}
