package com.foodorderingsystem.demo.repository

import com.foodorderingsystem.demo.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun existsByEmailAddress(emailAddress: String): Boolean
    fun findByEmailAddress(emailAddress: String): User?
}