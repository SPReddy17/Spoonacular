package com.example.spoonacular.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import com.example.spoonacular.ui.navigation.Screen
import com.example.spoonacular.ui.theme.SpoonacularTheme
import com.example.ui_recipe_detail.ui.RecipeDetailScreen
import com.example.ui_recipe_detail.ui.RecipeDetailViewModel
import com.example.ui_recipe_list.ui.RecipeListScreen
import com.example.ui_recipe_list.ui.RecipeListViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // change the recipeList..
    @Inject
    lateinit var imageLoader: ImageLoader
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SpoonacularTheme {

                val navController = rememberNavController()
                NavHost(navController = navController,
                    startDestination = Screen.RecipeList.route,
                    builder = {
                        addRecipeList(navController = navController, imageLoader = imageLoader)
                        addRecipeDetail(
                            imageLoader = imageLoader
                        )
                    }
                )
            }
        }
    }
}

fun NavGraphBuilder.addRecipeList(
    navController: NavController,
    imageLoader: ImageLoader
) {
    composable(
        route = Screen.RecipeList.route
    ) {
        val viewModel: RecipeListViewModel = hiltViewModel()
        RecipeListScreen(
            state = viewModel.state.value,
            imageLoader = imageLoader,
            navigateToDetailScreen = { recipeId ->
                navController.navigate(
                    "${Screen.RecipeDetail.route}/$recipeId"
                )
            }
        )
    }
}

fun NavGraphBuilder.addRecipeDetail(
    imageLoader: ImageLoader
) {
    composable(
        route = Screen.RecipeDetail.route + "/{recipeId}",
        arguments = Screen.RecipeDetail.arguments,
    ) { navBackStackEntry ->
        val viewModel: RecipeDetailViewModel = hiltViewModel()
        RecipeDetailScreen(
            //  recipeId = navBackStackEntry.arguments?.get("recipeId") as Int?,
            state = viewModel.state.value,
            events = viewModel::onTriggerEvent,
            imageLoader = imageLoader
        )
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