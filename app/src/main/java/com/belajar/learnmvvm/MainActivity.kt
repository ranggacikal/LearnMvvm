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

        viewModel = MainViewModel(CalculateModel())

        binding.btnCalculate.setOnClickListener{
            val height = binding.edtHeight.text.toString()
            val width = binding.edtWidth.text.toString()
            val length = binding.edtLength.text.toString()

            if (height.isBlank() || width.isBlank() || length.isBlank()){

                Toast.makeText(this@MainActivity, "Tidak boleh kosong",
                Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            viewModel.save(width.toDouble(), height.toDouble(), length.toDouble())
            binding.tvResult.text = viewModel.getVolume().toString()
        }

    }
}