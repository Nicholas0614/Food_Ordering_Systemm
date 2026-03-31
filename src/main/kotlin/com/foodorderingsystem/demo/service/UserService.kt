package com.foodorderingsystem.demo.service

import com.foodorderingsystem.demo.dto.LoginRequest
import com.foodorderingsystem.demo.dto.RegisterRequest
import com.foodorderingsystem.demo.entity.User
import com.foodorderingsystem.demo.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun register(request: RegisterRequest): String {

        if (request.password != request.confirmPassword) {
            return "Passwords do not match!"
        }

        if (userRepository.existsByEmailAddress(request.emailAddress)) {
            return "Email already taken!"
        }

        val hashedPassword = passwordEncoder.encode(request.password)

        val user = User(
            name = request.name,
            emailAddress = request.emailAddress,
            phoneNumber = request.phoneNumber.toString(),
            password = hashedPassword,
            role = "ROLE_USER"
        )

        userRepository.save(user)

        return "Register success!"
    }

    fun login(request: LoginRequest): String {

        val user = userRepository.findByEmailAddress(request.emailAddress)
            ?: return "User not found"

        if (!passwordEncoder.matches(request.password, user.password)) {
            return "Wrong password!"
        }

        return "Login success!"
    }

    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }
}