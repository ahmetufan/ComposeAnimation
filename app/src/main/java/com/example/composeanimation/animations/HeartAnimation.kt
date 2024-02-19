package com.example.composeanimation.animations

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.composeanimation.CardTitleAndDesc

@Composable
fun HeartAnimation() {

    val infiniteTransition = rememberInfiniteTransition(label = "")
    val dy by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    val travelDistance = with(LocalDensity.current) { 30.dp.toPx() }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .width(200.dp)
            .padding(top = 35.dp, bottom = 35.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Filled.Favorite,
            "",
            tint = Color.White,
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally)
                .graphicsLayer {
                    translationY = dy * travelDistance
                },
        )

        Spacer(modifier = Modifier.height(30.dp))

        Box(
            modifier = Modifier
                .width(40.dp)
                .height(10.dp)
                .align(Alignment.CenterHorizontally)
                .graphicsLayer {
                    scaleX = 0.5f + dy / 2
                    alpha = 0.3f + dy / 2
                }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White, shape = CircleShape)
            )
        }

        Spacer(modifier = Modifier.height(35.dp))
        CardTitleAndDesc(title = "Heart Animation")
    }

}