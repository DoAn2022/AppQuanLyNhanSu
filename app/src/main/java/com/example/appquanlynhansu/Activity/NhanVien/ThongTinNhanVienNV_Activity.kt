package com.example.appquanlynhansu.Activity.NhanVien

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appquanlynhansu.Model.NhanVien
import com.example.appquanlynhansu.R

class ThongTinNhanVienNV_Activity : AppCompatActivity(), View.OnClickListener {

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
        setContentView(R.layout.activity_thong_tin_nhan_vien_nv)

        // Ánh xạ các thành phần từ layout
        edtTenNhanVien = findViewById(R.id.edt_ttnv_TenNhanVien)
        edtNgaySinh = findViewById(R.id.edt_ttnv_NgaySinh)
        edtPhongBan = findViewById(R.id.edt_ttnv_PhongBan)
        edtChucVu = findViewById(R.id.edt_ttnv_ChucVu)
        edtEmail = findViewById(R.id.edt_ttnv_Email)
        edtSdt = findViewById(R.id.edt_ttnv_Sdt)
        edtDiaChi = findViewById(R.id.edt_ttnv_DiaChi)
        edtLuong = findViewById(R.id.edt_ttnv_Luong)
        btnSua = findViewById(R.id.btn_ttnv_Sua)
        btnLuu = findViewById(R.id.btn_ttnv_Luu)

        // Đăng ký sự kiện click cho các button
        btnSua.setOnClickListener(this)
        btnLuu.setOnClickListener(this)

        // Lấy dữ liệu từ Intent
        val tenNhanVien = intent.getStringExtra("TEN_NHANVIEN")
        val ngaySinh = intent.getStringExtra("NGAY_SINH")
        val phongBan = intent.getStringExtra("PHONG_BAN")
        val chucVu = intent.getStringExtra("CHUC_VU")
        val email = intent.getStringExtra("EMAIL")
        val sdt = intent.getStringExtra("SDT")
        val diaChi = intent.getStringExtra("DIA_CHI")
        val luong = intent.getStringExtra("LUONG")

        // Hiển thị dữ liệu lên EditText
        edtTenNhanVien.setText(tenNhanVien)
        edtNgaySinh.setText(ngaySinh)
        edtPhongBan.setText(phongBan)
        edtChucVu.setText(chucVu)
        edtEmail.setText(email)
        edtSdt.setText(sdt)
        edtDiaChi.setText(diaChi)
        edtLuong.setText(luong)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_ttnv_Sua -> {
                // Cho phép chỉnh sửa thông tin
                enableEditing(true)
            }
            R.id.btn_ttnv_Luu -> {
                // Lưu thông tin đã chỉnh sửa
                luuThongTin()
            }
        }
    }

    private fun enableEditing(enable: Boolean) {
        edtTenNhanVien.isEnabled = enable
        edtNgaySinh.isEnabled = enable
        edtPhongBan.isEnabled = enable
        edtChucVu.isEnabled = enable
        edtEmail.isEnabled = enable
        edtSdt.isEnabled = enable
        edtDiaChi.isEnabled = enable
        edtLuong.isEnabled = enable

        btnSua.isEnabled = !enable
        btnLuu.isEnabled = enable
    }

    private fun luuThongTin() {
        // Lưu thông tin đã chỉnh sửa (chưa xử lý lưu vào database)
        Toast.makeText(this, "Lưu thông tin thành công", Toast.LENGTH_SHORT).show()

        // Tắt chế độ chỉnh sửa
        enableEditing(false)
    }
}
