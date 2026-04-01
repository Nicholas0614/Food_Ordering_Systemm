package com.foodorderingsystem.demo.entity

import jakarta.persistence.Entity
import jakarta.persistence.*
@Entity
@Table(name = "food_option_groups")
data class FoodOptionGroup(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "food_id")
    val food: FoodItem,

    @ManyToOne
    @JoinColumn(name = "group_id")
    val optionGroup: OptionGroup
)