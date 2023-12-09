package com.example.appquanlynhansu.Model

import java.util.Date
import org.bson.types.ObjectId

data class ChamCong(
    val nhanvienID: ObjectId, // ID nhân viên
    val hoten: String,
    val phongban:String,
    val ngay: Date,
    val trangthai: String,
)

