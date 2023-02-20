package com.example.latihanupk


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HasilAdapter(private val dataSet: MutableList<DataHasil>):
    RecyclerView.Adapter<HasilAdapter.HasilHolder>() {
    class HasilHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bilalas = view.findViewById<TextView>(R.id.bilAlas)
        val biltinggi = view.findViewById<TextView>(R.id.bilTinggi)
        val bilhasil = view.findViewById<TextView>(R.id.THasil)
        val ivhps = view.findViewById<ImageView>(R.id.ivHps)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HasilHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_hasil_adapter, parent, false
        )
        return HasilHolder(view)
    }

    override fun onBindViewHolder(holder: HasilHolder, position: Int) {
        holder.bilalas.text = dataSet[position].alas
        holder.biltinggi.text = dataSet[position].tinggi
        holder.bilhasil.text = dataSet[position].hasil
        holder.ivhps.setOnClickListener {
            dataSet.removeAt(position)
            notifyItemRangeRemoved(position, dataSet.size)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}
