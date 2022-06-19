package com.example.spoonacular.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.compose.NamedNavArgument
import androidx.navigation.compose.navArgument

sealed class Screen(
    val route :String,
    val arguments : List<NamedNavArgument>

){

    object RecipeList : Screen(
        route = "recipeList",
        arguments = emptyList()
    )

    object RecipeDetail : Screen(
        route = "recipeDetail",
        arguments = listOf(
            navArgument(name = "recipeId"){
                type = NavType.IntType
            }
        )
    )

}
