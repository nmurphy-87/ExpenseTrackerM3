package com.niallmurph.expensetrackerm3.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.niallmurph.expensetrackerm3.components.TableRow
import com.niallmurph.expensetrackerm3.components.UnstyledBasicTextField
import com.niallmurph.expensetrackerm3.components.UnstyledDefaultTextField
import com.niallmurph.expensetrackerm3.ui.theme.BackgroundElevated
import com.niallmurph.expensetrackerm3.ui.theme.DividerColor
import com.niallmurph.expensetrackerm3.ui.theme.TopAppBarBackground

class AddScreen {

    val route = "add"

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Create(navController: NavController) {
        Scaffold(
            topBar = {
                SmallTopAppBar(
                    title = { Text("Add") },
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
                        TableRow(label = "Amount") {
                            UnstyledBasicTextField(value = "Hello",
                                onValueChange = { newVal ->

                                },
                                textStyle = TextStyle(
                                    textAlign = TextAlign.End
                                ),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                )
                            )
                        }
                        Divider(startIndent = 16.dp, thickness = 1.dp, color = DividerColor)
                        TableRow(label = "Recurrence")
                        Divider(startIndent = 16.dp, thickness = 1.dp, color = DividerColor)
                        TableRow(label = "Date")
                        Divider(startIndent = 16.dp, thickness = 1.dp, color = DividerColor)
                        TableRow(label = "Note") {
                            UnstyledDefaultTextField(value = "",
                                onValueChange = { newVal ->

                                },
                                placeholder = "Add notes",
                                textStyle = TextStyle(
                                    textAlign = TextAlign.End
                                ),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Text
                                )
                            )
                        }
                        Divider(startIndent = 16.dp, thickness = 1.dp, color = DividerColor)
                        TableRow(label = "Category")
                    }
                }
            }
        )
    }
}