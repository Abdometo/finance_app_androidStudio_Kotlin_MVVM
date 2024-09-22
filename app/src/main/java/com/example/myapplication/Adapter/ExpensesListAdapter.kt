package com.example.myapplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.ViewholderItemsBinding
import com.example.myapplication.domain.ExpensesDomain
import java.text.DecimalFormat

class ExpensesListAdapter(private val items:MutableList<ExpensesDomain>):
    RecyclerView.Adapter<ExpensesListAdapter.ExpensesViewHolder>() {

    // ViewHolder
    class ExpensesViewHolder(val binding:ViewholderItemsBinding): RecyclerView.ViewHolder(binding.root) {}

    private lateinit var context: Context
    var formatter:DecimalFormat?=null

    // Implement Methods
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpensesViewHolder {
         context = parent.context
        formatter= DecimalFormat("###,###,###.##")
        val binding = ViewholderItemsBinding.inflate(LayoutInflater.from(context),parent,false)
        return ExpensesViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ExpensesViewHolder, position: Int) {
        val item = items[position]

        holder.binding.titleText.text = item.title
        holder.binding.timeText.text = item.time
        holder.binding.priceText.text = "$"+formatter?.format(item.price)

        val drawableResourcesId = holder.itemView.resources.getIdentifier(item.pic,"drawable",context.packageName)

        Glide
            .with(context)
            .load(drawableResourcesId)
            .into(holder.binding.pic)

    }

    override fun getItemCount(): Int {
        return items.size
    }
}