package com.example.composeanimation.animations

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composeanimation.CardTitleAndDesc

@Composable
fun PacmanAnimation() {
    val infiniteTransition = rememberInfiniteTransition(label = "")

    val mouthAnimation by infiniteTransition.animateFloat(
        initialValue = 360F,
        targetValue = 280F,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )

    val antiMouthAnimation by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 40F,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )

    Column {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 35.dp), contentAlignment = Alignment.Center
        ) {
            Canvas(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(100.dp)

            ) {
                drawArc(
                    color = Color.White,
                    startAngle = antiMouthAnimation,
                    sweepAngle = mouthAnimation,
                    useCenter = true,
                )

                drawCircle(
                    color = Color.Black,
                    radius = 15f,
                    center = Offset(x = this.center.x + 15f, y = this.center.y - 85f)
                )
            }

        }

        CardTitleAndDesc(title = "Pacman Animation")
    }

}