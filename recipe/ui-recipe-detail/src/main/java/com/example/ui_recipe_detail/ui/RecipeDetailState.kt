package com.example.ui_recipe_detail.ui

import com.example.core.ProgressBarState
import com.example.recipe_detail_domain.RecipeDetail

data class RecipeDetailState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val recipeDetail: RecipeDetail? = null
)
