package com.example.appquanlynhansu.Activity.NhanVien

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appquanlynhansu.Adapter.NhanVien.ChamCongNVAdapter
import com.example.appquanlynhansu.Model.ChamCong
import com.example.appquanlynhansu.R
import org.bson.types.ObjectId
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class ChamCongNV_Activity : AppCompatActivity() {

    private lateinit var textTenNhanVien: TextView
    private lateinit var btnChonNgay: Button
    private lateinit var btnChamCong: Button
    private lateinit var recyclerViewChamCong: RecyclerView
    private lateinit var chamCongNVAdapter: ChamCongNVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cham_cong_nv)

        textTenNhanVien = findViewById(R.id.text_ccnv_TenNhanVien)
        btnChonNgay = findViewById(R.id.btn_ccnv_ChonNgay)
        btnChamCong = findViewById(R.id.btn_chamcongnv_ChamCong)
        recyclerViewChamCong = findViewById(R.id.recyclerView_ccnv_nv)

        // Lấy dữ liệu từ Intent (thay thế bằng dữ liệu thực tế)
        val tenNhanVien = "Tên Nhân Viên Mẫu"
        textTenNhanVien.text = "Tên Nhân Viên: $tenNhanVien"

        // Thay thế bằng hàm lấy danh sách chấm công thực tế
        val chamCongList = getSampleChamCongList()

        // Khởi tạo adapter và set cho RecyclerView
        chamCongNVAdapter = ChamCongNVAdapter(chamCongList)
        recyclerViewChamCong.layoutManager = LinearLayoutManager(this)
        recyclerViewChamCong.adapter = chamCongNVAdapter

        // Bắt sự kiện click cho nút Chọn Ngày
        btnChonNgay.setOnClickListener {
            showDatePickerDialog()
        }

        // Bắt sự kiện click cho nút Chấm Công
        btnChamCong.setOnClickListener {
            // Xử lý sự kiện chấm công ở đây
        }
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val currentYear = calendar.get(Calendar.YEAR)
        val currentMonth = calendar.get(Calendar.MONTH)
        val currentDay = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, month, dayOfMonth)

                // Hiển thị ngày đã chọn
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val formattedDate = dateFormat.format(selectedDate.time)

                // Hiển thị ngày đã chọn trong Toast (có thể thay đổi thành xử lý khác)
                Toast.makeText(this, "Đã chọn ngày: $formattedDate", Toast.LENGTH_SHORT).show()
            },
            currentYear,
            currentMonth,
            currentDay
        )

        // Hiển thị DatePickerDialog
        datePickerDialog.show()
    }

    private fun getSampleChamCongList(): List<ChamCong> {
        val chamCongList = mutableListOf<ChamCong>()

        // Thêm mẫu dữ liệu chấm công
        chamCongList.add(ChamCong(ObjectId(), "NTD", "MKT", Date(), "Có"))

        // Thêm các bản ghi chấm công khác nếu cần

        return chamCongList
    }
}
