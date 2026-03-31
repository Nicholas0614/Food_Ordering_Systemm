package com.foodorderingsystem.demo.controller

import com.foodorderingsystem.demo.dto.LoginRequest
import com.foodorderingsystem.demo.dto.RegisterRequest
import com.foodorderingsystem.demo.entity.User
import com.foodorderingsystem.demo.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(
    private val userService: UserService
) {

    @PostMapping("/register")
    fun register(@RequestBody request: RegisterRequest): String {
        return userService.register(request)
    }

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): String {
        return userService.login(request)
    }

    @GetMapping("/users")
    fun getAllUsers(): List<User> {
        return userService.getAllUsers()
    }
}