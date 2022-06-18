package com.example.recipe_list_domain

data class RecipeList(
    val number: Int,
    val offset: Int,
    val results: List<Result>,
    val totalResults: Int
)