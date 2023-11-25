package com.example.appquanlynhansu.Activity.QuanLy

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.appquanlynhansu.R

class TrangChuQL_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trang_chu_ql)

        // Ánh xạ các nút từ layout
        val btnManageEmployees: Button = findViewById(R.id.btnManageEmployees)

        // Đăng ký sự kiện click cho các nút
        btnManageEmployees.setOnClickListener { R.id.btnManageEmployees }

        btnManageEmployees.setOnClickListener {
            val intent = Intent(this, QuanLyNhanVienQL_Activity::class.java)
            intent.putExtra("key", "value")
            startActivity(intent)
        }
    }

    }