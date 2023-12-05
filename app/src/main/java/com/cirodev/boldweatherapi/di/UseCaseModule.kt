package com.cirodev.boldweatherapi.di

import com.cirodev.boldweatherapi.domain.repository.LocationRepository
import com.cirodev.boldweatherapi.domain.usecase.SearchLocationsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun providesSearchLocationsUseCase(
        locationRepository: LocationRepository
    ): SearchLocationsUseCase {
        return SearchLocationsUseCase(locationRepository)
    }

}