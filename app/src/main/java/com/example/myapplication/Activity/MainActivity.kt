package com.example.myapplication.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.view.WindowManager
import com.example.myapplication.ViewModel.MainViewModel
import com.example.myapplication.databinding.ActivityMainBinding
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Adapter.ExpensesListAdapter
import com.example.myapplication.R
import eightbitlab.com.blurview.RenderScriptBlur

class MainActivity : AppCompatActivity() {
    // Binding
    lateinit var binding: ActivityMainBinding
    // View Model
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        
        
        initRecyclerView()
        setBlueEffect()
        setVariable()

    }

    private fun setVariable() {
        binding.cardButton.setOnClickListener{
            // Intent
            startActivity(Intent(this,ReportActivity::class.java))
        }
    }

    private fun setBlueEffect() {
        val radius = 10f
        val decorview = this.window.decorView
        val rootView = decorview.findViewById<View>(android.R.id.content) as ViewGroup
        val windowBackGround = decorview.background
        binding.blurView.setupWith(
            rootView,
            RenderScriptBlur(this)
        )
            .setFrameClearDrawable(windowBackGround)
            .setBlurRadius(radius)

        binding.blurView.setOutlineProvider(ViewOutlineProvider.BACKGROUND)
        binding.blurView.setClipToOutline(true)
    }

    private fun initRecyclerView() {
        binding.view1.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.view1.adapter=ExpensesListAdapter(mainViewModel.loadData())
        binding.view1.isNestedScrollingEnabled=false
    }
}
