package com.belajar.learnmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.belajar.learnmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private  lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.btnCalculate.setOnClickListener{
            val height = binding.edtHeight.text.toString()
            val width = binding.edtWidth.text.toString()
            val length = binding.edtLength.text.toString()

            if (height.isBlank() || width.isBlank() || length.isBlank()){

                Toast.makeText(this@MainActivity, "Tidak boleh kosong",
                Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            viewModel.calculate(width, height, length)

        }

        viewModel.getResult().observe(this, Observer {
            binding.tvResult.text = it.toString()
        })

    }
}