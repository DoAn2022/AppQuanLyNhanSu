package com.example.appquanlynhansu.Activity.QuanLy

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appquanlynhansu.R
import java.util.Calendar

class ChiTietLuongQL_Activity : AppCompatActivity() {

    private lateinit var edtTenNhanVien: EditText
    private lateinit var edtPhongBan: EditText
    private lateinit var btnChonThang: Button
    private lateinit var edtLuongCoBan: EditText
    private lateinit var edtThuong: EditText
    private lateinit var edtTongLuong: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_luong_ql)

        edtTenNhanVien = findViewById(R.id.edt_ctl_TenNhanVien)
        edtPhongBan = findViewById(R.id.edt_ctl_PhongBan)
        btnChonThang = findViewById(R.id.btn_ctl_ChonThang)
        edtLuongCoBan = findViewById(R.id.edt_ctl_LuongCoBan)
        edtThuong = findViewById(R.id.edt_ctl_Thuong)
        edtTongLuong = findViewById(R.id.edt_ctl_TongLuong)

        btnChonThang.setOnClickListener {
            showDatePickerDialog()
        }

        // Lấy dữ liệu từ Intent
        val tenNhanVien = intent.getStringExtra("TEN_NHANVIEN")
        val phongBan = intent.getStringExtra("PHONG_BAN")

        val luongCoBan = intent.getStringExtra("LUONG CO BAN")
        val thuong = intent.getStringExtra("THUONG")
        val tongLuong = intent.getStringExtra("TONG LUONG")

        // Hiển thị dữ liệu trong EditText
        edtTenNhanVien.setText(tenNhanVien)
        edtPhongBan.setText(phongBan)

        edtLuongCoBan.setText(luongCoBan)
        edtThuong.setText(thuong)
        edtTongLuong.setText(tongLuong)

        // Không cho chỉnh sửa
        edtTenNhanVien.isEnabled = false
        edtPhongBan.isEnabled = false

        edtLuongCoBan.isEnabled = false
        edtThuong.isEnabled = false
        edtTongLuong.isEnabled = false
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val currentYear = calendar.get(Calendar.YEAR)
        val currentMonth = calendar.get(Calendar.MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, _ ->
                val selectedMonthYear = "${selectedMonth + 1}/$selectedYear"
                Toast.makeText(this, "Đã chọn tháng: $selectedMonthYear", Toast.LENGTH_SHORT).show()
                btnChonThang.text = selectedMonthYear
            },
            currentYear,
            currentMonth,
            1
        )

        datePickerDialog.show()
    }
}
