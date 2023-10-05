package com.example.myassignment.domain.repository

import com.example.myassignment.domain.model.Countries

interface StatesRepository {
    suspend fun getStates() : Countries
}