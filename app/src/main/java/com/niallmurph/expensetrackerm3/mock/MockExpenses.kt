package com.niallmurph.expensetrackerm3.mock

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.Color
import com.niallmurph.expensetrackerm3.models.Category
import com.niallmurph.expensetrackerm3.models.Expense
import com.niallmurph.expensetrackerm3.models.Recurrence
import io.github.serpro69.kfaker.Faker
import java.time.LocalDate
import java.time.temporal.ChronoUnit

val faker = Faker()

val mockExpenses: MutableList<Expense> = mutableListOf()

@RequiresApi(Build.VERSION_CODES.O)
fun populateExpenses() {
    repeat(30) { index ->
        mockExpenses.add(
            Expense(
                id = index,
                amount = faker.random.nextInt(min = 1, max = 999).toDouble(),
                date = LocalDate.now().minus(
                    faker.random.nextInt(min = 300, max = 345600).toLong(),
                    ChronoUnit.SECONDS
                ),
                recurrence = faker.random.randomValue(
                    listOf(
                        Recurrence.None,
                        Recurrence.Daily,
                        Recurrence.Weekly,
                        Recurrence.Monthly,
                        Recurrence.Yearly
                    )
                ),
                note = faker.australia.animals(),
                category = faker.random.randomValue(
                    listOf(
                        Category("Groceries", Color.Green),
                        Category("Alcohol", Color.Blue),
                        Category("Entertainment", Color.Red),
                        Category("Bills", Color.Magenta)
                    )
                )
            )
        )
    }
}
