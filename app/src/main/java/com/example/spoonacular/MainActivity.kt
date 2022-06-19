package com.example.spoonacular

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview
import coil.ImageLoader
import com.example.core.DataState
import com.example.core.Logger
import com.example.core.UIComponent
import com.example.recipe_interactors.RecipeInteractors
import com.example.recipe_list_domain.RecipeList
import com.example.spoonacular.ui.theme.SpoonacularTheme
import com.example.ui_recipe_list.ui.RecipeListScreen
import com.example.ui_recipe_list.ui.RecipeListState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainActivity : ComponentActivity() {

    // change the recipeList..
    private val state: MutableState<RecipeListState> = mutableStateOf(RecipeListState())
    private lateinit var imageLoader: ImageLoader
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imageLoader = ImageLoader.Builder(applicationContext)
            .error(R.drawable.error_image)
            .placeholder(R.drawable.white_background)
            .availableMemoryPercentage(.25)
            .crossfade(true)
            .build()
        val getRecipeList = RecipeInteractors.build().getRecipeList
        val logger = Logger("GetRecipeListTest")
        getRecipeList.execute("burger").onEach { dataState ->
            when (dataState) {
                is DataState.Response -> {
                    when (dataState.uiComponent) {
                        is UIComponent.Dialog -> {
                            logger.log((dataState.uiComponent as UIComponent.Dialog).description)
                        }
                        is UIComponent.None -> {
                            logger.log((dataState.uiComponent as UIComponent.None).message)
                        }
                    }
                }
                is DataState.Data -> {
                    //change the recipe list
                    state.value = state.value.copy(
                        recipeList = dataState.data ?: RecipeList(
                            null,
                            null,
                            null,
                            null
                        )
                    )
                }
                is DataState.Loading -> {
                    state.value = state.value.copy(progressBarState = dataState.progressBarState)
                }
            }
        }.launchIn(CoroutineScope(IO))

        setContent {
            SpoonacularTheme {
                RecipeListScreen(
                    state = state.value,
                    imageLoader = imageLoader
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SpoonacularTheme {
        Greeting("Android")
    }
}