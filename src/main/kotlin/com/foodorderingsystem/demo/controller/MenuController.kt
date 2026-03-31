package com.foodorderingsystem.demo.controller

import com.foodorderingsystem.demo.entity.MenuItem
import com.foodorderingsystem.demo.service.MenuService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/menu")
class MenuController(
    private val menuService: MenuService
) {

    @GetMapping
    fun getMenu(): List<MenuItem> {
        return menuService.getAllMenu()
    }

    @PostMapping
    fun addMenu(@RequestBody item: MenuItem): MenuItem {
        return menuService.addMenu(item)
    }
}