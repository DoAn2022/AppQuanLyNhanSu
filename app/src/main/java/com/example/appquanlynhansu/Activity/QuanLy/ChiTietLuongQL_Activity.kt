package com.example.appquanlynhansu.Activity.QuanLy

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.appquanlynhansu.R

class ChiTietLuongQL_Activity : AppCompatActivity() {

    private lateinit var edtTenNhanVien: EditText
    private lateinit var edtPhongBan: EditText
    private lateinit var edtThang: EditText
    private lateinit var edtLuongCoBan: EditText
    private lateinit var edtThuong: EditText
    private lateinit var edtTongLuong: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_luong_ql)

        edtTenNhanVien = findViewById(R.id.edt_ctl_TenNhanVien)
        edtPhongBan = findViewById(R.id.edt_ctl_PhongBan)
        edtThang = findViewById(R.id.edt_ctl_Thang)
        edtLuongCoBan = findViewById(R.id.edt_ctl_LuongCoBan)
        edtThuong = findViewById(R.id.edt_ctl_Thuong)
        edtTongLuong = findViewById(R.id.edt_ctl_TongLuong)

        // Lấy dữ liệu từ Intent
        val tenNhanVien = intent.getStringExtra("TEN_NHANVIEN")
        val phongBan = intent.getStringExtra("PHONG_BAN")
        val thang = intent.getStringExtra("THANG")
        val luongCoBan = intent.getStringExtra("LUONG CO BAN")
        val thuong = intent.getStringExtra("THUONG")
        val tongLuong = intent.getStringExtra("TONG LUONG")

        // Hiển thị dữ liệu trong EditText
        edtTenNhanVien.setText(tenNhanVien)
        edtPhongBan.setText(phongBan)
        edtThang.setText(thang)
        edtLuongCoBan.setText(luongCoBan)
        edtThuong.setText(thuong)
        edtTongLuong.setText(tongLuong)

        // Không cho chỉnh sửa
        edtTenNhanVien.isEnabled = false
        edtPhongBan.isEnabled = false
        edtThang.isEnabled = false
        edtLuongCoBan.isEnabled = false
        edtThuong.isEnabled = false
        edtTongLuong.isEnabled = false
    }
}
