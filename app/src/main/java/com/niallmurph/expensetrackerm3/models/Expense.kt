package com.niallmurph.expensetrackerm3.models

import java.time.LocalDate

data class Expense(
    val id : Int,
    val amount : Double,
    val recurrence: Recurrence,
    val date : LocalDate,
    val note : String,
    val category: Category
)
