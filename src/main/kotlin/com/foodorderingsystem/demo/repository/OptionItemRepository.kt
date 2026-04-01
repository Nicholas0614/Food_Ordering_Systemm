package com.foodorderingsystem.demo.repository

import com.foodorderingsystem.demo.entity.OptionItem
import org.springframework.data.jpa.repository.JpaRepository

interface OptionItemRepository : JpaRepository<OptionItem, Long>
