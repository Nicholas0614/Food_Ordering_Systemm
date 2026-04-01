package com.foodorderingsystem.demo.service

import com.foodorderingsystem.demo.entity.OptionItem
import com.foodorderingsystem.demo.repository.OptionItemRepository
import com.foodorderingsystem.demo.repository.OptionGroupRepository
import org.springframework.stereotype.Service

@Service
class OptionItemService(
    private val repo: OptionItemRepository,
    private val groupRepo: OptionGroupRepository
) {

    fun getAll(): List<OptionItem> {
        return repo.findAll()
    }

    fun getById(id: Long): OptionItem {
        return repo.findById(id).orElseThrow {
            RuntimeException("Option item not found")
        }
    }

    fun create(name: String, price: Double, groupId: Long): OptionItem {

        val group = groupRepo.findById(groupId).orElseThrow {
            RuntimeException("Option group not found")
        }

        val item = OptionItem(
            name = name,
            price = price,
            optionGroup = group
        )

        return repo.save(item)
    }

    fun delete(id: Long) {
        if (!repo.existsById(id)) {
            throw RuntimeException("Option item not found")
        }
        repo.deleteById(id)
    }
}