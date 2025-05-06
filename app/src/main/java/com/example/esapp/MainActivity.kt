package com.example.esapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val itemList = listOf(
            ItemList("Selasa", "Pemrograman Berorientasi Objek 2", R.drawable.img1),
            ItemList("Selasa", "Jaringan Komputer 2", R.drawable.img2),
            ItemList("Rabu", "Pemrograman Mobile 1", R.drawable.img3),
            ItemList("Kamis", "Digital Preneurship", R.drawable.img4),
            ItemList("Kamis", "Teknik Kompilasi", R.drawable.img5),
            ItemList("Jumat", "Objek Oriented Analisys Design", R.drawable.img6),
            ItemList("Jumat", "Keamanan Komputer", R.drawable.img7)
        )

        val adapter = AdapterList(itemList)
        recyclerView.adapter = adapter
    }
}
