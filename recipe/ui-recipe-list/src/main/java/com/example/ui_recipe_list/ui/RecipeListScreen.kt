package com.example.ui_recipe_list.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import coil.ImageLoader
import com.example.core.ProgressBarState
import com.example.ui_recipe_list.components.RecipeListItem
import com.example.ui_recipe_list.components.RecipeListToolbar

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RecipeListScreen(
    state: RecipeListState,
    imageLoader: ImageLoader,
    navigateToDetailScreen: (Int) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column() {
            val recipeName = remember { mutableStateOf("") }
            RecipeListToolbar(
                recipeName = recipeName.value,
                onRecipeNameChanged ={name ->
                    recipeName.value = name
                },
                onExecuteSearch = { /*TODO*/
                },
                onShowFilterDialog = {

                })
            LazyColumn {
                // change the recipeList
                items(state.recipeList?.results ?: listOf()) { recipes ->
                    //Text(text = recipes.title.toString())
                    RecipeListItem(
                        recipe = recipes,
                        onSelectRecipe = { recipeId ->
                            navigateToDetailScreen(recipeId)
                        },
                        imageLoader = imageLoader,
                    )
                }
            }

        }

        if (state.progressBarState is ProgressBarState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}