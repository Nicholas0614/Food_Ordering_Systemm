package com.foodorderingsystem.demo.entity

import jakarta.persistence.Entity
import jakarta.persistence.*
@Entity
@Table(name = "option_items")
data class OptionItem(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,
    val price: Double,

    @ManyToOne
    @JoinColumn(name = "group_id")
    val optionGroup: OptionGroup
)