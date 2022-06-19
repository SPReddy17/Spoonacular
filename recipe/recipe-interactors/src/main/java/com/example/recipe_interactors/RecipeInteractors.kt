package com.example.recipe_interactors

import com.example.recipe_datasource.network.RecipeListService

data class RecipeInteractors(
    val getRecipeList: GetRecipeList,
    // add other recipe interactors
) {
    companion object Factory {
        fun build(): RecipeInteractors {
            val service = RecipeListService.build()
            return RecipeInteractors(
                getRecipeList = GetRecipeList(
                    service = service
                )
            )
        }
    }
}