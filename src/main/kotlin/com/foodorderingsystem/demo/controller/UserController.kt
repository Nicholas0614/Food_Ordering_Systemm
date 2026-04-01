package com.foodorderingsystem.demo.controller

import com.foodorderingsystem.demo.constants.ErrorConstants
import com.foodorderingsystem.demo.dto.LoginRequest
import com.foodorderingsystem.demo.dto.RegisterRequest
import com.foodorderingsystem.demo.entity.User
import com.foodorderingsystem.demo.service.UserService
import org.springframework.http.ResponseEntity
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
    fun login(@RequestBody request: LoginRequest): ResponseEntity<Any> {
        return try {
            val user = userService.login(request)

            ResponseEntity.ok(user)

        } catch (e: RuntimeException) {
            when (e.message) {
                ErrorConstants.USER_NOT_FOUND ->
                    ResponseEntity.status(404).body(e.message)

                ErrorConstants.WRONG_PASSWORD ->
                    ResponseEntity.status(401).body(e.message)

                else ->
                    ResponseEntity.status(400).body("Something went wrong")
            }
        }
    }

    @GetMapping("/users")
    fun getAllUsers(): List<User> {
        return userService.getAllUsers()
    }
}