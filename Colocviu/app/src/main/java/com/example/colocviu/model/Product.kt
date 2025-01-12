package com.example.colocviu.model

import java.io.Serializable

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val thumbnail: String //adresă URL pentru imagine
) : Serializable
