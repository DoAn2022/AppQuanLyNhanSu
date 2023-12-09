package com.example.appquanlynhansu.Activity.QuanLy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appquanlynhansu.Adapter.QuanLy.LuongQLAdapter
import com.example.appquanlynhansu.Model.Luong
import com.example.appquanlynhansu.R

class QuanLyLuongQL_Activity : AppCompatActivity(), LuongQLAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var luongAdapter: LuongQLAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quan_ly_luong_ql)

        recyclerView = findViewById(R.id.recyclerViewluongql)
        luongAdapter = LuongQLAdapter(getSampleLuongList(), this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = luongAdapter
    }

    private fun getSampleLuongList(): List<Luong> {
        val luongList = mutableListOf<Luong>()

        // Thêm mẫu dữ liệu lương
        luongList.add(Luong("Nguyễn Tất Đức", "Phòng MKT", 12,20000000,10000000, 30000000))

        // Thêm các bản ghi lương khác nếu cần

        return luongList
    }

    override fun onItemClick(luong: Luong) {
        // Xử lý sự kiện khi nút "Xem chi tiết" được nhấn
        // Trong ví dụ này, chúng ta chuyển đến màn hình chi tiết lương
        val intent = Intent(this, ChiTietLuongQL_Activity::class.java)
        intent.putExtra("TEN_NHANVIEN", luong.hoten)
        intent.putExtra("PHONG_BAN", luong.phongban)
        intent.putExtra("THANG", luong.thang)
        intent.putExtra("LUONG CO BAN", luong.luongcoban)
        intent.putExtra("THUONG", luong.thuong)
        intent.putExtra("TONG LUONG", luong.tongluong)

        startActivity(intent)
    }
}

