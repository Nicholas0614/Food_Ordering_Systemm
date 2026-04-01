package com.foodorderingsystem.demo.repository

import com.foodorderingsystem.demo.entity.FoodCategory
import org.springframework.data.jpa.repository.JpaRepository

interface FoodCategoryRepository : JpaRepository<FoodCategory, Long>