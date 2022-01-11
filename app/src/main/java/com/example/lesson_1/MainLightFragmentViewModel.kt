package com.example.lesson_1

import TriviaCategoriesResponse
import androidx.lifecycle.ViewModel
import com.example.lesson_1.domain.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainLightFragmentViewModel(private val repository: Repository): ViewModel() {


    fun getCategory() {

        App.service.getCategory().enqueue(object : Callback<TriviaCategoriesResponse>{
            override fun onResponse(
                call: Call<TriviaCategoriesResponse>,
                response: Response<TriviaCategoriesResponse>
            ) {

            }

            override fun onFailure(call: Call<TriviaCategoriesResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

}