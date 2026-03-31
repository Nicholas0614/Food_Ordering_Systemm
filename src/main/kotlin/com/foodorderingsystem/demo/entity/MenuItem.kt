package com.foodorderingsystem.demo.entity

import jakarta.persistence.*

@Entity
data class MenuItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,
    val price: Double
)