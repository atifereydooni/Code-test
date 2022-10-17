package com.umain.home.di

import com.umain.home.data.RestaurantRepositoryImpl
import com.umain.home.data.remote.RestaurantApiService
import com.umain.home.data.remote.RestaurantRemoteDatasource
import com.umain.home.data.remote.RestaurantRemoteDatasourceImpl
import com.umain.home.domain.repo.RestaurantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RestaurantModule {

    @Singleton
    @Provides
    fun provideRestaurantRepository(
        remote: RestaurantRemoteDatasource
    ): RestaurantRepository {
        return RestaurantRepositoryImpl(remote = remote)
    }

    @Singleton
    @Provides
    fun providesRestaurantRemoteData(@NormalRetrofitClient retrofit: Retrofit): RestaurantRemoteDatasource {
        return RestaurantRemoteDatasourceImpl(api = retrofit.create(RestaurantApiService::class.java))
    }

}
