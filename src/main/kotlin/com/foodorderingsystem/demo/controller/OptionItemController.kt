package com.foodorderingsystem.demo.controller

import com.foodorderingsystem.demo.dto.OptionItemRequest
import com.foodorderingsystem.demo.entity.OptionItem
import com.foodorderingsystem.demo.service.OptionItemService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/option-items")
class OptionItemController(
    private val service: OptionItemService
) {

    @GetMapping
    fun getAll(): ResponseEntity<List<OptionItem>> {
        return ResponseEntity.ok(service.getAll())
    }

    @PostMapping
    fun createOptionItem(
        @RequestBody request: OptionItemRequest
    ): ResponseEntity<OptionItem> {
        return ResponseEntity.ok(
            service.create(request.name, request.price, request.groupId)
        )
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<String> {
        service.delete(id)
        return ResponseEntity.ok("Deleted successfully")
    }
}