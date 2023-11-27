package com.example.appquanlynhansu.Adapter.QuanLy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appquanlynhansu.Model.ChamCong
import com.example.appquanlynhansu.R
import java.text.SimpleDateFormat
import java.util.*

class ChamCongQLAdapter(
    private val chamCongList: List<ChamCong>,
    private val listener: OnItemClickListener) :
    RecyclerView.Adapter<ChamCongQLAdapter.ChamCongViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(chamCong: ChamCong)
    }

    inner class ChamCongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tenNhanVien: TextView = itemView.findViewById(R.id.text_itemccql_TenNhanVien)
        val phongBan: TextView = itemView.findViewById(R.id.text_itemccql_PhongBan)
        val btnXem: Button = itemView.findViewById(R.id.btn_itemccql_Xem)

        init {
            btnXem.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(chamCongList[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChamCongViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_chamcong_ql, parent, false)
        return ChamCongViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChamCongViewHolder, position: Int) {
        val currentItem = chamCongList[position]
        holder.tenNhanVien.text = currentItem.hoten
        holder.phongBan.text = currentItem.phongban
    }

    override fun getItemCount() = chamCongList.size
}
