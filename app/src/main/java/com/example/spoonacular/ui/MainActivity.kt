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
import com.example.ui_recipe_detail.RecipeDetail
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
                        addRecipeDetail()
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

fun NavGraphBuilder.addRecipeDetail() {
    composable(
        route = Screen.RecipeDetail.route + "/{recipeId}",
        arguments = Screen.RecipeDetail.arguments,
    ) { navBackStackEntry ->
        RecipeDetail(
            recipeId = navBackStackEntry.arguments?.get("recipeId") as Int?
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