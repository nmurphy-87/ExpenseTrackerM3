package com.niallmurph.expensetrackerm3.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.niallmurph.expensetrackerm3.Greeting
import com.niallmurph.expensetrackerm3.components.TableRow
import com.niallmurph.expensetrackerm3.ui.theme.BackgroundElevated
import com.niallmurph.expensetrackerm3.ui.theme.TopAppBarBackground

class SettingsScreen {

    val route = "settings"

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Create(navController: NavController){
        Scaffold(
            topBar = {
                SmallTopAppBar(
                    title = { Text("Settings") },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = TopAppBarBackground
                    )
                )
            },
            content = { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                ) {
                    Column(modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(6.dp))
                        .background(BackgroundElevated)
                        ){
                        TableRow(label = "Categories", hasArrow = true)
                        TableRow(label = "Delete All Data", isDestructive = true)
                    }
                }
            }
        )
    }
}