package com.cirodev.boldweatherapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cirodev.boldweatherapi.domain.model.Location
import com.cirodev.boldweatherapi.domain.usecase.SearchLocationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val searchLocationsUseCase: SearchLocationsUseCase
) : ViewModel() {
    private val _locationsState: MutableStateFlow<DataResult<List<Location>>?> =
        MutableStateFlow(value = null)
    val locationsState: MutableStateFlow<DataResult<List<Location>>?> get() = _locationsState

    init {
        searchLocations("California")
    }

    fun searchLocations(query: String) {
        if (query.isEmpty()) {
            _locationsState.value = null
            return
        }
        viewModelScope.launch {
            searchLocationsUseCase.execute(query)
                .distinctUntilChanged()
                .onStart {
                    _locationsState.value = DataResult.OnLoading
                }
                .collect {
                    _locationsState.value = it.fold(
                        { failure -> DataResult.OnFailed(failure) },
                        { data -> DataResult.OnSuccess(data) }
                    )
                }
        }
    }
}