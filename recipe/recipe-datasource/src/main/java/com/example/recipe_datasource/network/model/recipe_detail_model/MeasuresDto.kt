package com.example.recipe_datasource.network.model.recipe_detail_model

import com.example.recipe_detail_domain.Measures
import com.example.recipe_detail_domain.Metric
import com.example.recipe_detail_domain.Us
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MeasuresDto(
    @SerialName("metric")
    val metric: MetricDto,
    @SerialName("us")
    val us: UsDto
)

fun MeasuresDto.toMeasures(): Measures{
    return Measures(
        metric = metric.toMetric(),
        us = us.toUs()
    )
}