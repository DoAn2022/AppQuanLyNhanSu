package com.example.appquanlynhansu.Activity.NhanVien

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appquanlynhansu.R
import java.util.Calendar

class LuongNV_Activity : AppCompatActivity() {

    private lateinit var edtTenNhanVien: EditText
    private lateinit var edtPhongBan: EditText
    private lateinit var btnChonThang: Button
    private lateinit var edtLuongCoBan: EditText
    private lateinit var edtThuong: EditText
    private lateinit var edtTongLuong: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_luong_nv)

        edtTenNhanVien = findViewById(R.id.edt_lnv_TenNhanVien)
        edtPhongBan = findViewById(R.id.edt_lnv_PhongBan)
        btnChonThang = findViewById(R.id.btn_lnv_ChonThang)
        edtLuongCoBan = findViewById(R.id.edt_lnv_LuongCoBan)
        edtThuong = findViewById(R.id.edt_lnv_Thuong)
        edtTongLuong = findViewById(R.id.edt_lnv_TongLuong)

        btnChonThang.setOnClickListener {
            showDatePickerDialog()
        }
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
