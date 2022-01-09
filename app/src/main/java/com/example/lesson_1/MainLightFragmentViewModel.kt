package com.example.lesson_1

import Trivia_categories
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lesson_1.domain.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainLightFragmentViewModel(private val repository: Repository): ViewModel() {

    val listCategory = MutableLiveData<List<Trivia_categories>>()

    fun getCategory() {

        App.service.getCategory().enqueue(object : Callback<Trivia_categories>{
            override fun onResponse(
                call: Call<Trivia_categories>,
                response: Response<Trivia_categories>
            ) {

            }

            override fun onFailure(call: Call<Trivia_categories>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

}