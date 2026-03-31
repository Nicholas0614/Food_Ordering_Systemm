package com.foodorderingsystem.demo.service

import com.foodorderingsystem.demo.entity.MenuItem
import com.foodorderingsystem.demo.repository.MenuRepository
import org.springframework.stereotype.Service

@Service
class MenuService(
    private val menuRepository: MenuRepository
) {

    fun getAllMenu(): List<MenuItem> = menuRepository.findAll()

    fun addMenu(item: MenuItem): MenuItem = menuRepository.save(item)
}