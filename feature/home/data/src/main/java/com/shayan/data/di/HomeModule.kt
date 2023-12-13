package com.shayan.data.di

import android.net.wifi.hotspot2.pps.HomeSp
import com.HomeRepo
import com.shayan.data.HomeRepoImpl
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
    fun provideHomeRepo(apiService: HomeApiService):HomeRepo{
        return HomeRepoImpl(apiService)
    }
}