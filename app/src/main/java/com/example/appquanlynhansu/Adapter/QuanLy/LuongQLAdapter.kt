package com.example.appquanlynhansu.Adapter.QuanLy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appquanlynhansu.Model.Luong
import com.example.appquanlynhansu.R

class LuongQLAdapter(
    private val luongList: List<Luong>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<LuongQLAdapter.LuongViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(luong: Luong)
    }

    inner class LuongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tenNhanVien: TextView = itemView.findViewById(R.id.text_itemluongql_TenNhanVien)
        val phongBan: TextView = itemView.findViewById(R.id.text_itemluongql_PhongBan)
        val btnXem: Button = itemView.findViewById(R.id.btn_itemluongql_Xem)

        init {
            btnXem.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(luongList[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LuongViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_luongql, parent, false)
        return LuongViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LuongViewHolder, position: Int) {
        val currentItem = luongList[position]
        holder.tenNhanVien.text = currentItem.hoten
        holder.phongBan.text = currentItem.phongban
    }

    override fun getItemCount() = luongList.size
}
