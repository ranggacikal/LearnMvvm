package com.belajar.learnmvvm

class CalculateModel {

    private var length: Double = 0.0
    private var width: Double = 0.0
    private var height: Double = 0.0

    fun save(length: Double, width: Double, height: Double) {
        this.length = length
        this.width = width
        this.height = height
    }

    fun getVolume(): Double = length * width * height

}