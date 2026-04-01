package com.foodorderingsystem.demo.dto

data class FoodRequest(
    val foodName: String,
    val price: Double,
    val stock: Int,
    val categoryId: Long
)