package com.example.appquanlynhansu.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.appquanlynhansu.Activity.NhanVien.TrangChuNv_Activity
import com.example.appquanlynhansu.Activity.QuanLy.TrangChuQL_Activity
import com.example.appquanlynhansu.R

class DangNhap_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dang_nhap)

        // Ánh xạ các nút từ layout
        val Btn_dangnhap: Button = findViewById(R.id.Btn_dangnhap)


        // Đăng ký sự kiện click cho các nút
        Btn_dangnhap.setOnClickListener{R.id.Btn_dangnhap}


        Btn_dangnhap.setOnClickListener {
            val intent = Intent(this, TrangChuQL_Activity::class.java)
            intent.putExtra("key", "value")
            startActivity(intent)
        }

    }
}