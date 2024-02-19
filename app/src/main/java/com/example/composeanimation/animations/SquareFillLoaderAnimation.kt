package com.example.composeanimation.animations

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import com.example.composeanimation.CardTitleAndDesc

@Composable
fun SquareFillLoaderAnimation() {

    val infiniteTransition = rememberInfiniteTransition()

    var rotation by remember {
        mutableStateOf(0f)
    }
    var height by remember {
        mutableStateOf(0f)
    }

    LaunchedEffect(key1 = Unit, block = {
        while (true) {
            animate(
                0f,
                180f,
                animationSpec = tween(500, easing = LinearEasing),
                block = { value, _ -> rotation = value }
            )
            animate(
                400f, 0f,
                animationSpec = tween(1000, easing = LinearEasing),
                block = { value, _ -> height = value }
            )
        }
    })


    Column {


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(120.dp),
            contentAlignment = Alignment.Center
        ) {

            Canvas(modifier = Modifier.wrapContentSize()) {
                val topLeft = Offset(this.center.x - 200f, this.center.y - 200f)
                rotate(degrees = rotation) {
                    drawRect(
                        Color.White, topLeft, size = Size(400f, 400f),
                        style = Stroke(width = 20f)
                    )
                }

                drawRect(
                    Color.White, topLeft, size = Size(400f, height)
                )

            }
        }
        CardTitleAndDesc(title = "Square Fill Loader")
    }

}