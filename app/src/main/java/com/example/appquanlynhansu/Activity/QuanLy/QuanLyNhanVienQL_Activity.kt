package com.example.appquanlynhansu.Activity.QuanLy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appquanlynhansu.Adapter.QuanLy.NhanVienQLAdapter
import com.example.appquanlynhansu.Model.NhanVien
import com.example.appquanlynhansu.R
import java.text.SimpleDateFormat
import java.util.Locale

class QuanLyNhanVienQL_Activity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var NhanVienQLAdapter: NhanVienQLAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quan_ly_nhan_vien_ql)

        recyclerView = findViewById(R.id.recyclerViewnhanvienql)
        NhanVienQLAdapter = NhanVienQLAdapter(getSampleNhanVienList())

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NhanVienQLAdapter
    }

    private fun getSampleNhanVienList(): List<NhanVien> {
        // Trả về một danh sách nhân viên mẫu
        val nhanVienList = mutableListOf<NhanVien>()

        // Tạo một số nhân viên mẫu
        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val ngaySinh1 = formatter.parse("01/01/1990")
        val ngaySinh2 = formatter.parse("15/05/1985")
        val ngaySinh3 = formatter.parse("20/10/1995")

        nhanVienList.add(NhanVien("Nguyen Van A", ngaySinh1, "Phòng A", "Chức vụ A", "a@gmail.com", "123456789", "Địa chỉ A", 50000.0))
        nhanVienList.add(NhanVien("Tran Thi B", ngaySinh2, "Phòng B", "Chức vụ B", "b@gmail.com", "987654321", "Địa chỉ B", 60000.0))
        nhanVienList.add(NhanVien("Le Van C", ngaySinh3, "Phòng C", "Chức vụ C", "c@gmail.com", "111222333", "Địa chỉ C", 70000.0))

        return nhanVienList
    }
}



