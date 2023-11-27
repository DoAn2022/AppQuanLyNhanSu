package com.example.appquanlynhansu.Adapter.QuanLy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appquanlynhansu.Model.ChamCong
import com.example.appquanlynhansu.R
import java.text.SimpleDateFormat
import java.util.*

class QuanLyChamCongQLAdapter(private val chamCongList: List<ChamCong>) :
    RecyclerView.Adapter<QuanLyChamCongQLAdapter.QuanLyChamCongViewHolder>() {

    class QuanLyChamCongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ngay: EditText = itemView.findViewById(R.id.edt_item_qlccql_Ngay)
        val trangThai: EditText = itemView.findViewById(R.id.edt_item_qlccql_TrangThai)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuanLyChamCongViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_quanlychamcong_ql, parent, false)
        return QuanLyChamCongViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: QuanLyChamCongViewHolder, position: Int) {
        val currentItem = chamCongList[position]
        holder.ngay.setText(SimpleDateFormat("dd/MM/yyyy").format(currentItem.ngay))
        holder.trangThai.setText(currentItem.trangthai)
    }

    override fun getItemCount(): Int {
        return chamCongList.size
    }
}
