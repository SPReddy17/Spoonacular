package com.example.ui_recipe_detail.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberImagePainter
import com.example.core.ProgressBarState
import com.example.recipe_detail_domain.RecipeDetail
import com.example.ui_recipe_detail.R

@Composable
fun RecipeDetailScreen(
    state: RecipeDetailState,
    imageLoader: ImageLoader,
    events: (RecipeDetailEvents) -> Unit,
) {
    state.recipeDetail?.let{ recipeDetail ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {
            item {
                Column {
                    val painter = rememberImagePainter(
                        recipeDetail.image,
                        imageLoader = imageLoader,
                        builder = {
                            placeholder(if (isSystemInDarkTheme()) R.drawable.black_background else R.drawable.white_background)
                        }
                    )
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .defaultMinSize(minHeight = 200.dp),
                        painter = painter,
                        contentDescription = recipeDetail.title,
                        contentScale = ContentScale.Crop,
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .padding(end = 8.dp),
                                text = recipeDetail.title?:"",
                                style = MaterialTheme.typography.h1,
                            )
//                            val iconPainter = rememberImagePainter(
//                                hero.icon,
//                                imageLoader = imageLoader,
//                                builder = {
//                                    placeholder(if (isSystemInDarkTheme()) R.drawable.black_background else R.drawable.white_background)
//                                }
//                            )
//                            Image(
//                                modifier = Modifier
//                                    .height(30.dp)
//                                    .width(30.dp)
//                                    .align(Alignment.CenterVertically),
//                                painter = iconPainter,
//                                contentDescription = hero.localizedName,
//                                contentScale = ContentScale.Crop,
//                            )
                        }
                        Text(
                            modifier = Modifier
                                .padding(bottom = 4.dp),
                            text =recipeDetail.title?:"",
                            style = MaterialTheme.typography.subtitle1,
                        )
                        Text(
                            modifier = Modifier
                                .padding(bottom = 12.dp),
                            text = recipeDetail.title?:"",
                            style = MaterialTheme.typography.caption,
                        )
                        RecipeDetailStats(
                            recipeDetail = recipeDetail,
                            padding = 10.dp,
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
        }
    }
    if (state.progressBarState is ProgressBarState.Loading) {
        CircularProgressIndicator(
            //modifier = Modifier.align(Alignment.Center)
        )
        CircularProgressIndicator(
            modifier = Modifier
        )
    }

}


@Composable
fun RecipeDetailStats(
    recipeDetail: RecipeDetail,
    padding: Dp,
){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
        ,
        elevation = 8.dp,
        shape = MaterialTheme.shapes.medium
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
            ,
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
                ,
                text = "Base Stats",
                style = MaterialTheme.typography.h4,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(end = 20.dp)
                ){ // Str, Agi, Int, Health
                    Row( // STR
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                        ,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            text = "${stringResource(R.string.vegan)}:",
                            style = MaterialTheme.typography.body2,
                        )
                        Row {
                            Text(
                                text = "${recipeDetail.vegan}",
                                style = MaterialTheme.typography.body2,
                            )
                        }
                    }
                    Row( // AGI
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                        ,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            text = "${stringResource(R.string.vegetarian)}:",
                            style = MaterialTheme.typography.body2,
                        )
                        Row{
                            Text(
                                text = "${recipeDetail.vegetarian}",
                                style = MaterialTheme.typography.body2,
                            )

                        }
                    }
                    Row( // INT
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                        ,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            text = "${stringResource(R.string.gluten_free)}:",
                            style = MaterialTheme.typography.body2,
                        )
                        Row{
                            Text(
                                text = "${recipeDetail.glutenFree}",
                                style = MaterialTheme.typography.body2,
                            )
                        }
                    }
                    Row( // HP
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                        ,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            text = "${stringResource(R.string.health_score)}:",
                            style = MaterialTheme.typography.body2,
                        )
                        Text(
                            text = "${recipeDetail.healthScore}",
                            style = MaterialTheme.typography.body2,
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ){ // Atk Range, proj speed, move speed, atk dmg
                    Row( // Atk Range
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                            ,
                            text = "${stringResource(R.string.dairy_free)}:",
                            style = MaterialTheme.typography.body2,
                        )
                        Text(
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                            ,
                            text = "${recipeDetail.dairyFree}",
                            style = MaterialTheme.typography.body2,
                        )
                    }
                    Row( // projectile speed
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                            ,
                            text = "${stringResource(R.string.servings)}:",
                            style = MaterialTheme.typography.body2,
                        )
                        Text(
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                            ,
                            text = "${recipeDetail.servings}",
                            style = MaterialTheme.typography.body2,
                        )
                    }
                    Row( // Move speed
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                            ,
                            text = "${stringResource(R.string.name)}:",
                            style = MaterialTheme.typography.body2,
                        )
                        Text(
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                            ,
                            text = "${recipeDetail.title}",
                            style = MaterialTheme.typography.body2,
                        )
                    }
                }
            }
        }
    }
}