package com.example.latihanupk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var simpan: Button
    private lateinit var hitung: Button
    private lateinit var hasile: TextView
    private lateinit var txtALAS: EditText
    private lateinit var txtTINGGI: EditText
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtALAS =  findViewById(R.id.etAlas)
        txtTINGGI =  findViewById(R.id.etTinggi)
        hitung  =  findViewById(R.id.btHitung)
        hasile  =  findViewById(R.id.tvHasil)
        recyclerView = findViewById(R.id.listdata)
        simpan = findViewById(R.id.btSimpan)

        val data = mutableListOf<DataHasil>()
        viewManager = LinearLayoutManager(this)
        recyclerAdapter = HasilAdapter(data)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = viewManager

        simpan.setOnClickListener {
            val bilanganA = txtALAS.text.toString()
            val bilanganT = txtTINGGI.text.toString()
            val hasil = hasile.text.toString()

            val dataaa = DataHasil(hasil, bilanganT, bilanganA)
            data.add(dataaa)
            recyclerAdapter.notifyDataSetChanged()

        }
        hitung.setOnClickListener {
            val Alas = txtALAS.text.toString().trim()
            val Tinggi = txtTINGGI.text.toString().trim()

            var isEmptyFields = false
            when{
                Alas.isEmpty()->{
                    isEmptyFields = true
                    txtALAS.error = "Alas Tidak Boleh Kosong"
                }
                Tinggi.isEmpty()->{
                    isEmptyFields = true
                    txtTINGGI.error = "Tinggi Tidak Boleh Kosong"
                }
            }
            if (!isEmptyFields){
                val hasil = 0.5 * Alas.toDouble() * Tinggi.toDouble()
                hasile.text = hasil.toString()+"CM"}
        }
    }
}