package com.foodorderingsystem.demo.entity

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "food_items")
data class FoodItem(

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    val id: Long = 0,

    @Column(name = "FoodName")
    @JsonProperty("foodName")
    val foodName: String,

    @Column(name = "Price")
    @JsonProperty("price")
    val price: Double,

    @ManyToOne
    @JoinColumn(name = "category_id")
    val category: FoodCategory,

    @Column(name = "Stock")
    @JsonProperty("stock")
    val stock: Int
)