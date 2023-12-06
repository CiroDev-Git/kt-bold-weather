package com.cirodev.boldweatherapi.domain.usecase

import com.cirodev.boldweatherapi.core.generic.Either
import com.cirodev.boldweatherapi.core.generic.Failure
import com.cirodev.boldweatherapi.core.usecase.FlowUseCase
import com.cirodev.boldweatherapi.domain.model.ForecastInfo
import com.cirodev.boldweatherapi.domain.repository.LocationRepository
import kotlinx.coroutines.flow.Flow

class GetForecastByLocationUseCase(
    private val repository: LocationRepository
) : FlowUseCase<String, ForecastInfo> {
    override suspend fun execute(data: String): Flow<Either<Failure, ForecastInfo>> =
        repository.getForecastByLocation(data)
}