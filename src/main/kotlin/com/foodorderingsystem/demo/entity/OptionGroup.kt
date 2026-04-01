package com.foodorderingsystem.demo.entity

import jakarta.persistence.Entity
import jakarta.persistence.*

@Entity
@Table(name = "option_groups")
data class OptionGroup(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String // e.g. "Side Dish", "Drink", "Snack"
)