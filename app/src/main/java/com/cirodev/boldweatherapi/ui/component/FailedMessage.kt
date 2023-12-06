package com.cirodev.boldweatherapi.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.cirodev.boldweatherapi.R
import com.cirodev.boldweatherapi.core.generic.Failure

@Composable
fun FailedMessage(
    modifier: Modifier,
    failure: Failure?
) {
    val message = when (failure) {
        null,
        Failure.UnknownError -> stringResource(R.string.something_wrong)

        Failure.NetworkError -> stringResource(R.string.no_internet_connection)
    }
    BasicMessage(modifier, message)
}