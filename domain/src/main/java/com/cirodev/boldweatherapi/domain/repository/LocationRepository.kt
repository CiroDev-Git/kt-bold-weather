package com.cirodev.boldweatherapi.domain.repository

import com.cirodev.boldweatherapi.core.generic.Either
import com.cirodev.boldweatherapi.core.generic.Failure
import com.cirodev.boldweatherapi.domain.model.Location
import kotlinx.coroutines.flow.Flow

interface LocationRepository {
    suspend fun searchLocations(query: String): Flow<Either<Failure, List<Location>>>
}