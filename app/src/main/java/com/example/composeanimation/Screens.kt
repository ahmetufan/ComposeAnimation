package com.example.composeanimation

sealed class Screens(val route: String, vararg params: String) {
    val fullRoute: String = if (params.isEmpty()) route else {
        val builder = StringBuilder(route)
        params.forEach { builder.append("/{${it}}") }
        builder.toString()
    }


    object HomePageScreen : Screens("homePageScreen")
}