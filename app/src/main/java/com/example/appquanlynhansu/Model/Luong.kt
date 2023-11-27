package com.example.appquanlynhansu.Model

import org.bson.types.ObjectId

data class Luong(
    val nhanvienId: ObjectId,
    val thang: Double,
    val luongcoban: Long,
    val thuong: Long,
    val tongluong:Long,
)
