package com.belajar.learnmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.belajar.learnmvvm.model.ResponseMovie
import com.belajar.learnmvvm.model.ResultsItem
import com.belajar.learnmvvm.network.ConfigRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {

    private val listMovie = MutableLiveData<ArrayList<ResultsItem>>()
    private val error = MutableLiveData<String>()

    fun setMovie(){
        ConfigRetrofit.getService().getMovie(BuildConfig.API_KEY)
            .enqueue(object  : Callback<ResponseMovie>{
                override fun onResponse(
                    call: Call<ResponseMovie>,
                    response: Response<ResponseMovie>
                ) {
                    if (response.isSuccessful){

                        val responseMovie = response.body()
                        val resultsItem = responseMovie?.results
                        listMovie.postValue(resultsItem as ArrayList<ResultsItem>?)
                    }
                }

                override fun onFailure(call: Call<ResponseMovie>, t: Throwable) {
                    error.postValue(t.localizedMessage)
                }

            })
    }

    fun getMovie() : LiveData<ArrayList<ResultsItem>>{
        return listMovie
    }

    fun getError() : LiveData<String>{
        return error
    }

}