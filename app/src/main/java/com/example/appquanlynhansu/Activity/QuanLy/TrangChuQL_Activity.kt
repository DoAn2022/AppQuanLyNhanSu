package com.example.appquanlynhansu.Activity.QuanLy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.appquanlynhansu.MainActivity
import com.example.appquanlynhansu.R

class TrangChuQL_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trang_chu_ql)

        // Ánh xạ các nút từ layout
        val btn_tcql_qlnv: Button = findViewById(R.id.btn_tcql_qlnv)
        val btn_tcql_qlcc: Button = findViewById(R.id.btn_tcql_qlcc)
        val btn_tcql_qll: Button = findViewById(R.id.btn_tcql_qll)
        val btn_tcql_dx: Button = findViewById(R.id.btn_tcql_dx)

        // Đăng ký sự kiện click cho các nút
        btn_tcql_qlnv.setOnClickListener { R.id.btn_tcql_qlnv }
        btn_tcql_qlcc.setOnClickListener { R.id.btn_tcql_qlcc }
        btn_tcql_qll.setOnClickListener {R.id.btn_tcql_qll  }
        btn_tcql_dx.setOnClickListener { R.id.btn_tcql_dx }


        btn_tcql_qlnv.setOnClickListener {
            val intent = Intent(this, QuanLyNhanVienQL_Activity::class.java)
            intent.putExtra("key", "value")
            startActivity(intent)
        }
        btn_tcql_qlcc.setOnClickListener {
            val intent = Intent(this,QuanLyChamCongQL_Activity::class.java)
            intent.putExtra("key","value")
            startActivity(intent)
        }
        btn_tcql_qll.setOnClickListener {
            val intent = Intent(this,QuanLyLuongQL_Activity::class.java)
            intent.putExtra("key", "value")
            startActivity(intent)
        }
        btn_tcql_dx.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("key", "value")
            startActivity(intent)
        }
    }

    }