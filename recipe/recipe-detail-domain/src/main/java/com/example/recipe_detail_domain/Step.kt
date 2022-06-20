package com.example.recipe_detail_domain

data class Step(
    val equipment: List<Equipment>?,
    val ingredients: List<Ingredient>?,
    val length: Length?,
    val number: Int?,
    val step: String?
)