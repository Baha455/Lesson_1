package com.example.lesson_1.domain

import TriviaCategoriesResponse
import androidx.lifecycle.LiveData

interface Repository {

    fun getCategory(): LiveData<List<TriviaCategoriesResponse>>
}