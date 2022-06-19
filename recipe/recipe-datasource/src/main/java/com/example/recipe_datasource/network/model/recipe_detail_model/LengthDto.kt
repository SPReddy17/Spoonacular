package com.example.recipe_datasource.network.model.recipe_detail_model

import com.example.recipe_detail_domain.Length
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LengthDto(
    @SerialName("number")
    val number: Int?=null,
    @SerialName("unit")
    val unit: String?=null
)

fun LengthDto.toLength(): Length {
    return Length(
        number = number,
        unit = unit
    )
}