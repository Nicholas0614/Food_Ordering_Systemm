package com.foodorderingsystem.demo.service

import com.foodorderingsystem.demo.entity.OptionGroup
import com.foodorderingsystem.demo.repository.OptionGroupRepository
import org.springframework.stereotype.Service

@Service
class OptionGroupService(
    private val repo: OptionGroupRepository
) {

    fun getAll(): List<OptionGroup> {
        return repo.findAll()
    }

    fun getById(id: Long): OptionGroup {
        return repo.findById(id).orElseThrow {
            RuntimeException("Option group not found")
        }
    }

    fun create(name: String): OptionGroup {
        val group = OptionGroup(name = name)
        return repo.save(group)
    }

    fun delete(id: Long) {
        if (!repo.existsById(id)) {
            throw RuntimeException("Option group not found")
        }
        repo.deleteById(id)
    }
}