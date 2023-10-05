package com.example.myassignment.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myassignment.R
import com.example.myassignment.databinding.ItemRowBinding
import com.example.myassignment.domain.model.Data

class StatesAdaptor(private val items: List<Data>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: ItemRowBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_row, parent, false)
        return MyStateListHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MyStateListHolder) {
            val data = items[position]
            holder.bind(data)
        }
    }

    inner class MyStateListHolder(private var itemRowBinding: ItemRowBinding) :
        RecyclerView.ViewHolder(itemRowBinding.root) {
        fun bind(response: Data) {
            this.itemRowBinding.state = response
        }
    }

}