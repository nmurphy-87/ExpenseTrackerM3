package com.niallmurph.expensetrackerm3.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.niallmurph.expensetrackerm3.models.Expense
import com.niallmurph.expensetrackerm3.models.groupedByDay

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ExpensesList(expenses : List<Expense>){

    val groupedExpenses = expenses.groupedByDay()

    LazyColumn(){
        itemsIndexed(
            ArrayList(groupedExpenses.keys),
            key = { _, date ->
                date
            }
        ) {_ , date ->
            if(groupedExpenses[date] != null) {
                ExpensesDayGroup(date = date, expenses = groupedExpenses[date]!!)
            }
        }
    }
}