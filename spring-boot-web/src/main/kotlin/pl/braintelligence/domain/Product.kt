package pl.braintelligence.domain

import java.util.*

class Product(
        val id: String = UUID.randomUUID().toString(),
        val name: String,
        val unitPrice: String
)
