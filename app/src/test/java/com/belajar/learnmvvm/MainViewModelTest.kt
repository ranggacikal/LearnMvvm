package com.belajar.learnmvvm

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito.mock

class MainViewModelTest {

    lateinit var mainViewModel: MainViewModel
    lateinit var calculateModel: CalculateModel

    private val expectedVolume = 6.0

    private val width = 1.0
    private val height = 2.0
    private val length = 3.0

    @Before
    fun before(){
        calculateModel = mock(CalculateModel::class.java)
        mainViewModel = MainViewModel(calculateModel)
    }

    @Test
    fun calculate(){
        calculateModel = CalculateModel()
        mainViewModel = MainViewModel(calculateModel)
        mainViewModel.save(length, width, height)
        val volume =  mainViewModel.getVolume()
        assertEquals(expectedVolume, volume, 0.0001)
    }
}