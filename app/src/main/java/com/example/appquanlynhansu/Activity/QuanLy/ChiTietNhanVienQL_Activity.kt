package com.example.appquanlynhansu.Activity.QuanLy

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.appquanlynhansu.R
import java.text.SimpleDateFormat

class ChiTietNhanVienQL_Activity : AppCompatActivity() {
    private lateinit var edtTenNhanVien: EditText
    private lateinit var edtNgaySinh: EditText
    private lateinit var edtPhongBan: EditText
    private lateinit var edtChucVu: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtSdt: EditText
    private lateinit var edtDiaChi: EditText
    private lateinit var edtLuong: EditText
    private lateinit var btnSua: Button
    private lateinit var btnLuu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_nhan_vien_ql)

        // Ánh xạ EditText
        edtTenNhanVien = findViewById(R.id.edt_ctnv_TenNhanVien)
        edtNgaySinh = findViewById(R.id.edt_ctnv_NgaySinh)
        edtPhongBan = findViewById(R.id.edt_ctnv_PhongBan)
        edtChucVu = findViewById(R.id.edt_ctnv_ChucVu)
        edtEmail = findViewById(R.id.edt_ctnv_Email)
        edtSdt = findViewById(R.id.edt_ctnv_Sdt)
        edtDiaChi = findViewById(R.id.edt_ctnv_DiaChi)
        edtLuong = findViewById(R.id.edt_ctnv_Luong)

        btnSua = findViewById(R.id.btnSua)
        btnLuu = findViewById(R.id.btnLuu)
        // Lấy dữ liệu từ Intent
        val tenNhanVien = intent.getStringExtra("TEN_NHANVIEN")
        val ngaySinhString = intent.getStringExtra("NGAYSINH")
        val phongBan = intent.getStringExtra("PHONG_BAN")
        val chucVu = intent.getStringExtra("CHUC_VU")
        val email = intent.getStringExtra("EMAIL")
        val sdt = intent.getStringExtra("SDT")
        val diaChi = intent.getStringExtra("DIA_CHI")
        val luong = intent.getLongExtra("LUONG", 0)

        // Chuyển đổi chuỗi ngày sinh thành đối tượng Date
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        val ngaySinhDate = dateFormat.parse(ngaySinhString)

        // Hiển thị dữ liệu trong EditText
        edtTenNhanVien.setText(tenNhanVien)
        edtNgaySinh.setText(dateFormat.format(ngaySinhDate))
        edtPhongBan.setText(phongBan)
        edtChucVu.setText(chucVu)
        edtEmail.setText(email)
        edtSdt.setText(sdt)
        edtDiaChi.setText(diaChi)
        edtLuong.setText(luong.toString())

        // Ẩn nút Lưu ban đầu
        btnLuu.visibility = View.GONE

        // Bắt sự kiện khi nhấn nút Sửa
        btnSua.setOnClickListener {
            enableEditing(true)
        }

        // Bắt sự kiện khi nhấn nút Lưu
        btnLuu.setOnClickListener {
            saveData()
            enableEditing(false)
        }

        // Disable tất cả các EditText ban đầu
        enableEditing(false)
    }

    private fun enableEditing(enable: Boolean) {
        // Khi ấn nút Sửa, hiển thị EditText và ẩn nút Sửa, hiển thị nút Lưu
        if (enable) {
            edtTenNhanVien.isEnabled = true
            edtNgaySinh.isEnabled = true
            edtPhongBan.isEnabled = true
            edtChucVu.isEnabled = true
            edtEmail.isEnabled = true
            edtSdt.isEnabled = true
            edtDiaChi.isEnabled = true
            edtLuong.isEnabled = true

            btnSua.visibility = View.GONE
            btnLuu.visibility = View.VISIBLE
        } else {
            // Khi ấn nút Lưu, ẩn EditText và hiển thị nút Sửa, ẩn nút Lưu
            edtTenNhanVien.isEnabled = false
            edtNgaySinh.isEnabled = false
            edtPhongBan.isEnabled = false
            edtChucVu.isEnabled = false
            edtEmail.isEnabled = false
            edtSdt.isEnabled = false
            edtDiaChi.isEnabled = false
            edtLuong.isEnabled = false

            btnSua.visibility = View.VISIBLE
            btnLuu.visibility = View.GONE
        }
    }

    private fun saveData() {
        // Lưu dữ liệu sau khi chỉnh sửa vào cơ sở dữ liệu
        // vidu hiển thị một Log để minh họa
        val tenNhanVien = edtTenNhanVien.text.toString()
        val ngaySinh = edtNgaySinh.text.toString()
        val phongBan = edtPhongBan.text.toString()
        val chucVu = edtChucVu.text.toString()
        val email = edtEmail.text.toString()
        val sdt = edtSdt.text.toString()
        val diaChi = edtDiaChi.text.toString()
        val luong = edtLuong.text.toString()

        // thực hiện lưu dữ liệu vào cơ sở dữ liệu
        //  ví dụ này,  hiển thị Log
        Log.d("ChiTietNhanVienQL", "Dữ liệu đã được lưu: $tenNhanVien, $ngaySinh, $phongBan, $chucVu, $email, $sdt, $diaChi, $luong")
    }
}