package com.belajar.learnmvvm.network

import android.os.Build
import com.belajar.learnmvvm.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ConfigRetrofit {

    private fun logging() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC
        return OkHttpClient.Builder().addInterceptor(logging).build()
    }

    private fun retrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(logging())
            .build()
    }

    fun getService() : ApiService{
        return retrofit().create(ApiService::class.java)
    }







}