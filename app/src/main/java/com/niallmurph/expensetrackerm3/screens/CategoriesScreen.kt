package com.niallmurph.expensetrackerm3.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.github.skydoves.colorpicker.compose.AlphaTile
import com.github.skydoves.colorpicker.compose.HsvColorPicker
import com.github.skydoves.colorpicker.compose.rememberColorPickerController
import com.niallmurph.expensetrackerm3.components.TableRow
import com.niallmurph.expensetrackerm3.ui.theme.BackgroundElevated
import com.niallmurph.expensetrackerm3.ui.theme.DividerColor
import com.niallmurph.expensetrackerm3.ui.theme.TopAppBarBackground
import com.niallmurph.expensetrackerm3.viewmodels.CategoriesViewModel

class CategoriesScreen {

    val route = "settings/categories"

    @Composable
    fun Create(navController: NavController) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Display(navController = navController)
        }
    }

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    private fun Display(
        navController: NavController,
        viewModel: CategoriesViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
    ) {

        val state by viewModel.uiState.collectAsState()
        val colourPickerController = rememberColorPickerController()

        Scaffold(
            topBar = {
                SmallTopAppBar(
                    title = { Text("Categories") },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "Back Button"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = TopAppBarBackground
                    )
                )
            },
            content = { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        LazyColumn(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(6.dp))
                                .background(BackgroundElevated)
                        ) {
                            itemsIndexed(state.categories) { index, category ->
                                TableRow{
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ){
                                        Row(
                                            modifier = Modifier.padding(horizontal = 12.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ){
                                            Surface(
                                                color = category.colour,
                                                shape = CircleShape,
                                                border = BorderStroke(
                                                    width = 1.dp,
                                                    color = Color.DarkGray
                                                ),
                                                modifier = Modifier.size(16.dp)
                                            ) {}
                                            Text(text = category.name, modifier = Modifier.padding(horizontal = 12.dp, vertical = 16.dp))
                                        }
                                        IconButton(onClick = { viewModel.deleteCategory(category) }) {
                                            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Icon")
                                        }
                                    }
                                }
                                if (index <= state.categories.size - 2) {
                                    Divider(
                                        modifier = Modifier.padding(horizontal = 8.dp),
                                        thickness = 1.dp,
                                        color = DividerColor
                                    )
                                }
                            }
                        }
                    }
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        if (state.colourPickerShowing) {
                            Dialog(onDismissRequest = { viewModel.hideColourPicker() }) {
                                Surface(
                                    color = BackgroundElevated,
                                    shape = MaterialTheme.shapes.large
                                ) {
                                    Column(
                                        modifier = Modifier.padding(all = 30.dp)
                                    ) {
                                        Text(
                                            "Select a color",
                                            style = MaterialTheme.typography.titleLarge
                                        )
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(top = 24.dp),
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            AlphaTile(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .height(60.dp)
                                                    .clip(RoundedCornerShape(6.dp)),
                                                controller = colourPickerController
                                            )
                                        }
                                        HsvColorPicker(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(300.dp)
                                                .padding(10.dp),
                                            controller = colourPickerController,
                                            onColorChanged = { envelope ->
                                                viewModel.setNewCategoryColour(envelope.color)
                                            },
                                        )
                                        TextButton(
                                            onClick = viewModel::hideColourPicker,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(top = 24.dp),
                                        ) {
                                            Text("Done")
                                        }
                                    }
                                }
                            }
                        }
                        Surface(
                            modifier = Modifier
                                .size(width = 24.dp, height = 24.dp)
                                .clickable(
                                    enabled = true,
                                    onClick = viewModel::showColourPicker
                                ),
                            shape = CircleShape,
                            color = state.newCategoryColour,
                            border = BorderStroke(
                                width = 2.dp,
                                color = Color.DarkGray
                            )
                        ) {}
                        OutlinedTextField(
                            value = state.newCategoryName,
                            onValueChange = viewModel::setNewCategoryName,
                            placeholder = {
                                Text(text = "Add a new category")
                            }
                        )
                        IconButton(
                            onClick = viewModel::createNewCategory
                        ) {
                            Icon(
                                imageVector = Icons.Default.Send,
                                contentDescription = "Save Category"
                            )
                        }
                    }
                }

            }
        )
    }
}