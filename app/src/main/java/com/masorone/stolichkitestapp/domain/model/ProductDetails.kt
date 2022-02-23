package com.masorone.stolichkitestapp.domain.model

import java.util.*

data class ProductDetails(
    val price: Double,
    val expirationDate: Date,
    val amount: Int
)
