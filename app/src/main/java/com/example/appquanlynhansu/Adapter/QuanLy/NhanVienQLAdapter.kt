package com.example.appquanlynhansu.Adapter.QuanLy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appquanlynhansu.Model.NhanVien
import com.example.appquanlynhansu.R

class NhanVienQLAdapter(private val nhanVienList: List<NhanVien>) :
    RecyclerView.Adapter<NhanVienQLAdapter.NhanVienViewHolder>() {

    class NhanVienViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hoTenTextView: TextView = itemView.findViewById(R.id.textHoTen)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NhanVienViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_nhanvien_ql, parent, false)
        return NhanVienViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NhanVienViewHolder, position: Int) {
        val nhanVien = nhanVienList[position]

        holder.hoTenTextView.text = nhanVien.hoten

    }

    override fun getItemCount(): Int {
        return nhanVienList.size
    }
}