package com.example.composeanimation.animations

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composeanimation.CardTitleAndDesc
import com.example.composeanimation.ui.theme.ThemeColorSoft
import com.example.composeanimation.ui.theme.ThemeTextColor

@Composable
fun TwinCircleAnimation() {
    val infiniteTransition = rememberInfiniteTransition(label = "")

    val twinCircleAnimation by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 7f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = FastOutSlowInEasing),
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
            Row(
                modifier = Modifier
                    .size(120.dp)
                    .padding(12.dp)
                    .clip(CircleShape)
                    .background(ThemeTextColor),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(15.dp)
                        .scale(twinCircleAnimation)
                        .clip(CircleShape)
                        .background(Color.White)
                )

                Spacer(modifier = Modifier.width(6.dp))

                Box(
                    modifier = Modifier
                        .size(15.dp)
                        .scale(twinCircleAnimation)
                        .clip(CircleShape)
                        .background(Color.White)
                )
            }
        }
        CardTitleAndDesc(title = "Twin Circle")
    }

}