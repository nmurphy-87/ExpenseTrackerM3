package com.niallmurph.expensetrackerm3.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
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

        val recurrenceList = listOf("None", "Daily", "Weekly", "Monthly", "Annually")
        val selectedRecurrence = remember { mutableStateOf("None") }

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
                            UnstyledBasicTextField(
                                value = "Hello",
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
                        TableRow(label = "Recurrence") {
                            var recurrenceMenuExpanded = remember { mutableStateOf(false) }
                            TextButton(
                                onClick = { recurrenceMenuExpanded.value = true }
                            ) {
                                Text(text = selectedRecurrence.value)
                                DropdownMenu(
                                    expanded = recurrenceMenuExpanded.value,
                                    onDismissRequest = { recurrenceMenuExpanded.value = false }
                                ) {
                                    recurrenceList.forEach { it ->
                                        DropdownMenuItem(
                                            text = { Text(it) },
                                            onClick = {
                                                selectedRecurrence.value = it
                                                recurrenceMenuExpanded.value = false
                                            }
                                        )
                                    }
                                }
                            }
                        }
                        Divider(startIndent = 16.dp, thickness = 1.dp, color = DividerColor)
                        TableRow(label = "Date")
                        Divider(startIndent = 16.dp, thickness = 1.dp, color = DividerColor)
                        TableRow(label = "Note") {
                            UnstyledDefaultTextField(
                                value = "",
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
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(32.dp))
                        Button(
                            onClick = { /*TODO*/ },
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text("Submit Expense")
                        }
                    }
                }
            }
        )
    }
}