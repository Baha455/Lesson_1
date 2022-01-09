package com.example.lesson_1

import android.app.Application
import com.example.lesson_1.data.CategoryApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App: Application() {

    companion object{
        lateinit var service: CategoryApiService
    }

    override fun onCreate() {
        super.onCreate()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://opentdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(CategoryApiService::class.java)
    }
}