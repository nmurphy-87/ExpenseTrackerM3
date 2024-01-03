package com.niallmurph.expensetrackerm3.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.niallmurph.expensetrackerm3.Greeting
import com.niallmurph.expensetrackerm3.ui.theme.TopAppBarBackground

class ExpensesScreen {

    val route = "expenses"

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Create(navController: NavController) {
        Scaffold(
            topBar = {
                 SmallTopAppBar(
                     title = {Text("Expenses")},
                     colors = TopAppBarDefaults.smallTopAppBarColors(
                         containerColor = TopAppBarBackground
                     )
                 )
            },
            content = { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize(),
                    Arrangement.Center,
                    Alignment.CenterHorizontally
                ) {
                    Text("Expenses Screen", fontSize = 32.sp)
                }
            }
        )


    }

}