package com.example.appquanlynhansu.Adapter.QuanLy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appquanlynhansu.Model.NhanVien
import com.example.appquanlynhansu.R

class NhanVienQLAdapter(private val nhanVienList: List<NhanVien>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<NhanVienQLAdapter.NhanVienViewHolder>() {

    interface OnItemClickListener {
        fun onXemClick(position: Int)
        fun onXoaClick(position: Int)
    }

    class NhanVienViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tenNhanVienTextView: TextView = itemView.findViewById(R.id.textTenNhanVien)
        val phongBanTextView: TextView = itemView.findViewById(R.id.textPhongBan)
        val xemButton: Button = itemView.findViewById(R.id.buttonXem)
        val xoaButton: Button = itemView.findViewById(R.id.buttonXoa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NhanVienViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_nhanvien_ql, parent, false)
        return NhanVienViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NhanVienViewHolder, position: Int) {
        val nhanVien = nhanVienList[position]

        holder.tenNhanVienTextView.text = nhanVien.hoten
        holder.phongBanTextView.text = nhanVien.phongban

        // Sự kiện khi nút "Xem" được nhấn
        holder.xemButton.setOnClickListener {
            listener.onXemClick(position)
        }

        // Sự kiện khi nút "Xóa" được nhấn
        holder.xoaButton.setOnClickListener {
            listener.onXoaClick(position)
        }
    }

    override fun getItemCount(): Int {
        return nhanVienList.size
    }

    fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }
}
