package com.example.appquanlynhansu.Model

import org.bson.types.ObjectId

data class Luong(
    val nhanvienId: ObjectId,
    val thang: Double,
    val luongcoban: Double,
    val thuong: Double,
    val tongluong:Double,
)
