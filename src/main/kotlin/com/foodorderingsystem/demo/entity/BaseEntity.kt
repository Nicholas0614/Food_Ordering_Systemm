package com.foodorderingsystem.demo.entity

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@MappedSuperclass
open class BaseEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var modifiedBy : String? = null
) {
    val createdAt: LocalDateTime = LocalDateTime.now()
    var updatedAt: LocalDateTime = LocalDateTime.now()
}
