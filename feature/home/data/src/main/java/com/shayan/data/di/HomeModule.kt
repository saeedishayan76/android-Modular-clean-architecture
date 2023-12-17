package com.shayan.data.di

import com.UserRepo
import com.shayan.data.UserRepoImpl
import com.shayan.data.remote.HomeApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): HomeApiService {
        return retrofit.create(HomeApiService::class.java)
    }

    @Provides
    fun provideHomeRepo(apiService: HomeApiService):UserRepo{
        return UserRepoImpl(apiService)
    }
}