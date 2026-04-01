package com.foodorderingsystem.demo.service

import com.foodorderingsystem.demo.constants.ErrorConstants
import com.foodorderingsystem.demo.entity.FoodItem
import com.foodorderingsystem.demo.repository.FoodItemRepository
import com.foodorderingsystem.demo.repository.FoodCategoryRepository
import com.foodorderingsystem.demo.repository.FoodOptionGroupRepository
import org.springframework.stereotype.Service

@Service
class FoodService(
    private val repo: FoodItemRepository,
    private val categoryRepo: FoodCategoryRepository,
    private val foodOptionGroupRepo: FoodOptionGroupRepository
) {

    fun getAll(): List<FoodItem> {
        return repo.findAll()
    }

    fun getById(id: Long): FoodItem {
        return repo.findById(id).orElseThrow {
            RuntimeException(ErrorConstants.FOOD_NOT_FOUND)
        }
    }

    // ✅ CREATE
    fun addFood(
        foodName: String,
        price: Double,
        stock: Int,
        categoryId: Long,
        imageUrl: String? = null
    ): FoodItem {

        val category = categoryRepo.findById(categoryId).orElseThrow {
            RuntimeException(ErrorConstants.CATEGORY_NOT_FOUND)
        }

        val food = FoodItem(
            foodName = foodName,
            price = price,
            stock = stock,
            category = category,
            imageUrl = imageUrl
        )

        return repo.save(food)
    }

    // ✅ UPDATE
    fun updateFood(
        id: Long,
        foodName: String,
        price: Double,
        stock: Int,
        categoryId: Long,
        imageUrl: String? = null
    ): FoodItem {

        val existing = repo.findById(id).orElseThrow {
            RuntimeException(ErrorConstants.FOOD_NOT_FOUND)
        }

        val category = categoryRepo.findById(categoryId).orElseThrow {
            RuntimeException(ErrorConstants.CATEGORY_NOT_FOUND)
        }

        val updatedFood = existing.copy(
            foodName = foodName,
            price = price,
            stock = stock,
            category = category,
            imageUrl = imageUrl
        )

        return repo.save(updatedFood)
    }

    // ✅ DELETE
    fun deleteFood(id: Long) {
        if (!repo.existsById(id)) {
            throw RuntimeException(ErrorConstants.FOOD_NOT_FOUND)
        }
        repo.deleteById(id)
    }

    // ✅ GET FOOD WITH OPTIONS (IMPORTANT)
    fun getFoodWithOptions(foodId: Long): Map<String, Any> {

        val food = repo.findById(foodId).orElseThrow {
            RuntimeException(ErrorConstants.FOOD_NOT_FOUND)
        }

        val mappings = foodOptionGroupRepo.findByFood_Id(foodId)

        val groups = mappings.map { it.optionGroup }

        return mapOf(
            "food" to food,
            "optionGroups" to groups
        )
    }
}