package com.cirodev.boldweatherapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cirodev.boldweatherapi.domain.model.ForecastInfo
import com.cirodev.boldweatherapi.domain.usecase.GetForecastByLocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val getForecastByLocationUseCase: GetForecastByLocationUseCase
) : ViewModel() {
    private val _forecastState: MutableStateFlow<DataResult<ForecastInfo>?> =
        MutableStateFlow(value = null)
    val forecastState: MutableStateFlow<DataResult<ForecastInfo>?> get() = _forecastState

    fun getForecastByLocation(name: String) {
        viewModelScope.launch {
            getForecastByLocationUseCase.execute(name)
                .distinctUntilChanged()
                .onStart {
                    _forecastState.value = DataResult.OnLoading
                }
                .collect {
                    _forecastState.value = it.fold(
                        { failure -> DataResult.OnFailed(failure) },
                        { data -> DataResult.OnSuccess(data) }
                    )
                }
        }
    }
}