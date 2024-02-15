package com.niallmurph.expensetrackerm3.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.niallmurph.expensetrackerm3.models.Recurrence
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate

data class AddScreenState(
    val amount: Double,
    val recurrence: Recurrence,
    val date: LocalDate,
    val note: String? = null,
    val category: String? = null
)

class AddViewModel : ViewModel() {

    @RequiresApi(Build.VERSION_CODES.O)
    private val _uiState = MutableStateFlow(
        AddScreenState(
            amount = 0.0,
            recurrence = Recurrence.None,
            date = LocalDate.now(),
        )
    )

    @RequiresApi(Build.VERSION_CODES.O)
    val uiState: StateFlow<AddScreenState> = _uiState.asStateFlow()

    @RequiresApi(Build.VERSION_CODES.O)
    fun setAmount(amount: Double) {
        _uiState.update { currentState ->
            currentState.copy(
                amount = amount
            )
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setRecurrence(recurrence: Recurrence) {
        _uiState.update { currentState ->
            currentState.copy(
                recurrence = recurrence
            )
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setDate(date: LocalDate) {
        _uiState.update { currentState ->
            currentState.copy(
                date = date
            )
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setNote(note: String) {
        _uiState.update { currentState ->
            currentState.copy(
                note = note
            )
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setCategory(category: String) {
        _uiState.update { currentState ->
            currentState.copy(
                category = category
            )
        }
    }

    fun submitExpense(){
        // TODO : Save to Local DB
    }

}