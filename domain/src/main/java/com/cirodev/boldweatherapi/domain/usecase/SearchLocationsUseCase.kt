package com.cirodev.boldweatherapi.domain.usecase

import com.cirodev.boldweatherapi.core.generic.Either
import com.cirodev.boldweatherapi.core.generic.Failure
import com.cirodev.boldweatherapi.core.usecase.FlowUseCase
import com.cirodev.boldweatherapi.domain.model.Location
import com.cirodev.boldweatherapi.domain.repository.LocationRepository
import kotlinx.coroutines.flow.Flow

class SearchLocationsUseCase(
    private val repository: LocationRepository
) : FlowUseCase<String, List<Location>> {
    override suspend fun execute(data: String): Flow<Either<Failure, List<Location>>> =
        repository.searchLocations(data)
}