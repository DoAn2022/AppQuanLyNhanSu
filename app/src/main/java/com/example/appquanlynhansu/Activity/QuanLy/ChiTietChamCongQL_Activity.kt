package com.example.appquanlynhansu.Activity.QuanLy

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appquanlynhansu.Adapter.QuanLy.QuanLyChamCongQLAdapter
import com.example.appquanlynhansu.Model.ChamCong
import com.example.appquanlynhansu.R
import org.bson.types.ObjectId
import java.text.SimpleDateFormat
import java.util.*

class ChiTietChamCongQL_Activity : AppCompatActivity() {

    private lateinit var edtTenNhanVien: EditText
    private lateinit var edtPhongBan: EditText
    private lateinit var edtTongSoNgay: EditText
    private lateinit var recyclerView: RecyclerView
    private lateinit var chamCongAdapter: QuanLyChamCongQLAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cham_cong_ql)

        edtTenNhanVien = findViewById(R.id.edt_ctcc_TenNhanVien)
        edtPhongBan = findViewById(R.id.edt_ctcc_PhongBan)
        edtTongSoNgay = findViewById(R.id.edt_ctcc_TongSoNgay)
        recyclerView = findViewById(R.id.recyclerView_ctcc_ql)

        // Lấy dữ liệu từ Intent
        val tenNhanVien = intent.getStringExtra("TEN_NHANVIEN")
        val phongBan = intent.getStringExtra("PHONG_BAN")
        val ngay = intent.getStringExtra("NGAY")
        val trangThai = intent.getStringExtra("TRANG_THAI")

        // Hiển thị dữ liệu trong EditText
        edtTenNhanVien.setText(tenNhanVien)
        edtPhongBan.setText(phongBan)

        // Tạo danh sách chấm công mẫu
        val chamCongList = mutableListOf(
            ChamCong(ObjectId(), tenNhanVien!!, phongBan!!, SimpleDateFormat("dd/MM/yyyy").parse(ngay!!)!!, trangThai!!)
            // Thêm các bản ghi chấm công khác nếu cần
        )

        // Hiển thị tổng số ngày
        edtTongSoNgay.setText(chamCongList.size.toString())

        // Hiển thị danh sách chấm công trong RecyclerView
        chamCongAdapter = QuanLyChamCongQLAdapter(chamCongList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = chamCongAdapter
    }
}
