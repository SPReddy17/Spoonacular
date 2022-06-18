package com.example.recipe_datasource.network

import com.example.recipe_datasource.network.model.recipe_list_model.RecipeListDto
import com.example.recipe_datasource.network.model.recipe_list_model.toRecipeList
import com.example.recipe_list_domain.RecipeList
import io.ktor.client.*
import io.ktor.client.request.*

class RecipeListServiceImpl(
    private val httpClient: HttpClient
) : RecipeListService {
    private val myApiKey = "2e11fd22ebe5489a99e0c4b5565d079c"
    override suspend fun getRecipeList(query: String): List<RecipeList> {
        return httpClient.get<List<RecipeListDto>> {
            url(EndPoints.RECIPE_SEARCH)
            parameter("apiKey", myApiKey)
            parameter("query", query)
        }.map { it.toRecipeList() }
    }
}