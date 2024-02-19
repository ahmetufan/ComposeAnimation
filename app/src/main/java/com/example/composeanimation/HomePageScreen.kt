package com.example.composeanimation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composeanimation.animations.ArcRotationAnimation
import com.example.composeanimation.animations.CircleOffsetAnimation
import com.example.composeanimation.animations.ClockLoading
import com.example.composeanimation.animations.HeartAnimation
import com.example.composeanimation.animations.PacmanAnimation
import com.example.composeanimation.animations.ProgressAnimation
import com.example.composeanimation.animations.RotateDotAnimation
import com.example.composeanimation.animations.RotateTwoDotsAnimation
import com.example.composeanimation.animations.RotatingCircle
import com.example.composeanimation.animations.RotatingSquare
import com.example.composeanimation.animations.SquareFillLoaderAnimation
import com.example.composeanimation.animations.StepperAnimation
import com.example.composeanimation.animations.ThreeBounceAnimation
import com.example.composeanimation.animations.TwinCircleAnimation
import com.example.composeanimation.animations.WavesAnimation
import com.example.composeanimation.ui.theme.ThemeColorSoft
import com.example.composeanimation.ui.theme.ThemeTextColor

@Composable
fun HomePageScreen(navController: NavController) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .verticalScroll(rememberScrollState())
    ) {

        WavesAnimation()

        RotatingCircle()

        ArcRotationAnimation()

        CircleOffsetAnimation()

        ClockLoading()

        HeartAnimation()

        PacmanAnimation()

        ProgressAnimation()

        RotateDotAnimation()

        RotateTwoDotsAnimation()

        StepperAnimation(modifier = Modifier.align(Alignment.CenterHorizontally))

        RotatingCircle()

        RotatingSquare()

        SquareFillLoaderAnimation()

        ThreeBounceAnimation()

        TwinCircleAnimation()

    }

}

@Composable
fun CardTitleAndDesc(
    title: String = "",
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = ThemeColorSoft
        )
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = title,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleLarge,
                color = ThemeTextColor,
                textAlign = TextAlign.Center,

            )
        }
    }
}