package com.ergea.learnmvvmapp.ui.home

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ergea.learnmvvmapp.adapter.HomeAdapter
import com.ergea.learnmvvmapp.databinding.ActivityMainBinding
import com.ergea.learnmvvmapp.model.Word

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val application = requireNotNull(this).application
        val factory = MainViewModelFactory()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.button.setOnClickListener { addData() }

        initialiseAdapter()
    }

    private fun initialiseAdapter() {
        binding.recycler.layoutManager = LinearLayoutManager(this)
        observeData()
    }

    private fun observeData() {
        viewModel.list.observe(this, Observer {
            binding.recycler.adapter = HomeAdapter(viewModel, it)
        })
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun addData() {
        val title = binding.titletxt.text.toString()
        if (title.isBlank()) {
            Toast.makeText(this, "Enter value!", Toast.LENGTH_LONG).show()
        } else {
            val word = Word(title)
            viewModel.add(word)
            binding.titletxt.text.clear()
            binding.recycler.adapter?.notifyDataSetChanged()
        }

    }
}