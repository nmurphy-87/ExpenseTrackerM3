package com.niallmurph.expensetrackerm3.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun LocalDate.formatDay() : String {

    val today = LocalDate.now()
    val yesterday = today.minusDays(1)

    return when {
        this.isEqual(today) -> "Today"
        this.isEqual(yesterday) -> "Yesterday"
        this.year != today.year -> this.format(DateTimeFormatter.ofPattern("E, dd MMM yyyy"))
        else -> this.format(DateTimeFormatter.ofPattern("E, dd MMM yyyy"))
    }
}