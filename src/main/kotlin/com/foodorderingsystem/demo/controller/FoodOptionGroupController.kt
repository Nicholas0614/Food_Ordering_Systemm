package com.foodorderingsystem.demo.controller

import com.foodorderingsystem.demo.dto.FoodOptionGroupRequest
import com.foodorderingsystem.demo.entity.FoodOptionGroup
import com.foodorderingsystem.demo.service.FoodOptionGroupService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/food-option-groups")
class FoodOptionGroupController(
    private val service: FoodOptionGroupService
) {

    @PostMapping
    fun mapFoodToOptionGroup(
        @RequestBody request: FoodOptionGroupRequest
    ): ResponseEntity<FoodOptionGroup> {
        return ResponseEntity.ok(
            service.addMapping(request.foodId, request.optionGroupId)
        )
    }
}