package com.example.appquanlynhansu.Activity.QuanLy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appquanlynhansu.Adapter.QuanLy.NhanVienQLAdapter
import com.example.appquanlynhansu.Model.NhanVien
import com.example.appquanlynhansu.R
import java.text.SimpleDateFormat
import java.util.Date

class QuanLyNhanVienQL_Activity : AppCompatActivity(), NhanVienQLAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var nhanVienAdapter: NhanVienQLAdapter




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quan_ly_nhan_vien_ql)

        recyclerView = findViewById(R.id.recyclerView_qlnvql_nhanvienql)
        nhanVienAdapter = NhanVienQLAdapter(getSampleNhanVienList(), this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = nhanVienAdapter
    }

    private fun getSampleNhanVienList(): List<NhanVien> {
        val nhanVienList = mutableListOf<NhanVien>()

        val dateFormat = SimpleDateFormat("dd/MM/yyyy")

        // Tạo một số bảng nhân viên mẫu
        nhanVienList.add(
            NhanVien(
                "Nguyễn Tất Đức",
                dateFormat.parse("01/01/2001"),
                "Phòng MKT",
                " Quản Lý",
                "fcboy37@gmail.com",
                "0339855968",
                "TS-DL-NA",
                30000000
            )
        )
        nhanVienList.add(
            NhanVien(
                "Đức 2",
                dateFormat.parse("01/01/1290"),
                "Sale",
                "Nhân Viên",
                "fcboy37@gmail.com",
                "123456789",
                "Dia Chi TSDLNA",
                10000000
            )
        )
        nhanVienList.add(
            NhanVien(
                "Đức 3",
                dateFormat.parse("13/01/1290"),
                "Kế Toán",
                "Nhân Viên",
                "fcboy37@gmail.com",
                "123456789",
                "Dia Chi TSDLNA",
                15000000
            )
        )
        nhanVienList.add(
            NhanVien(
                "Đức 4",
                dateFormat.parse("13/01/1290"),
                "MKT",
                "Nhân Viên",
                "fcboy37@gmail.com",
                "123456789",
                "Dia Chi TSDLNA",
                15000000
            )
        )
        nhanVienList.add(
            NhanVien(
                "Đức 5",
                dateFormat.parse("01/01/1290"),
                "Sale",
                "Nhân Viên",
                "fcboy37@gmail.com",
                "123456789",
                "Dia Chi TSDLNA",
                10000000
            )
        )
        nhanVienList.add(
            NhanVien(
                "Đức 6",
                dateFormat.parse("01/01/1290"),
                "Sale",
                "Nhân Viên",
                "fcboy37@gmail.com",
                "123456789",
                "Dia Chi TSDLNA",
                10000000
            )
        )
        nhanVienList.add(
            NhanVien(
                "Đức 7",
                dateFormat.parse("01/01/1290"),
                "Sale",
                "Nhân Viên",
                "fcboy37@gmail.com",
                "123456789",
                "Dia Chi TSDLNA",
                10000000
            )
        )

        // Các nhân viên khác

        return nhanVienList
    }

    override fun onItemClick(nhanVien: NhanVien) {

        // Xử lý sự kiện khi một nhân viên được nhấn
        // chuyển đến màn hình chi tiết nhân viên
        val intent = Intent(this, ChiTietNhanVienQL_Activity::class.java)
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        val ngaySinhString = dateFormat.format(nhanVien.ngaysinh)


        intent.putExtra("TEN_NHANVIEN", nhanVien.hoten)
        intent.putExtra("NGAYSINH",ngaySinhString)
        intent.putExtra("PHONG_BAN", nhanVien.phongban)
        intent.putExtra("CHUC_VU", nhanVien.chucvu)
        intent.putExtra("EMAIL", nhanVien.gmail)
        intent.putExtra("SDT", nhanVien.sdt)
        intent.putExtra("DIA_CHI", nhanVien.diachi)
        intent.putExtra("LUONG", nhanVien.luong)

        startActivity(intent)
    }

    override fun onXoaClick(nhanVien: NhanVien) {
        // Xử lý sự kiện khi nút "Xóa" được nhấn
        // và cập nhật RecyclerView
    }
}
