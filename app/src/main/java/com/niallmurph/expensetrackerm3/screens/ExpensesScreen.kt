package com.niallmurph.expensetrackerm3.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.niallmurph.expensetrackerm3.models.Recurrence
import com.niallmurph.expensetrackerm3.ui.theme.TopAppBarBackground
import com.niallmurph.expensetrackerm3.viewmodels.ExpensesViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class ExpensesScreen {

    val route = "expenses"

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Create(navController: NavController, viewModel: ExpensesViewModel = viewModel()) {

        val state by viewModel.uiState.collectAsState()

        val recurrenceList = listOf(
            Recurrence.None,
            Recurrence.Daily,
            Recurrence.Weekly,
            Recurrence.Monthly,
            Recurrence.Yearly
        )

        val recurrenceMenuExpanded = remember { mutableStateOf(false) }

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
                        .fillMaxSize()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text("Total For:", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
                        TextButton(
                            onClick = { recurrenceMenuExpanded.value = true }
                        ) {
                            Text(text = state.recurrence.target, style = MaterialTheme.typography.bodyLarge)
                            DropdownMenu(
                                expanded = recurrenceMenuExpanded.value,
                                onDismissRequest = { recurrenceMenuExpanded.value = false }
                            ) {
                                recurrenceList.forEach { it ->
                                    DropdownMenuItem(
                                        text = { Text(it.target) },
                                        onClick = {
                                            viewModel.setRecurrence(it)
                                            recurrenceMenuExpanded.value = false
                                        }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        )


    }

    @Preview(uiMode = UI_MODE_NIGHT_YES)
    @Composable
    fun PreviewExpensesScreen(){
        Create(navController = rememberNavController())
    }

}