package com.foodorderingsystem.demo.controller

import com.foodorderingsystem.demo.dto.LoginRequest
import com.foodorderingsystem.demo.entity.User
import com.foodorderingsystem.demo.repository.UserRepository
import com.foodorderingsystem.demo.dto.RegisterRequest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    @PostMapping("/register")
    fun register(@RequestBody request: RegisterRequest): String {

        if (request.password != request.confirmPassword) {
            return "Passwords do not match!"
        }

        if (userRepository.existsByEmailAddress(request.emailAddress)) {
            return "Email already taken!"
        }

        val hashedPassword = passwordEncoder.encode(request.password)

        // create new user
        val user = User(
            name = request.name,
            emailAddress = request.emailAddress,
            phoneNumber = request.phoneNumber.toString(),
            password = hashedPassword,
            role = "ROLE_USER"
        )

        // save to database
        userRepository.save(user)

        return "Register success!"
    }


    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): String {

        val user = userRepository.findByEmailAddress(request.emailAddress)
            ?: return "User not found"

        if (!passwordEncoder.matches(request.password, user.password)) {
            return "Wrong password!"
        }

        return "Login success!"
    }

    @GetMapping("/users")
    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }
}

@RestController
@RequestMapping("/admin")
class AdminController {

    @GetMapping("/dashboard")
    fun adminOnly(): String {
        return "Welcome Admin!"
    }
}