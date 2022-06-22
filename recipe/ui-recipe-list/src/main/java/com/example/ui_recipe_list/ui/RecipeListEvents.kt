package com.example.ui_recipe_list.ui

sealed class RecipeListEvents {

    object GetRecipeList : RecipeListEvents()
    object FilteredRecipe : RecipeListEvents()
    data class UpdateRecipeName(
        val recipeName: String,
    ) : RecipeListEvents()
}