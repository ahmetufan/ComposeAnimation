package com.example.composeanimation.animations

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composeanimation.CardTitleAndDesc

@Composable
fun CircleOffsetAnimation() {
    val infiniteTransition = rememberInfiniteTransition()

    val easing = LinearOutSlowInEasing

    val color by infiniteTransition.animateColor(
        initialValue = Color(0xff2E5984),
        targetValue = Color(0xFF91BAD6),
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = easing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    val color2 by infiniteTransition.animateColor(
        initialValue = Color(0xFF91BAD6),
        targetValue = Color(0xff2E5984),
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = easing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    val offsetX by animateValues(
        values = listOf(0f, 100f, -100f, 0f),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1500, easing = easing),
            repeatMode = RepeatMode.Restart
        )
    )

    val scale by animateValues(
        values = listOf(1f, 10f, 10f, 10f, 1f),
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = easing),
            repeatMode = RepeatMode.Restart
        )
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
                    .padding(top = 16.dp)
                    .size(100.dp)

            ) {
                drawCircle(
                    color = Color.White,
                )
                drawCircle(
                    color = color2,
                    radius = 80f + scale * 4f,
                    center = Offset(-offsetX + this.center.x, this.center.y)
                )
                drawCircle(
                    color = color,
                    radius = 80f + scale * 4f,
                    center = Offset(offsetX + this.center.x, this.center.y)
                )
            }

        }

        CardTitleAndDesc(title = "Circle Offset")

    }
}

@Composable
fun animateValues(
    values: List<Float>,
    animationSpec: AnimationSpec<Float> = spring(),
): State<Float> {


    val groups by rememberUpdatedState(newValue = values.zipWithNext())
    val state = remember { mutableStateOf(values.first()) }

    LaunchedEffect(key1 = groups) {
        val (_, setValue) = state
        animate(
            initialValue = 0f,
            targetValue = groups.size.toFloat(),
            animationSpec = animationSpec,
        ) { frame, _ ->
            val integerPart = frame.toInt()
            val (initialValue, finalValue) = groups[frame.toInt()]
            val decimalPart = frame - integerPart
            setValue(
                initialValue + (finalValue - initialValue) * decimalPart
            )
        }
    }
    return state
}