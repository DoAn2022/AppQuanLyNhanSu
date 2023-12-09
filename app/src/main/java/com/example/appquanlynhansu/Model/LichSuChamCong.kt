package com.example.appquanlynhansu.Model

import org.bson.types.ObjectId

data class LichSuChamCong(
    val nhanVienID: ObjectId,
    val danhSachChamCong: List<ChamCong>
)
