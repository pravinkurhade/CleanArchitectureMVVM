package com.example.myassignment.data.network

import com.example.myassignment.data.model.CountriesDTO
import retrofit2.http.GET

interface ApiService {

    @GET("States/240")
    suspend fun getStates() : CountriesDTO
}