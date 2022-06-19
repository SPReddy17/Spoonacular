package com.example.ui_recipe_detail.ui

sealed class RecipeDetailEvents {
    data class GetRecipeDetail(
        val recipeId: Int
    ) : RecipeDetailEvents()
}
