package com.example.recipe_interactors

import com.example.recipe_datasource.network.RecipeListService

data class Recipeinteractors(
    val getRecipeList: GetRecipeList,
    // add other recipe interactors
) {
    companion object Factory {
        fun build(): Recipeinteractors {
            val service = RecipeListService.build()
            return Recipeinteractors(
                getRecipeList = GetRecipeList(
                    service = service
                )
            )
        }
    }
}