package com.foodorderingsystem.demo.service

import com.foodorderingsystem.demo.entity.FoodItem
import com.foodorderingsystem.demo.repository.FoodItemRepository
import com.foodorderingsystem.demo.repository.FoodCategoryRepository
import org.springframework.stereotype.Service

@Service
class FoodService(
    private val repo: FoodItemRepository,
    private val categoryRepo: FoodCategoryRepository
) {

    fun getAll(): List<FoodItem> {
        return repo.findAll()
    }

    fun getById(id: Long): FoodItem {
        return repo.findById(id).orElseThrow {
            RuntimeException("Food not found with id: $id")
        }
    }

    // ✅ CREATE (use categoryId)
    fun addFood(
        foodName: String,
        price: Double,
        stock: Int,
        categoryId: Long
    ): FoodItem {

        val category = categoryRepo.findById(categoryId).orElseThrow {
            RuntimeException("Category not found with id: $categoryId")
        }

        val food = FoodItem(
            foodName = foodName,
            price = price,
            stock = stock,
            category = category
        )

        return repo.save(food)
    }

    // ✅ UPDATE (safe way)
    fun updateFood(
        id: Long,
        foodName: String,
        price: Double,
        stock: Int,
        categoryId: Long
    ): FoodItem {

        val existing = repo.findById(id).orElseThrow {
            RuntimeException("Food not found with id: $id")
        }

        val category = categoryRepo.findById(categoryId).orElseThrow {
            RuntimeException("Category not found with id: $categoryId")
        }

        val updatedFood = existing.copy(
            foodName = foodName,
            price = price,
            stock = stock,
            category = category
        )

        return repo.save(updatedFood)
    }

    fun deleteFood(id: Long) {
        if (!repo.existsById(id)) {
            throw RuntimeException("Food not found with id: $id")
        }
        repo.deleteById(id)
    }
}