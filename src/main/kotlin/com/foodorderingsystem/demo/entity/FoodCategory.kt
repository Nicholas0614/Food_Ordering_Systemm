package com.foodorderingsystem.demo.entity

import jakarta.persistence.*

@Entity
@Table(name = "food_categories")
data class FoodCategory(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    val name: String
)