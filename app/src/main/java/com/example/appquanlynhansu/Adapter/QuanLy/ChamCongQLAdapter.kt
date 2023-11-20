package com.example.appquanlynhansu.Adapter.QuanLy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appquanlynhansu.Model.ChamCong
import com.example.appquanlynhansu.R
import java.text.SimpleDateFormat
import java.util.Locale

class ChamCongQLAdapter(private val chamCongList: List<ChamCong>) :
    RecyclerView.Adapter<ChamCongQLAdapter.ChamCongViewHolder>() {

    class ChamCongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ngayTextView: TextView = itemView.findViewById(R.id.textngay)
        val trangThaiTextView: TextView = itemView.findViewById(R.id.texttrangthai)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChamCongViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chamcong_ql, parent, false)
        return ChamCongViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChamCongViewHolder, position: Int) {
        val chamCong = chamCongList[position]

        holder.ngayTextView.text = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(chamCong.ngay)
        holder.trangThaiTextView.text = chamCong.trangthai
    }

    override fun getItemCount(): Int {
        return chamCongList.size
    }
}