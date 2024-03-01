package com.niallmurph.expensetrackerm3.models

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.LocalDateTime

data class Expense(
    val id : Int,
    val amount : Double,
    val recurrence: Recurrence,
    val date : LocalDateTime,
    val note : String?,
    val category: Category
)

data class DayExpenses(
    val expenses : MutableList<Expense>,
    var total : Double
)

//@RequiresApi(Build.VERSION_CODES.O)
//fun List<Expense>.groupedByDay(): Map<LocalDate, DayExpenses>{
//
//    var dataMap : MutableMap<LocalDate, DayExpenses> = mutableMapOf()
//
//    this.forEach { expense ->
//        val date = expense.date
//
//        if(dataMap[date] == null) {
//            dataMap[date] = DayExpenses(
//                expenses = mutableListOf(),
//                total = 0.0
//            )
//        }
//
//        dataMap[date]!!.expenses.add(expense)
//        dataMap[date]!!.total = dataMap[date]!!.total!!.plus(expense.amount)
//    }
//
//    dataMap.values.forEach { expenses ->
//        expenses.expenses.sortBy { expense -> expense.date }
//    }
//
//    return dataMap.toSortedMap(compareByDescending { it })
//}

@RequiresApi(Build.VERSION_CODES.O)
fun List<Expense>.groupedByDay(): Map<LocalDate, DayExpenses>{

    var dataMap : MutableMap<LocalDate, DayExpenses> = mutableMapOf()

    this.forEach { expense ->
        val date = expense.date.toLocalDate()

        if(dataMap[date] == null) {
            dataMap[date] = DayExpenses(
                expenses = mutableListOf(),
                total = 0.0
            )
        }

        dataMap[date]!!.expenses.add(expense)
        dataMap[date]!!.total = dataMap[date]!!.total!!.plus(expense.amount)
    }

    dataMap.values.forEach { expenses ->
        expenses.expenses.sortBy { expense -> expense.date }
    }

    return dataMap.toSortedMap(compareByDescending { it })

}