package com.belajar.learnmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var result = MutableLiveData<Int>()

    fun calculate(width: String, height: String, length: String){

        val calculate = width.toInt() * height.toInt() * length.toInt()
        result.postValue(calculate)

    }

    fun getResult() : LiveData<Int>{
        return result
    }

}