package com.foodorderingsystem.demo.controller

import com.foodorderingsystem.demo.dto.FoodRequest
import com.foodorderingsystem.demo.entity.FoodItem
import com.foodorderingsystem.demo.service.FoodService
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/food")
class FoodController(
    private val foodService: FoodService,
    private val jdbcTemplate: JdbcTemplate
) {

    // ✅ Debug DB
    @GetMapping("/db")
    fun checkDb(): String {
        return jdbcTemplate.queryForObject("SELECT DB_NAME()", String::class.java)!!
    }

    @GetMapping("/raw")
    fun getRaw(): List<Map<String, Any>> {
        return jdbcTemplate.queryForList("SELECT * FROM dbo.FoodItems")
    }

    // ✅ JPA
    @GetMapping
    fun getAll(): List<FoodItem> {
        return foodService.getAll()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): FoodItem {
        return foodService.getById(id)
    }

    // 🔥 FIXED (use DTO)
    @PostMapping
    fun addFood(@RequestBody request: FoodRequest): FoodItem {
        return foodService.addFood(
            request.foodName,
            request.price,
            request.stock,
            request.categoryId
        )
    }

    // 🔥 FIXED (use DTO)
    @PutMapping("/{id}")
    fun updateFood(
        @PathVariable id: Long,
        @RequestBody request: FoodRequest
    ): FoodItem {
        return foodService.updateFood(
            id,
            request.foodName,
            request.price,
            request.stock,
            request.categoryId
        )
    }

    @DeleteMapping("/{id}")
    fun deleteFood(@PathVariable id: Long) {
        foodService.deleteFood(id)
    }
}