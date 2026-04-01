package com.foodorderingsystem.demo.service

import com.foodorderingsystem.demo.entity.FoodCategory
import com.foodorderingsystem.demo.repository.FoodCategoryRepository
import org.springframework.stereotype.Service

@Service
class FoodCategoryService(
    private val categoryRepository: FoodCategoryRepository
) {

    fun createCategory(category: FoodCategory): FoodCategory {
        return categoryRepository.save(category)
    }

    fun getAllCategories(): List<FoodCategory> {
        return categoryRepository.findAll()
    }

    fun getCategoryById(id: Long): FoodCategory {
        return categoryRepository.findById(id)
            .orElseThrow { RuntimeException("Category not found") }
    }

    fun updateCategory(id: Long, name: String): FoodCategory {

        val existing = categoryRepository.findById(id)
            .orElseThrow { RuntimeException("Category not found with id: $id") }

        val updated = existing.copy(
            name = name
        )

        return categoryRepository.save(updated)
    }

    fun deleteCategory(id: Long) {
        if (!categoryRepository.existsById(id)) {
            throw RuntimeException("Category not found")
        }
        categoryRepository.deleteById(id)
    }
}