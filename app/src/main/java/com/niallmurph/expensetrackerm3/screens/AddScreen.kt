package com.niallmurph.expensetrackerm3.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.niallmurph.expensetrackerm3.Greeting

class AddScreen {

    val route = "add"

    @Composable
    fun Create(navController: NavController){
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ){
            Greeting(name = "Expenses")
        }
    }
}