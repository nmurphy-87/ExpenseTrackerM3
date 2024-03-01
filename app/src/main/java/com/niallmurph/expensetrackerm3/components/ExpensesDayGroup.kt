package com.niallmurph.expensetrackerm3.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.niallmurph.expensetrackerm3.models.DayExpenses
import com.niallmurph.expensetrackerm3.models.Expense
import com.niallmurph.expensetrackerm3.utils.formatDay
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ExpensesDayGroup(date: LocalDate, expenses: DayExpenses) {

    Column(
        modifier = Modifier
            .padding(vertical = 6.dp)
    ) {
        Text(
            date.formatDay(),
            style = MaterialTheme.typography.headlineMedium,
            color = Color.LightGray
        )
        Divider()
        expenses.expenses.forEach{ expense ->  
            ExpenseRow(expense = expense)
        }
        Divider()
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Total :",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.LightGray
            )
            Text(
                text = "USD ${expenses.total}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.LightGray
            )
        }
    }
}