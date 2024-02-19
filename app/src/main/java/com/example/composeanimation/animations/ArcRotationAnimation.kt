package com.example.composeanimation.animations

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.example.composeanimation.CardTitleAndDesc

@Composable
fun ArcRotationAnimation() {
    val infiniteTransition = rememberInfiniteTransition()


    val circleColor = Color(0xFFAFE1AF)
    val arcColor = Color(0XFFFFFFFF)
    val arcAngle1 by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 180F,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )

    val arcAngle2 by infiniteTransition.animateFloat(
        initialValue = 180F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )

    val greenCircleAnimation by infiniteTransition.animateFloat(
        initialValue = 50f,
        targetValue = 80f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, delayMillis = 100, easing = FastOutLinearInEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(35.dp),
            contentAlignment = Alignment.Center
        ) {
            Canvas(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp)
            ) {
                drawArc(
                    color = arcColor,
                    startAngle = arcAngle1,
                    sweepAngle = 90f,
                    useCenter = false,
                    style = Stroke(width = 10f, cap = StrokeCap.Round),
                )

                drawArc(
                    color = arcColor,
                    startAngle = arcAngle2,
                    sweepAngle = 90f,
                    useCenter = false,
                    style = Stroke(width = 10f, cap = StrokeCap.Round),
                )

                drawCircle(
                    color = arcColor,
                    radius = 120f,
                )

                drawCircle(
                    color = circleColor,
                    radius = greenCircleAnimation,
                )
            }
        }

        CardTitleAndDesc(title = "Arc Rotation")
    }

}