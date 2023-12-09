package com.example.appquanlynhansu.Adapter.QuanLy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appquanlynhansu.Model.NhanVien
import com.example.appquanlynhansu.R

class NhanVienQLAdapter(
    private val nhanVienList: List<NhanVien>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<NhanVienQLAdapter.NhanVienViewHolder>() {

    interface OnItemClickListener {

        fun onItemClick(nhanVien: NhanVien)
        fun onXoaClick(nhanVien: NhanVien)
    }

    inner class NhanVienViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tenNhanVien: TextView = itemView.findViewById(R.id.text_itemnvql_TenNhanVien)
        val phongBan: TextView = itemView.findViewById(R.id.text_itemnvql_PhongBan)
        val buttonXem: Button = itemView.findViewById(R.id.btn_itemnvql_Xem)
        val buttonXoa: Button = itemView.findViewById(R.id.btn_itemnvql_Xoa)

        init {
            buttonXem.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(nhanVienList[position])
                }
            }

            buttonXoa.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onXoaClick(nhanVienList[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NhanVienViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_nhanvien_ql, parent, false)
        return NhanVienViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NhanVienViewHolder, position: Int) {
        val currentItem = nhanVienList[position]

        holder.tenNhanVien.text = currentItem.hoten
        holder.phongBan.text = currentItem.phongban
    }

    override fun getItemCount() = nhanVienList.size
}
