package com.foodorderingsystem.demo.repository

import com.foodorderingsystem.demo.entity.MenuItem
import org.springframework.data.jpa.repository.JpaRepository

interface MenuRepository : JpaRepository<MenuItem, Long>