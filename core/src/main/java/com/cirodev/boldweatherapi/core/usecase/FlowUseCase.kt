package com.cirodev.boldweatherapi.core.usecase

import com.cirodev.boldweatherapi.core.generic.Either
import com.cirodev.boldweatherapi.core.generic.Failure
import kotlinx.coroutines.flow.Flow

interface FlowUseCase<S, T> {
    suspend fun execute(data: S): Flow<Either<Failure, T>>
}