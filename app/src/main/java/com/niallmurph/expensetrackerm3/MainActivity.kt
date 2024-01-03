package com.niallmurph.expensetrackerm3

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.niallmurph.expensetrackerm3.screens.ExpensesScreen
import com.niallmurph.expensetrackerm3.screens.SettingsScreen
import com.niallmurph.expensetrackerm3.ui.theme.ExpenseTrackerM3Theme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpenseTrackerM3Theme {

                val navController = rememberNavController()
                val backStackEntry = navController.currentBackStackEntryAsState()

                Scaffold(
                    bottomBar = {
                        NavigationBar {
                            NavigationBarItem(
                                selected = backStackEntry.value?.destination?.route.equals(ExpensesScreen().route),
                                onClick = { navController.navigate(ExpensesScreen().route) },
                                label = {
                                    Text("Expenses")
                                },
                                icon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_expense),
                                        contentDescription = "Expenses Icon"
                                    )
                                }
                            )
                            NavigationBarItem(
                                selected = backStackEntry.value?.destination?.route.equals("reports"),
                                onClick = { navController.navigate("reports") },
                                label = {
                                    Text("Reports")
                                },
                                icon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_bar_chart),
                                        contentDescription = "Reports Icon"
                                    )
                                }
                            )
                            NavigationBarItem(
                                selected = backStackEntry.value?.destination?.route.equals("add"),
                                onClick = { navController.navigate("add") },
                                label = {
                                    Text("Add")
                                },
                                icon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_add),
                                        contentDescription = "Add Icon"
                                    )
                                }
                            )
                            NavigationBarItem(
                                selected = backStackEntry.value?.destination?.route.equals("settings"),
                                onClick = { navController.navigate("settings") },
                                label = {
                                    Text("Settings")
                                },
                                icon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_settings),
                                        contentDescription = "Settings Icon"
                                    )
                                }
                            )
                        }
                    },
                    content = {

                        NavHost(navController = navController, startDestination = ExpensesScreen().route){
                            composable(ExpensesScreen().route){
                                ExpensesScreen().Create(navController = navController)
                            }
                            composable("reports"){
                                Surface(
                                    modifier = Modifier
                                        .fillMaxSize()
                                ){
                                    Greeting(name = "Reports")
                                }
                            }
                            composable("add"){
                                Surface(
                                    modifier = Modifier
                                        .fillMaxSize()
                                ){
                                    Greeting(name = "Add")
                                }
                            }
                            composable("settings"){
                                Surface(
                                    modifier = Modifier
                                        .fillMaxSize()
                                ){
                                    SettingsScreen().Create(navController = navController)
                                }
                            }
                            composable("settings/categories"){
                                Surface(
                                    modifier = Modifier
                                        .fillMaxSize()
                                ){
                                    Greeting(name = "Categories")
                                }
                            }
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}