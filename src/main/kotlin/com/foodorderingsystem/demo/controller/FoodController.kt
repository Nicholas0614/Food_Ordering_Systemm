package com.foodorderingsystem.demo.controller

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

    // ✅ Check DB name (debug)
    @GetMapping("/db")
    fun checkDb(): String {
        return jdbcTemplate.queryForObject("SELECT DB_NAME()", String::class.java)!!
    }

    // ✅ Raw SQL (still working)
    @GetMapping("/raw")
    fun getRaw(): List<Map<String, Any>> {
        return jdbcTemplate.queryForList("SELECT * FROM dbo.FoodItems")
    }

    // ✅ JPA via Service
    @GetMapping
    fun getAll(): List<FoodItem> {
        return foodService.getAll()
    }

    @GetMapping("/test-jpa")
    fun testJpa(): List<FoodItem> {
        return foodService.getAll()
    }

    @GetMapping("/jpa-db")
    fun checkJpaDb(): String {
        return jdbcTemplate.queryForObject("SELECT DB_NAME()", String::class.java)!!
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): FoodItem {
        return foodService.getById(id)
    }

    @PostMapping
    fun addFood(@RequestBody food: FoodItem): FoodItem {
        return foodService.addFood(food)
    }

    @PutMapping("/{id}")
    fun updateFood(
        @PathVariable id: Long,
        @RequestBody updated: FoodItem
    ): FoodItem {
        return foodService.updateFood(id, updated)
    }

    @DeleteMapping("/{id}")
    fun deleteFood(@PathVariable id: Long) {
        foodService.deleteFood(id)
    }
}