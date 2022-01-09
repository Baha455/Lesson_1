package com.example.lesson_1.data

import Trivia_categories
import retrofit2.Call
import retrofit2.http.GET

interface CategoryApiService {

    @GET("api_category.php")
    fun getCategory(): Call<Trivia_categories>

}