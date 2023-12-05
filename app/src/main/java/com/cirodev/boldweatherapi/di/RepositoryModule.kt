package com.cirodev.boldweatherapi.di

import com.cirodev.boldweatherapi.data.datasource.remote.LocationRemoteDataSource
import com.cirodev.boldweatherapi.data.repository.LocationRepositoryImpl
import com.cirodev.boldweatherapi.domain.repository.LocationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideLocationRepository(
        locationRemoteDataSource: LocationRemoteDataSource
    ): LocationRepository =
        LocationRepositoryImpl(locationRemoteDataSource)

}