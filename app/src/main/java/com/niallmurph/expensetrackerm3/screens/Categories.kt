package com.niallmurph.expensetrackerm3.screens

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.niallmurph.expensetrackerm3.components.TableRow
import com.niallmurph.expensetrackerm3.ui.theme.BackgroundElevated
import com.niallmurph.expensetrackerm3.ui.theme.DividerColor
import com.niallmurph.expensetrackerm3.ui.theme.TopAppBarBackground

class Categories() {

    @Composable
    fun Create(navController: NavController) {
        CategoriesScreen(navController = navController)
    }

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    private fun CategoriesScreen(navController: NavController) {
        Scaffold(
            topBar = {
                SmallTopAppBar(
                    title = { Text("Categories") },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "Back Button"
                            )
                        }
                    },
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
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(6.dp))
                            .background(BackgroundElevated)
                    ) {
                        TableRow(
                            label = "Categories",
                            modifier = Modifier.clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = LocalIndication.current
                            ) {
                                navController.navigate("settings/categories")
                            },
                            hasArrow = true
                        )
                        Divider(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            thickness = 1.dp,
                            color = DividerColor
                        )
                        TableRow(label = "Delete All Data", isDestructive = true)
                    }
                }
            }
        )
    }
}