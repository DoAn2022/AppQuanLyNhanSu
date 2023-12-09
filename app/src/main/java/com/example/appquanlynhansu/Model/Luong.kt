package com.example.appquanlynhansu.Model

import org.bson.types.ObjectId

data class Luong(
    val hoten: String,
    val phongban: String,
    val thang: Long,
    val luongcoban: Long,
    val thuong: Long,
    val tongluong:Long,
)
