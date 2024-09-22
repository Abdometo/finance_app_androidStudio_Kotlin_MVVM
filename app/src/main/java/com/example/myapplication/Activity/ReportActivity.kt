package com.example.myapplication.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Adapter.ReportListAdapter
import com.example.myapplication.R
import com.example.myapplication.ViewModel.MainViewModel
import com.example.myapplication.databinding.ActivityReportBinding

class ReportActivity : AppCompatActivity() {
    // Binding
    private lateinit var binding:ActivityReportBinding
    // ViewModel
    private val mainViewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //................................................................//
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        //................................................................//

        initRecyclerView()
        setVariable()

    }

    private fun setVariable() {
        binding.backButton.setOnClickListener{
            finish()
        }
    }

    private fun initRecyclerView() {
        binding.view2.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.view2.adapter=ReportListAdapter(mainViewModel.loadBudget())
        binding.view2.isNestedScrollingEnabled = false
    }
}