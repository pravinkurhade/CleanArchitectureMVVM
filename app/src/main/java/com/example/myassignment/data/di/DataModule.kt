package com.example.myassignment.data.di

import com.example.myassignment.data.network.ApiService
import com.example.myassignment.data.repository.StatesRepoImpl
import com.example.myassignment.domain.repository.StatesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder().baseUrl("https://devtracsapi.azurewebsites.net/api/v1/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideStatesRepo(apiService: ApiService): StatesRepository {
        return StatesRepoImpl(apiService)
    }
}