package com.foodorderingsystem.demo.repository

import com.foodorderingsystem.demo.entity.FoodOptionGroup
import org.springframework.data.jpa.repository.JpaRepository

interface FoodOptionGroupRepository : JpaRepository<FoodOptionGroup, Long> {
    fun findByFood_Id(foodId: Long): List<FoodOptionGroup>
}
