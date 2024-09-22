package com.example.myapplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ViewholderBudgetBinding
import java.text.DecimalFormat

class ReportListAdapter(private val items:MutableList<BudgetDomain>):RecyclerView.Adapter<ReportListAdapter.ReportViewHolder>() {

    // Context
    private lateinit var context: Context
    var formatter:DecimalFormat?=null


    // ViewHolder
    public class ReportViewHolder(val binding : ViewholderBudgetBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    // Implement Methods
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportViewHolder {
        context = parent.context
        formatter = DecimalFormat("###,###,###,###")
        val binding  =ViewholderBudgetBinding.inflate(LayoutInflater.from(context),parent,false)
        return ReportViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReportViewHolder, position: Int) {
        val item = items[position]

        holder.binding.titleText.text = item.title
        holder.binding.percentText.text="%"+item.percent
        holder.binding.priceText.text="$"+formatter?.format(item.price)+" /Month"

        holder.binding.circularProgressBa.apply {
            progress = item.percent.toFloat()

            if(position%2==1){
                progressBarColor=context.resources.getColor(R.color.blue)
                holder.binding.percentText.setTextColor(context.resources.getColor(R.color.blue))
            }else{
                progressBarColor=context.resources.getColor(R.color.pink)
                holder.binding.percentText.setTextColor(context.resources.getColor(R.color.pink))
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}