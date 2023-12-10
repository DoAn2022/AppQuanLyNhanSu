package com.example.appquanlynhansu.Activity.NhanVien

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.appquanlynhansu.MainActivity
import com.example.appquanlynhansu.R

class TrangChuNV_Activity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trang_chu_nv)

        // Khởi tạo các button
        val btnThongTinNv = findViewById<Button>(R.id.btn_tcnv_ttnv)
        val btnChamCong = findViewById<Button>(R.id.btn_tcnv_cc)
        val btnLuong = findViewById<Button>(R.id.btn_tcnv_luong)
        val btnDangXuat = findViewById<Button>(R.id.btn_tcnv_dx)

        // Đăng ký sự kiện click cho các button
        btnThongTinNv.setOnClickListener(this)
        btnChamCong.setOnClickListener(this)
        btnLuong.setOnClickListener(this)
        btnDangXuat.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_tcnv_ttnv -> {
                // Chuyển đến màn hình Thông Tin Nhân Viên
                startActivity(Intent(this, ThongTinNhanVienNV_Activity::class.java))
            }
            R.id.btn_tcnv_cc -> {
                // Chuyển đến màn hình Chấm Công
                startActivity(Intent(this, ChamCongNV_Activity::class.java))
            }
            R.id.btn_tcnv_luong -> {
                // Chuyển đến màn hình Lương
                startActivity(Intent(this, LuongNV_Activity::class.java))
            }
            R.id.btn_tcnv_dx -> {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }
}
