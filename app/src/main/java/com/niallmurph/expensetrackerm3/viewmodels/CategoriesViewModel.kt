package com.niallmurph.expensetrackerm3.viewmodels

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.niallmurph.expensetrackerm3.models.Category
import com.niallmurph.expensetrackerm3.ui.theme.Primary
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class CategoriesState(
    val newCategoryColour: Color = Primary,
    val newCategoryName: String = "",
    val colourPickerShowing: Boolean = false,
    val categories: MutableList<Category> = mutableListOf(
        Category("Groceries", Color.Green),
        Category("Alcohol", Color.Blue),
        Category("Entertainment", Color.Red),
        Category("Bills", Color.Magenta)
    )
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

    fun createNewCategory() {
        _uiState.update {

            val newList = mutableListOf(
                Category(
                    _uiState.value.newCategoryName,
                    _uiState.value.newCategoryColour
                )
            )

            newList.addAll(
                _uiState.value.categories
            )

            it.copy(
                categories = newList
            )
        }
    }

}