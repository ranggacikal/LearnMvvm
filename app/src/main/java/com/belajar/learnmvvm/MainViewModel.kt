package com.belajar.learnmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private val calculateModel: CalculateModel) : ViewModel() {

    fun save(l: Double, w: Double, h: Double) {
        calculateModel.save(l, w, h)
    }

    fun getVolume(): Double = calculateModel.getVolume()

}