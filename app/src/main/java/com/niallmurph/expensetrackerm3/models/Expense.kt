package com.niallmurph.expensetrackerm3.models

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

data class Expense(
    val id : Int,
    val amount : Double,
    val recurrence: Recurrence,
    val date : LocalDate,
    val note : String,
    val category: Category
)

data class DayExpenses(
    val expenses : MutableList<Expense>,
    val total : Double
)

@RequiresApi(Build.VERSION_CODES.O)
fun List<Expense>.groupedByDay(): Map<LocalDate, DayExpenses>{
    // create empty map
    val dataMap : MutableMap<LocalDate, DayExpenses> = mutableMapOf()
    //Loop through the list
    this.forEach { expense ->
        val date = expense.date

        if(dataMap[date] == null) {
            dataMap[date] = DayExpenses(
                expenses = mutableListOf(),
                total = 0.0
            )
        }

        dataMap[date]?.expenses?.add(expense)
        dataMap[date]?.total?.plus(expense.amount)
    }
    //Push the expense in its own day
    return dataMap
    //Return the map
}

@RequiresApi(Build.VERSION_CODES.O)
fun List<Expense>.sort(): Map<LocalDate, DayExpenses>{

    val dataMap : MutableMap<LocalDate, DayExpenses> = mutableMapOf()

    this.forEach { expense ->
        val date = expense.date

        if(dataMap[date] == null) {
            dataMap[date] = DayExpenses(
                expenses = mutableListOf(),
                total = 0.0
            )
        }

        dataMap[date]?.expenses?.add(expense)
        dataMap[date]?.total?.plus(expense.amount)
    }

    return dataMap.toSortedMap(compareByDescending { it })

}