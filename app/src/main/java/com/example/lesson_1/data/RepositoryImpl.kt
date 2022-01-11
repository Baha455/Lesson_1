package com.example.lesson_1.data

import TriviaCategoriesResponse
import androidx.lifecycle.LiveData
import com.example.lesson_1.domain.Repository

class RepositoryImpl: Repository {
    override fun getCategory(): LiveData<List<TriviaCategoriesResponse>> {
        TODO("Not yet implemented")
    }
}