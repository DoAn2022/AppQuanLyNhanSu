package com.example.appquanlynhansu.Activity.QuanLy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appquanlynhansu.Adapter.QuanLy.ChamCongQLAdapter
import com.example.appquanlynhansu.Model.ChamCong
import com.example.appquanlynhansu.R
import org.bson.types.ObjectId
import java.text.SimpleDateFormat
import java.util.Locale

class QuanLyChamCongQL_Activity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var ChamCongQLAdapter: ChamCongQLAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quan_ly_cham_cong_ql)

        recyclerView = findViewById(R.id.recyclerViewchamcongql)
        ChamCongQLAdapter = ChamCongQLAdapter(getSampleChamCongList())

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ChamCongQLAdapter
    }

    private fun getSampleChamCongList(): List<ChamCong> {
        val chamCongList = mutableListOf<ChamCong>()

        // Tạo một số chấm công mẫu
        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val ngay1 = formatter.parse("01/01/2023")
        val ngay2 = formatter.parse("15/01/2023")
        val ngay3 = formatter.parse("28/01/2023")

        chamCongList.add(ChamCong(ObjectId(), ngay1, "Đi làm"))
        chamCongList.add(ChamCong(ObjectId(), ngay2, "Nghỉ phép"))
        chamCongList.add(ChamCong(ObjectId(), ngay3, "Đi làm"))

        return chamCongList
    }
}
