package com.example.appquanlynhansu.Model

import java.util.Date
import org.bson.types.ObjectId

data class ChamCong(
    val nhanvienID: ObjectId, // ID nhân viên
    val ngay: Date,
    val trangthai: String,
)

