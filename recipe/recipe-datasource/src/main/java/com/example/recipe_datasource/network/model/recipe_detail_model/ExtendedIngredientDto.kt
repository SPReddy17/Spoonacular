package com.example.recipe_datasource.network.model.recipe_detail_model

import com.example.recipe_detail_domain.ExtendedIngredient
import com.example.recipe_detail_domain.Measures
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExtendedIngredientDto(
    @SerialName("aisle")
    val aisle: String?,
    @SerialName("amount")
    val amount: Double?,
    @SerialName("consistency")
    val consistency: String?,
    @SerialName("id")
    val id: Int?,
    @SerialName("image")
    val image: String?,
    @SerialName("measures")
    val measures: MeasuresDto?,
    @SerialName("meta")
    val meta: List<String>?,
    @SerialName("name")
    val name: String?,
    @SerialName("nameClean")
    val nameClean: String?,
    @SerialName("original")
    val original: String?,
    @SerialName("originalName")
    val originalName: String?,
    @SerialName("unit")
    val unit: String?
)

fun convertExtendedIngredientDtoToExtendedIngredient(extendedIngredientDto: ExtendedIngredientDto): ExtendedIngredient{
    return ExtendedIngredient(
        aisle = extendedIngredientDto.aisle,
        amount = extendedIngredientDto.amount,
        consistency =  extendedIngredientDto.consistency,
        id = extendedIngredientDto.id,
        image = extendedIngredientDto.image,
        measures =  extendedIngredientDto.measures?.toMeasures(),
        meta = extendedIngredientDto.meta,
        name = extendedIngredientDto.name,
        nameClean =  extendedIngredientDto.nameClean,
        original = extendedIngredientDto.original,
        originalName = extendedIngredientDto.originalName,
        unit = extendedIngredientDto.unit
    )
}
