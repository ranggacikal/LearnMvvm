package com.belajar.learnmvvm.network

import com.belajar.learnmvvm.model.ResponseMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/now_playing")
    fun getMovie (@Query("api_key") apiKey: String) : Call<ResponseMovie>

}