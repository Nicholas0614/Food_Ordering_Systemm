package com.foodorderingsystem.demo.repository

import com.foodorderingsystem.demo.entity.FoodItem
import org.springframework.data.jpa.repository.JpaRepository

interface FoodItemRepository : JpaRepository<FoodItem, Long>