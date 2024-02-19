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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.unit.dp
import com.example.composeanimation.CardTitleAndDesc
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun RotateTwoDotsAnimation() {
    val infiniteTransition = rememberInfiniteTransition(label = "")

    val animValue by infiniteTransition.animateFloat(
        initialValue = .2f,
        targetValue = .8f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    val animValue2 by infiniteTransition.animateFloat(
        initialValue = .2f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )
    val rotation by infiniteTransition.animateFloat(
        initialValue = 360F,
        targetValue = 0F,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    Column {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(90.dp),
            contentAlignment = Alignment.Center
        ) {

            Canvas(modifier = Modifier) {
                withTransform({
                    scale(animValue)
                }, {
                    drawCircle(
                        Color.White, center = center,
                        alpha = animValue,
                        radius = 50f
                    )

                })

                val x = (center.x + cos(Math.toRadians(rotation.toDouble())) * 140f).toFloat()
                val y = (center.y + sin(Math.toRadians(rotation.toDouble())) * 140f).toFloat()

                withTransform({
                    scale(animValue2)
                }, {
                    drawCircle(
                        Color.White, alpha = animValue2, center = Offset(x, y),
                        radius = 50f
                    )
                })
            }
        }

        CardTitleAndDesc(title = "Rotate Two Dots")
    }


}