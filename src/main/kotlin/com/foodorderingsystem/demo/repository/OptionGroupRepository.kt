package com.foodorderingsystem.demo.repository

import com.foodorderingsystem.demo.entity.OptionGroup
import org.springframework.data.jpa.repository.JpaRepository

interface OptionGroupRepository : JpaRepository<OptionGroup, Long>