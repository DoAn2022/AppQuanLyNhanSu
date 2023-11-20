package com.example.appquanlynhansu.Activity.QuanLy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appquanlynhansu.Adapter.QuanLy.LuongQLAdapter
import com.example.appquanlynhansu.Model.Luong
import com.example.appquanlynhansu.R
import org.bson.types.ObjectId

class QuanLyLuongQL_Activity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var LuongQLAdapter: LuongQLAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quan_ly_luong_ql)

        recyclerView = findViewById(R.id.recyclerViewluongql)
        LuongQLAdapter = LuongQLAdapter(getSampleLuongList())

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = LuongQLAdapter
    }

    private fun getSampleLuongList(): List<Luong> {
        val luongList = mutableListOf<Luong>()

        // Tạo một số bảng lương mẫu
        luongList.add(Luong(ObjectId(), 1.0, 5000000.0, 1000000.0, 6000000.0))
        luongList.add(Luong(ObjectId(), 2.0, 5000000.0, 800000.0, 5800000.0))
        luongList.add(Luong(ObjectId(), 3.0, 5000000.0, 1200000.0, 6200000.0))

        return luongList
    }
}
