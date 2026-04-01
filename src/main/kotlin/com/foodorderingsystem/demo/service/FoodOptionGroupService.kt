package com.foodorderingsystem.demo.service

import com.foodorderingsystem.demo.entity.FoodOptionGroup
import com.foodorderingsystem.demo.repository.FoodOptionGroupRepository
import com.foodorderingsystem.demo.repository.FoodItemRepository
import com.foodorderingsystem.demo.repository.OptionGroupRepository
import org.springframework.stereotype.Service

@Service
class FoodOptionGroupService(
    private val repo: FoodOptionGroupRepository,
    private val foodRepo: FoodItemRepository,
    private val groupRepo: OptionGroupRepository
) {

    fun getAll(): List<FoodOptionGroup> {
        return repo.findAll()
    }

    fun addMapping(foodId: Long, groupId: Long): FoodOptionGroup {

        val food = foodRepo.findById(foodId).orElseThrow {
            RuntimeException("Food not found")
        }

        val group = groupRepo.findById(groupId).orElseThrow {
            RuntimeException("Option group not found")
        }

        val mapping = FoodOptionGroup(
            food = food,
            optionGroup = group
        )

        return repo.save(mapping)
    }

    fun getGroupsByFood(foodId: Long): List<FoodOptionGroup> {

        val food = foodRepo.findById(foodId).orElseThrow {
            RuntimeException("Food not found")
        }

        return repo.findAll().filter {
            it.food.id == food.id
        }
    }

    fun delete(id: Long) {
        if (!repo.existsById(id)) {
            throw RuntimeException("Mapping not found")
        }
        repo.deleteById(id)
    }
}