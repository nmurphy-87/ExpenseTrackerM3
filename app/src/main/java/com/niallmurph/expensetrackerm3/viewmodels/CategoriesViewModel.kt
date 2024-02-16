package com.niallmurph.expensetrackerm3.viewmodels

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.niallmurph.expensetrackerm3.ui.theme.Primary
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class CategoriesState(
    val newCategoryColour: Color = Primary,
    val newCategoryName: String = "",
    val colourPickerShowing : Boolean = false
)

class CategoriesViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CategoriesState())
    val uiState: StateFlow<CategoriesState> = _uiState.asStateFlow()

    fun setNewCategoryColour(color: Color) {
        _uiState.update {
            it.copy(
                newCategoryColour = color
            )
        }
    }

    fun setNewCategoryName(name: String) {
        _uiState.update {
            it.copy(
                newCategoryName = name
            )
        }
    }

    fun showColourPicker() {
        _uiState.update {
            it.copy(
                colourPickerShowing = true
            )
        }
    }

    fun hideColourPicker() {
        _uiState.update {
            it.copy(
                colourPickerShowing = false
            )
        }
    }

    fun createNewCategory(){

    }

}