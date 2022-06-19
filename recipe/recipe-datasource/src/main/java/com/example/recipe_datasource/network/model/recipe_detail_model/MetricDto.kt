package com.example.recipe_datasource.network.model.recipe_detail_model

import com.example.recipe_detail_domain.Metric
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MetricDto(
    @SerialName("amount")
    val amount: Double,
    @SerialName("unitLong")
    val unitLong: String,
    @SerialName("unitShort")
    val unitShort: String
)

fun MetricDto.toMetric(): Metric{
    return Metric(
        amount = amount,
        unitLong = unitLong,
        unitShort = unitShort
    )
}