package com.example.appquanlynhansu.Activity.QuanLy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appquanlynhansu.Adapter.QuanLy.ChamCongQLAdapter
import com.example.appquanlynhansu.Model.ChamCong
import com.example.appquanlynhansu.Model.LichSuChamCong
import com.example.appquanlynhansu.R
import org.bson.types.ObjectId
import java.text.SimpleDateFormat

class QuanLyChamCongQL_Activity : AppCompatActivity(), ChamCongQLAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var chamCongAdapter: ChamCongQLAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quan_ly_cham_cong_ql)

        recyclerView = findViewById(R.id.recyclerView_qlccql_qlcc)

        // Tạo danh sách mẫu lịch sử chấm công
        val lichSuChamCongList = getSampleLichSuChamCongList()

        chamCongAdapter = ChamCongQLAdapter(lichSuChamCongList.flatMap { it.danhSachChamCong }, this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = chamCongAdapter
    }

    private fun getSampleLichSuChamCongList(): List<LichSuChamCong> {
        val lichSuChamCongList = mutableListOf<LichSuChamCong>()
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        val nhanVienID = ObjectId()

        // Tạo một số lịch sử chấm công mẫu
        val chamCongList1 = listOf(
            ChamCong(nhanVienID , "Nguyễn Tất Đức", "Phòng MKT", dateFormat.parse("27/11/2023"), "Đi Làm"),
            ChamCong(nhanVienID, "Nguyễn Tất Đức 1", "Phòng MKT", dateFormat.parse("28/11/2023"), "Đi Làm"),
            //Thêm các bản ghi chấm công khác nếu cần
        )
        lichSuChamCongList.add(LichSuChamCong(ObjectId(), chamCongList1))

        val chamCongList2 = listOf(
            ChamCong(ObjectId(), "Đức 2", "Phòng Sale", dateFormat.parse("25/11/2023"), "Nghỉ phép"),
            ChamCong(ObjectId(), "Đức 3", "Phòng Kế Toán", dateFormat.parse("26/11/2023"), "Đi Làm"),
            ChamCong(ObjectId(), "Đức 4", "Phòng MKT", dateFormat.parse("25/11/2023"), "Nghỉ phép"),
            // Thêm các bản ghi chấm công khác nếu cần
        )
        lichSuChamCongList.add(LichSuChamCong(ObjectId(), chamCongList2))

        // Thêm các lịch sử chấm công khác nếu cần

        return lichSuChamCongList
    }

    override fun onItemClick(chamCong: ChamCong) {
        // Xử lý sự kiện khi nút "Xem chi tiết" được nhấn
        // Trong ví dụ này, chúng ta chuyển đến màn hình chi tiết chấm công
        val intent = Intent(this, ChiTietChamCongQL_Activity::class.java)

        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        val ngayString = dateFormat.format(chamCong.ngay)

        intent.putExtra("TEN_NHANVIEN", chamCong.hoten)
        intent.putExtra("PHONG_BAN", chamCong.phongban)
        intent.putExtra("NGAY", ngayString)
        intent.putExtra("TRANG_THAI", chamCong.trangthai)

        startActivity(intent)
    }
}
