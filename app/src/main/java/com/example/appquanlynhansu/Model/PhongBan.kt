package com.example.appquanlynhansu.Model

import org.bson.types.ObjectId

data class PhongBan(
    val ten: String,
    val mota: String,
    val nhanvien: ObjectId,
)
