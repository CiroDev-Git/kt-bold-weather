package com.cirodev.boldweatherapi.di

import com.cirodev.boldweatherapi.data.api.location.request.LocationApi
import com.cirodev.boldweatherapi.data.datasource.remote.LocationRemoteDataSource
import com.cirodev.boldweatherapi.data.datasource.remote.LocationRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Singleton
    @Provides
    fun provideLocationRemoteDataSource(locationApi: LocationApi): LocationRemoteDataSource =
        LocationRemoteDataSourceImpl(locationApi)

}