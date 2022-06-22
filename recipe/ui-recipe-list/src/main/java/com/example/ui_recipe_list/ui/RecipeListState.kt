package com.example.ui_recipe_list.ui

import com.example.core.ProgressBarState
import com.example.recipe_list_domain.RecipeList

data class RecipeListState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val recipeList: RecipeList? = null,
    val filteredRecipe: RecipeList? = null,
    val recipeName : String? = null,
)