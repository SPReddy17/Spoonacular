package com.example.recipe_datasource.network

import com.example.recipe_list_domain.RecipeList
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

interface RecipeListService {
    suspend fun getRecipeList(query: String): RecipeList

    companion object Factory {
        fun build(): RecipeListService {
            return RecipeListServiceImpl(
                httpClient = HttpClient(Android) {
                    install(JsonFeature) {
                        serializer = KotlinxSerializer(
                            kotlinx.serialization.json.Json {
                                ignoreUnknownKeys = true// if server returns extra fields, ignores them...
                            },
                        )
                    }
                }
            )
        }
    }
}