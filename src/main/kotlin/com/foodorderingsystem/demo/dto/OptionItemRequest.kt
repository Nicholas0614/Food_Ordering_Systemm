package com.foodorderingsystem.demo.dto

data class OptionItemRequest(
    val name: String,
    val price: Double,
    val groupId: Long
)