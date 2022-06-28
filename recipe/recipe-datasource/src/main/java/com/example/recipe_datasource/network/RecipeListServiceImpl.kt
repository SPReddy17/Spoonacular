package com.example.recipe_datasource.network

import com.example.recipe_datasource.network.model.recipe_detail_model.RecipeDetailDto
import com.example.recipe_datasource.network.model.recipe_detail_model.toRecipeDetail
import com.example.recipe_datasource.network.model.recipe_list_model.RecipeListDto
import com.example.recipe_datasource.network.model.recipe_list_model.toRecipeList
import com.example.recipe_detail_domain.RecipeDetail
import com.example.recipe_list_domain.RecipeList
import io.ktor.client.*
import io.ktor.client.request.*

class RecipeListServiceImpl(
    private val httpClient: HttpClient
) : RecipeListService {


    // to get list of recipes
    override suspend fun getRecipeList(query: String): RecipeList {
        return httpClient.get<RecipeListDto> {
            url(EndPoints.RECIPE_SEARCH)
            parameter("apiKey", myApiKey)
            parameter("query", query)
            parameter("number", 99) // returns 25 recipes
        }.toRecipeList()
    }

    // to get the specific recipe information
    override suspend fun getRecipeDetail(id: Int): RecipeDetail {

        val url = EndPoints.RECIPE_DETAIL_SEARCH + "/" + id + "/information"

        return httpClient.get<RecipeDetailDto> {
            url(url)
            parameter("apiKey", myApiKey)
            parameter("id", id)
        }.toRecipeDetail()
    }
}