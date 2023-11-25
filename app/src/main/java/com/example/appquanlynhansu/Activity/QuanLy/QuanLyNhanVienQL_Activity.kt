package com.example.appquanlynhansu.Activity.QuanLy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appquanlynhansu.Adapter.QuanLy.NhanVienQLAdapter
import com.example.appquanlynhansu.Model.NhanVien
import com.example.appquanlynhansu.R

class QuanLyNhanVienQL_Activity : AppCompatActivity(), NhanVienQLAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var nhanVienAdapter: NhanVienQLAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quan_ly_nhan_vien_ql)

        // Ánh xạ RecyclerView từ layout
        recyclerView = findViewById(R.id.recyclerViewnhanvienql)

        // Khởi tạo Adapter và RecyclerView
        nhanVienAdapter = NhanVienQLAdapter(getSampleNhanVienList(), this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = nhanVienAdapter
    }

    private fun getSampleNhanVienList(): List<NhanVien> {
        // Trả về danh sách nhân viên mẫu, bạn có thể thay thế với dữ liệu thực tế từ nguồn dữ liệu của bạn.
        val nhanVienList = mutableListOf<NhanVien>()

        // Thêm nhiều nhân viên khác nếu cần

        return nhanVienList
    }

    override fun onXemClick(position: Int) {
        // Xử lý sự kiện khi nút "Xem" được nhấn
        val selectedNhanVien = nhanVienAdapter.getItem(position)

        // Chuyển đến màn hình hiển thị thông tin chi tiết

    }

    override fun onXoaClick(position: Int) {
        // Xử lý sự kiện khi nút "Xóa" được nhấn
        // Bạn có thể thêm mã xử lý xóa ở đây nếu cần
    }
}
