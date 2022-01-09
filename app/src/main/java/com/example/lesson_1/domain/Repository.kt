package com.example.lesson_1.domain

import Trivia_categories
import androidx.lifecycle.LiveData

interface Repository {

    fun getCategory(): LiveData<List<Trivia_categories>>
}