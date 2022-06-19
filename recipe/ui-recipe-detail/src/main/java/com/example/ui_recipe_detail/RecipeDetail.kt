package com.example.ui_recipe_detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun RecipeDetail(
    recipeId : Int?,
){
    Text("Recipe ID : $recipeId")

}