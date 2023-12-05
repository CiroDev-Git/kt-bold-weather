package com.cirodev.boldweatherapi.data.repository

import android.util.Log
import com.cirodev.boldweatherapi.core.generic.Either
import com.cirodev.boldweatherapi.core.generic.Failure
import com.cirodev.boldweatherapi.data.api.API_RESULT_TAG
import com.cirodev.boldweatherapi.data.api.ApiResult
import com.cirodev.boldweatherapi.data.api.location.response.toDomainList
import com.cirodev.boldweatherapi.data.datasource.remote.LocationRemoteDataSource
import com.cirodev.boldweatherapi.domain.model.Location
import com.cirodev.boldweatherapi.domain.repository.LocationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocationRepositoryImpl(
    private val remoteDataSource: LocationRemoteDataSource
) : LocationRepository {
    override suspend fun searchLocations(
        query: String
    ): Flow<Either<Failure, List<Location>>> {
        return flow {
            emit(
                when (val response = remoteDataSource.searchLocations(query)) {
                    is ApiResult.Error -> {
                        Log.e(API_RESULT_TAG, "Error ${response.code} - ${response.message}")
                        Either.Left(Failure.NetworkError)
                    }

                    is ApiResult.Exception -> {
                        Log.e(API_RESULT_TAG, "Exception ${response.e.message}")
                        Either.Left(Failure.UnknownError)
                    }

                    is ApiResult.Success -> Either.Right(response.data.toDomainList())
                }
            )
        }
    }
}