package com.example.composeanimation.animations

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.example.composeanimation.CardTitleAndDesc

@Composable
fun RotatingCircle() {

    var xRotation by remember {
        mutableStateOf(0f)
    }
    var yRotation by remember {
        mutableStateOf(0f)
    }

    LaunchedEffect(key1 = Unit, block = {
        while (true) {
            animate(
                0f,
                180f,
                animationSpec = tween(800, easing = LinearOutSlowInEasing),
                block = { value, _ -> xRotation = value }
            )
            animate(
                0f,
                180f,
                animationSpec = tween(600, easing = LinearEasing),
                block = { value, _ -> yRotation = value }
            )
        }
    })

    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(35.dp),
            contentAlignment = Alignment.Center
        ) {


            Box(
                modifier = Modifier
                    .size(100.dp)
                    .graphicsLayer {
                        rotationX = xRotation
                        rotationY = yRotation
                    }
                    .background(Color.White, CircleShape)
            )

        }
        CardTitleAndDesc(title = "Rotating Circle")
    }

}