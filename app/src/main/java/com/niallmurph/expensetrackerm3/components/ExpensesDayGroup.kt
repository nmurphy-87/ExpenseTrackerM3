package com.niallmurph.expensetrackerm3.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.niallmurph.expensetrackerm3.models.DayExpenses
import com.niallmurph.expensetrackerm3.utils.formatDay
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ExpensesDayGroup(date : LocalDate, expenses : DayExpenses){

    Column() {
        Text(date.formatDay())
    }
}