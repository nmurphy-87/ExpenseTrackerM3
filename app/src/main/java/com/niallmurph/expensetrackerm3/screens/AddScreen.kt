package com.niallmurph.expensetrackerm3.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.marosseleng.compose.material3.datetimepickers.date.ui.dialog.DatePickerDialog
import com.niallmurph.expensetrackerm3.components.TableRow
import com.niallmurph.expensetrackerm3.components.UnstyledBasicTextField
import com.niallmurph.expensetrackerm3.components.UnstyledDefaultTextField
import com.niallmurph.expensetrackerm3.models.Recurrence
import com.niallmurph.expensetrackerm3.ui.theme.BackgroundElevated
import com.niallmurph.expensetrackerm3.ui.theme.DividerColor
import com.niallmurph.expensetrackerm3.ui.theme.Primary
import com.niallmurph.expensetrackerm3.ui.theme.TopAppBarBackground
import com.niallmurph.expensetrackerm3.viewmodels.AddViewModel
import java.time.LocalDate
import java.util.Calendar

class AddScreen() {

    val route = "add"

    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
    @Composable
    fun Create(navController: NavController, addViewModel: AddViewModel = viewModel()) {

        val state by addViewModel.uiState.collectAsState()

        val recurrenceList = listOf(
            Recurrence.None,
            Recurrence.Daily,
            Recurrence.Weekly,
            Recurrence.Monthly,
            Recurrence.Yearly
        )

        val categories = listOf("Groceries", "Entertainment", "Wifi", "Electricity", "Heating")

        val mContext = LocalContext.current

        val mYear: Int
        val mMonth: Int
        val mDay: Int

        val mCalendar = Calendar.getInstance()
        mYear = mCalendar.get(Calendar.YEAR)
        mMonth = mCalendar.get(Calendar.MONTH)
        mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

        var mDate = remember {
            mutableStateOf(
                "${mCalendar.get(Calendar.MONTH) + 1}-${mCalendar.get(Calendar.DAY_OF_MONTH)}-${
                    mCalendar.get(Calendar.YEAR)
                }"
            )
        }

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
                        TableRow(label = "Amount", detailContent = {
                            UnstyledDefaultTextField(
                                value = state.amount,
                                onValueChange = addViewModel::setAmount,
                                placeholder = "0",
                                textStyle = TextStyle(
                                    textAlign = TextAlign.End
                                ),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                )
                            )
                        }
                        ) {

                        }
                        Divider(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            thickness = 1.dp,
                            color = DividerColor
                        )
                        TableRow(label = "Recurrence", detailContent = {
                            var recurrenceMenuExpanded = remember { mutableStateOf(false) }
                            TextButton(
                                onClick = { recurrenceMenuExpanded.value = true }
                            ) {
                                Text(text = state.recurrence.name)
                                DropdownMenu(
                                    expanded = recurrenceMenuExpanded.value,
                                    onDismissRequest = { recurrenceMenuExpanded.value = false }
                                ) {
                                    recurrenceList.forEach { it ->
                                        DropdownMenuItem(
                                            text = { Text(it.name) },
                                            onClick = {
                                                addViewModel.setRecurrence(it)
                                                recurrenceMenuExpanded.value = false
                                            }
                                        )
                                    }
                                }
                            }
                        }
                        ) {

                        }
                        Divider(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            thickness = 1.dp,
                            color = DividerColor
                        )
                        val datePickerShowing = remember { mutableStateOf(false) }
                        TableRow(label = "Date", detailContent = {
                            TextButton(onClick = { datePickerShowing.value = true }) {
                                Text(state.date.toString())
                            }
                            if (datePickerShowing.value) {
                                DatePickerDialog(
                                    onDismissRequest = { datePickerShowing.value = false },
                                    onDateChange = {
                                        addViewModel.setDate(it)
                                        datePickerShowing.value = false
                                    },
                                    initialDate = state.date,
                                    title = {
                                        Text(
                                            "Please select a date",
                                            style = MaterialTheme.typography.headlineMedium
                                        )
                                    }
                                )
                            }
                        }
                        ) {

                        }
                        Divider(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            thickness = 1.dp,
                            color = DividerColor
                        )
                        TableRow(label = "Note", detailContent = {
                            UnstyledDefaultTextField(
                                value = state.note,
                                onValueChange = addViewModel::setNote,
                                placeholder = "Add notes",
                                textStyle = TextStyle(
                                    textAlign = TextAlign.End
                                ),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Text
                                )
                            )
                        }
                        ) {

                        }
                        Divider(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            thickness = 1.dp,
                            color = DividerColor
                        )
                        TableRow(label = "Category", detailContent = {
                            var categoryMenuExpanded = remember { mutableStateOf(false) }
                            TextButton(
                                onClick = { categoryMenuExpanded.value = true }
                            ) {
                                Text(text = state.category ?: "Select a Category")
                                DropdownMenu(
                                    expanded = categoryMenuExpanded.value,
                                    onDismissRequest = { categoryMenuExpanded.value = false }
                                ) {
                                    categories.forEach { category ->
                                        DropdownMenuItem(
                                            text = {
                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically
                                                ) {
                                                    Surface(
                                                        modifier = Modifier
                                                            .size(12.dp)
                                                            .padding(start = 2.dp, end = 4.dp),
                                                        shape = CircleShape,
                                                        color = Primary
                                                    ) {}
                                                    Text(category)
                                                }
                                            },
                                            onClick = {
                                                addViewModel.setCategory(category)
                                                categoryMenuExpanded.value = false
                                            }
                                        )
                                    }
                                }
                            }
                        }
                        ) {

                        }
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(32.dp))
                        Button(
                            onClick = addViewModel::submitExpense,
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