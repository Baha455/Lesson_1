package com.example.lesson_1.data

import Trivia_categories
import androidx.lifecycle.LiveData
import com.example.lesson_1.domain.Repository

class RepositoryImpl: Repository {
    override fun getCategory(): LiveData<List<Trivia_categories>> {
        TODO("Not yet implemented")
    }
}