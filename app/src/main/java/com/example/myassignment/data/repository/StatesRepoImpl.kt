package com.example.myassignment.data.repository

import com.example.myassignment.data.common.toDomain
import com.example.myassignment.data.network.ApiService
import com.example.myassignment.domain.model.Countries
import com.example.myassignment.domain.repository.StatesRepository

class StatesRepoImpl(private val apiService: ApiService) : StatesRepository {

    override suspend fun getStates(): Countries {
        return apiService.getStates().toDomain()
    }

}