package com.foodorderingsystem.demo.controller

import com.foodorderingsystem.demo.dto.CategoryRequest
import com.foodorderingsystem.demo.entity.FoodCategory
import com.foodorderingsystem.demo.service.FoodCategoryService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/categories")
class FoodCategoryController(
    private val categoryService: FoodCategoryService
) {

    @PostMapping
    fun create(@RequestBody category: FoodCategory): FoodCategory {
        return categoryService.createCategory(category)
    }

    @GetMapping
    fun getAll(): List<FoodCategory> {
        return categoryService.getAllCategories()
    }

    @GetMapping("/{id}")
    fun getCategoryById(@PathVariable id: Long): FoodCategory {
        return categoryService.getCategoryById(id)
    }

    @PutMapping("/{id}")
    fun updateCategory(
        @PathVariable id: Long,
        @RequestBody request: CategoryRequest
    ): FoodCategory {
        return categoryService.updateCategory(id, request.name)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        categoryService.deleteCategory(id)
    }
}