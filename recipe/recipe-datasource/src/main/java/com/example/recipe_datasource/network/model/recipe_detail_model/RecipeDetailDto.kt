package com.example.recipe_datasource.network.model.recipe_detail_model

import com.example.recipe_datasource.network.model.recipe_list_model.RecipeListDto
import com.example.recipe_datasource.network.model.recipe_list_model.convertResultDtoToResult
import com.example.recipe_detail_domain.RecipeDetail
import com.example.recipe_list_domain.RecipeList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeDetailDto(
    @SerialName("aggregateLikes")
    val aggregateLikes: Int? = null,
    @SerialName("analyzedInstructions")
    val analyzedInstructions: List<AnalyzedInstructionDto>?,
    @SerialName("cheap")
    val cheap: Boolean,
    @SerialName("cookingMinutes")
    val cookingMinutes: Int?,
    @SerialName("creditsText")
    val creditsText: String?,
    @SerialName("cuisines")
    val cuisines: List<String>?,
    @SerialName("dairyFree")
    val dairyFree: Boolean?,
    @SerialName("diets")
    val diets: List<String>?,
    @SerialName("dishTypes")
    val dishTypes: List<String>?,
    @SerialName("extendedIngredients")
    val extendedIngredients: List<ExtendedIngredientDto>?,
    @SerialName("gaps")
    val gaps: String?,
    @SerialName("glutenFree")
    val glutenFree: Boolean?,
    @SerialName("healthScore")
    val healthScore: Int?,
    @SerialName("id")
    val id: Int?,
    @SerialName("image")
    val image: String?,
    @SerialName("imageType")
    val imageType: String?,
    @SerialName("instructions")
    val instructions: String?,
    @SerialName("license")
    val license: String? = null,
    @SerialName("lowFodmap")
    val lowFodmap: Boolean?,
    @SerialName("occasions")
    val occasions: List<String>?,
    @SerialName("openLicense")
    val openLicense: Int?,
    @SerialName("originalId")
    val originalId: Int?,
    @SerialName("preparationMinutes")
    val preparationMinutes: Int?,
    @SerialName("pricePerServing")
    val pricePerServing: Double?,
    @SerialName("readyInMinutes")
    val readyInMinutes: Int?,
    @SerialName("servings")
    val servings: Int?,
    @SerialName("sourceName")
    val sourceName: String?,
    @SerialName("sourceUrl")
    val sourceUrl: String?,
    @SerialName("spoonacularSourceUrl")
    val spoonacularSourceUrl: String?,
    @SerialName("summary")
    val summary: String?,
    @SerialName("sustainable")
    val sustainable: Boolean?,
    @SerialName("title")
    val title: String?,
    @SerialName("vegan")
    val vegan: Boolean?,
    @SerialName("vegetarian")
    val vegetarian: Boolean?,
    @SerialName("veryHealthy")
    val veryHealthy: Boolean?,
    @SerialName("veryPopular")
    val veryPopular: Boolean?,
    @SerialName("weightWatcherSmartPoints")
    val weightWatcherSmartPoints: Int?,
    @SerialName("winePairing")
    val winePairing: WinePairingDto?
)


fun RecipeDetailDto.toRecipeDetail(): RecipeDetail {
    return RecipeDetail(
        aggregateLikes = aggregateLikes,
        analyzedInstructions = analyzedInstructions?.map {convertAnalyzedInstructionDtoToAnalyzedInstruction(it)},
        cheap = cheap,
        cookingMinutes = cookingMinutes,
        creditsText = creditsText,
        cuisines = cuisines,
        dairyFree = dairyFree,
        diets = diets,
        dishTypes = dishTypes,
        extendedIngredients = extendedIngredients?.map {convertExtendedIngredientDtoToExtendedIngredient(it)},
        gaps = gaps,
        glutenFree = glutenFree,
        healthScore = healthScore,
        id = id,
        image = image,
        imageType = imageType,
        instructions = instructions,
        license = license,
        lowFodmap = lowFodmap,
        occasions = occasions,
        openLicense = openLicense,
        originalId = originalId,
        preparationMinutes = preparationMinutes,
        pricePerServing = pricePerServing,
        readyInMinutes = readyInMinutes,
        servings = servings,
        sourceName = sourceName,
        sourceUrl = sourceUrl,
        spoonacularSourceUrl = spoonacularSourceUrl,
        summary = summary,
        sustainable = sustainable,
        title = title,
        vegan = vegan,
        vegetarian = vegetarian,
        veryHealthy = veryHealthy,
        veryPopular = veryPopular,
        weightWatcherSmartPoints = weightWatcherSmartPoints,
        winePairing = winePairing?.toWinePairing(),
    )
}
