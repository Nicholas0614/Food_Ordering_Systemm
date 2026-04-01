package com.foodorderingsystem.demo.entity

import jakarta.persistence.*

@Entity
@Table(name = "Users")
class   User(

    val name: String,
    val emailAddress: String,
    val phoneNumber : String,
    val password : String,
    val role : String = "USER"

) : BaseEntity()