package com.niallmurph.expensetrackerm3.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.niallmurph.expensetrackerm3.models.Expense
import com.niallmurph.expensetrackerm3.models.groupedByDay

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ExpensesList(expenses : List<Expense>){

    val groupedExpenses = expenses.groupedByDay()

    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())){
        groupedExpenses.keys.forEach{ date ->
            if(groupedExpenses[date] != null) {
                ExpensesDayGroup(date = date, expenses = groupedExpenses[date]!!)
            }
        }
    }
}