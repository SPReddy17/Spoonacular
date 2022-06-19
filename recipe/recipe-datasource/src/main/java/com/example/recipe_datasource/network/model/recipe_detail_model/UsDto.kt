package com.example.recipe_datasource.network.model.recipe_detail_model

import com.example.recipe_detail_domain.Us
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class UsDto(
    @SerialName("amount")
    val amount: Double,
    @SerialName("unitLong")
    val unitLong: String,
    @SerialName("unitShort")
    val unitShort: String
)

fun UsDto.toUs(): Us{
    return Us(
        amount = amount,
        unitLong = unitLong,
        unitShort = unitShort
    )
}