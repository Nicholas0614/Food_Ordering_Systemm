package com.foodorderingsystem.demo.dto

data class RegisterRequest(
    val name: String,
    val emailAddress: String,
    val phoneNumber: Number,
    val password: String,
    val confirmPassword: String
)