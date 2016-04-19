package com.llbt.meepwn.lincoinblock.main.view.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.llbt.meepwn.lincoinblock.R
import com.llbt.meepwn.lincoinblock.databinding.ItemBinding
import com.llbt.meepwn.lincoinblock.main.view_model.ItemViewModel

/**
 * package: com.llbt.meepwn.lincoinblock
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/12 上午11:50
 * desc:
 */
class RecycleViewAdapter(private val context: Context, private val list: List<ItemViewModel>) : RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>() {
    private val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemBinding>(inflater, R.layout.item, parent, false)
        val holder = ViewHolder(binding.root)
        holder.binding = binding
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val viewModel = list[position]
        holder.binding?.viewModel = viewModel
        holder.binding?.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: ItemBinding? = null
    }

}
