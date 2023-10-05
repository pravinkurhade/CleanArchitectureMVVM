package com.example.myassignment.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myassignment.R
import com.example.myassignment.databinding.ActivityMainBinding
import com.example.myassignment.domain.model.Data
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()
    lateinit var binding: ActivityMainBinding
    var list = ArrayList<Data>()
    private val adaptor = StatesAdaptor(list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater).also {
            binding = it
            setContentView(it.root)
        }
        binding.lifecycleOwner = this
        setSupportActionBar(binding.toolbar)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.list.collect {
                    if (it.isLoading) {
                        Log.d("Main", "loading")
                    }
                    if (it.error?.isNotBlank() == true) {
                        Log.d("Main", "error")
                    }
                    if (!it.data?.data.isNullOrEmpty()) {
                        Log.d("Main", it.data?.data.toString())
                        list.addAll(it.data?.data!!)
                        setView()
                    }
                }
            }
        }
    }

    private fun setView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adaptor
    }
}