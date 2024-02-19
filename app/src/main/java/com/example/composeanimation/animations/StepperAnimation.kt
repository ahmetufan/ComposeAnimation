package com.example.composeanimation.animations

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeanimation.CardTitleAndDesc
import com.example.composeanimation.ui.theme.ThemeTextColor

@Composable
fun StepperAnimation(modifier: Modifier) {
    var currentNumber by remember {
        mutableStateOf(0)
    }

    var frontNumber by remember {
        mutableStateOf(currentNumber)
    }
    var backNumber by remember {
        mutableStateOf(currentNumber)
    }

    var targetAngle by remember {
        mutableStateOf(0f)
    }

    val rotation = animateFloatAsState(
        targetValue = targetAngle,
        animationSpec = tween(
            durationMillis = 400,
            easing = FastOutSlowInEasing,
        ), label = ""
    )

    fun isFront(): Boolean {
        val value = kotlin.math.abs(rotation.value % 360)
        return value < 90 || value > 270
    }

    fun flipBack() {
        currentNumber -= 1
        if (isFront()) {
            backNumber = currentNumber
        } else {
            frontNumber = currentNumber
        }
        targetAngle -= 180f
    }

    fun flipNext() {
        currentNumber += 1
        if (isFront()) {
            backNumber = currentNumber
        } else {
            frontNumber = currentNumber
        }
        targetAngle += 180f
    }

    @Composable
    fun Step(number: Int, rotationY: Float) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .graphicsLayer {
                    this.rotationY = rotationY
                }
        ) {
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .clickable {
                    flipBack()
                })

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = number.toString(), color = ThemeTextColor, fontSize = 40.sp
                )
            }

            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .clickable {
                    flipNext()
                })
        }

    }

    Column {

        Box(
            modifier = modifier
                .padding(35.dp)
                .height(80.dp)
                .width(200.dp)
                .graphicsLayer {
                    rotationY = rotation.value
                }
        ) {
            if (isFront()) {
                //Front
                Step(number = frontNumber, rotationY = 0f)
            } else {
                //Back
                Step(number = backNumber, rotationY = rotation.value)
            }
        }
        CardTitleAndDesc(title = "Stepper Animation")
    }



}
