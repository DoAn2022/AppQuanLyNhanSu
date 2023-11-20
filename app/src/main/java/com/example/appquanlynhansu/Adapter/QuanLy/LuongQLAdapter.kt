package com.example.appquanlynhansu.Adapter.QuanLy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appquanlynhansu.Model.Luong
import com.example.appquanlynhansu.R

class LuongQLAdapter(private val luongList: List<Luong>) :
    RecyclerView.Adapter<LuongQLAdapter.LuongQLViewHolder>() {

    class LuongQLViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val thangTextView: TextView = itemView.findViewById(R.id.textThang)
        val luongCoBanTextView: TextView = itemView.findViewById(R.id.textLuongCoBan)
        val thuongTextView: TextView = itemView.findViewById(R.id.textThuong)
        val tongLuongTextView: TextView = itemView.findViewById(R.id.textTongLuong)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LuongQLViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_luongql, parent, false)
        return LuongQLViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LuongQLViewHolder, position: Int) {
        val luong = luongList[position]

        holder.thangTextView.text = luong.thang.toString()
        holder.luongCoBanTextView.text = luong.luongcoban.toString()
        holder.thuongTextView.text = luong.thuong.toString()
        holder.tongLuongTextView.text = luong.tongluong.toString()
    }

    override fun getItemCount(): Int {
        return luongList.size
    }
}
