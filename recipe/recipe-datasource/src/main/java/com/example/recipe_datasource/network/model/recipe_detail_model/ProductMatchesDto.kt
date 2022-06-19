package com.example.recipe_datasource.network.model.recipe_detail_model

import com.example.recipe_detail_domain.ProductMatches
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductMatchesDto(

    @SerialName("averageRating")
    val averageRating: Double,
    @SerialName("description")
    val description: String,
    @SerialName("id")
    val id: Int,
    @SerialName("imageUrl")
    val imageUrl: String,
    @SerialName("link")
    val link: String,
    @SerialName("price")
    val price: String,
    @SerialName("ratingCount")
    val ratingCount: Double,
    @SerialName("score")
    val score: Double,
    @SerialName("title")
    val title: String
)

fun convertProductMatchesDtoToProductMatches(productMatchesDto: ProductMatchesDto): ProductMatches {
    return ProductMatches(
        averageRating = productMatchesDto.averageRating,
        description = productMatchesDto.description,
        id = productMatchesDto.id,
        imageUrl = productMatchesDto.imageUrl,
        link = productMatchesDto.link,
        price = productMatchesDto.price,
        ratingCount = productMatchesDto.ratingCount,
        score = productMatchesDto.score,
        title = productMatchesDto.title
    )
}
