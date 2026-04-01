package com.foodorderingsystem.demo.controller

import com.foodorderingsystem.demo.dto.OptionGroupRequest
import com.foodorderingsystem.demo.entity.OptionGroup
import com.foodorderingsystem.demo.service.OptionGroupService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/option-groups")
class OptionGroupController(
    private val service: OptionGroupService
) {

    @GetMapping
    fun getAll(): ResponseEntity<List<OptionGroup>> {
        return ResponseEntity.ok(service.getAll())
    }

    @PostMapping
    fun create(@RequestBody request: OptionGroupRequest): ResponseEntity<OptionGroup> {
        return ResponseEntity.ok(service.create(request.name))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<String> {
        service.delete(id)
        return ResponseEntity.ok("Deleted successfully")
    }
}