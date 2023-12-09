package com.example.appquanlynhansu.Adapter.NhanVien

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appquanlynhansu.Model.ChamCong
import com.example.appquanlynhansu.R

class ChamCongNVAdapter(private val chamCongList: List<ChamCong>) :
    RecyclerView.Adapter<ChamCongNVAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textNgay: TextView = itemView.findViewById(R.id.text_item_ccnv_Ngay)
        val textTrangThai: TextView = itemView.findViewById(R.id.text_item_ccnv_TrangThai)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chamcong_nv, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chamCong = chamCongList[position]

        // Hiển thị thông tin chấm công trong item
        holder.textNgay.text = "Ngày: ${chamCong.ngay}"
        holder.textTrangThai.text = "Trạng Thái: ${chamCong.trangthai}"
    }

    override fun getItemCount(): Int {
        return chamCongList.size
    }
}


