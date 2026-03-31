package com.foodorderingsystem.demo.service

import com.foodorderingsystem.demo.entity.FoodItem
import com.foodorderingsystem.demo.repository.FoodItemRepository
import org.springframework.stereotype.Service

@Service
class FoodService(
    private val repo: FoodItemRepository
) {

    fun getAll(): List<FoodItem> {
        return repo.findAll()
    }

    fun getById(id: Long): FoodItem {
        return repo.findById(id).orElseThrow {
            RuntimeException("Food not found with id: $id")
        }
    }

    fun addFood(food: FoodItem): FoodItem {
        return repo.save(food)
    }

    fun updateFood(id: Long, updated: FoodItem): FoodItem {
        val existing = repo.findById(id).orElseThrow {
            RuntimeException("Food not found with id: $id")
        }

        val newFood = existing.copy(
            foodName = updated.foodName,
            price = updated.price,
            category = updated.category,
            stock = updated.stock
        )

        return repo.save(newFood)
    }

    fun deleteFood(id: Long) {
        repo.deleteById(id)
    }
}