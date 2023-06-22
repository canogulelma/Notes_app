package com.example.notlaruygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager


class MainActivity : AppCompatActivity() {
    private lateinit var notlarListe : ArrayList<Notlar>
    private lateinit var adapter : NotlarAdapter
    private lateinit var vt : VeritabaniYardimcisi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.title = "Notlar Uygulaması"
        toolbar.subtitle = "Ortalama : 60 "
        setSupportActionBar(toolbar)
        val rv = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.rv)
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)

        vt = VeritabaniYardimcisi(this)

        notlarListe = Notlardao().tumNotlar(vt)

        adapter = NotlarAdapter(this,notlarListe)

        rv.adapter = adapter

        var toplam = 0

        for (n in notlarListe){
            toplam = toplam + (n.not1 + n.not2) / 2
        }
        if (toplam != 0){
            toolbar.subtitle = "Ortalama : ${toplam / notlarListe.size}"
        }


        val fab = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
           startActivity(Intent(this@MainActivity,NotKayitActivity::class.java))



        }

    }

    override fun onBackPressed() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}