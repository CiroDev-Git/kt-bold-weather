package com.cirodev.boldweatherapi.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun IconComponent(
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
    background: Color = MaterialTheme.colorScheme.surface,
    onClick: () -> Unit = {}
) {

    Box(
        modifier = modifier
            .background(background, CircleShape)
            .size(46.dp)
            .clickable { onClick() }, contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = tint
        )
    }

}

@Composable
fun LogoComponent(
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier
) {

    Image(
        painter = painterResource(id = icon),
        contentDescription = "",
        modifier = modifier.size(size = 58.dp)
    )

}