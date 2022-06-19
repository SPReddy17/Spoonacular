package com.example.recipe_detail_domain

data class AnalyzedInstruction(
    val name: String,
    val steps: List<Step>?
)