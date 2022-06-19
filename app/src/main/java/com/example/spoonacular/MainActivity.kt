package com.example.spoonacular

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.MutableLiveData
import com.example.core.DataState
import com.example.core.Logger
import com.example.core.ProgressBarState
import com.example.core.UIComponent
import com.example.recipe_interactors.Recipeinteractors
import com.example.recipe_list_domain.RecipeList
import com.example.spoonacular.ui.theme.SpoonacularTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.json.JSONObject

class MainActivity : ComponentActivity() {

    // change the recipeList..
    private val recipeList: MutableState<RecipeList> = mutableStateOf(RecipeList(null, null, null, null))
    private val progressBarState: MutableState<ProgressBarState> = mutableStateOf(ProgressBarState.Idle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val getRecipeList = Recipeinteractors.build().getRecipeList
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
                    recipeList.value = dataState.data ?: RecipeList(null, null, null, null)
                }
                is DataState.Loading -> {
                    progressBarState.value = dataState.progressBarState
                }
            }
        }.launchIn(CoroutineScope(IO))

        setContent {
            SpoonacularTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    LazyColumn {
                        // change the recipeList
                        items(recipeList.value.results ?: listOf()) { recipes ->
                            Text(text = recipes.title.toString())
                        }
                    }
                    if (progressBarState.value is ProgressBarState.Loading) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
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