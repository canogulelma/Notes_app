package com.example.notlaruygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class NotKayitActivity : AppCompatActivity() {
    private lateinit var vt : VeritabaniYardimcisi


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_not_kayit)
        vt = VeritabaniYardimcisi(this)
        val toolbarNotKayit = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarNotKayit)
        val buttonKaydet = findViewById<android.widget.Button>(R.id.buttonKaydet)
        toolbarNotKayit.title = "Not Kayıt"
        setSupportActionBar(toolbarNotKayit)

        buttonKaydet.setOnClickListener {

            val ders_adi =

            startActivity(Intent(this@NotKayitActivity,MainActivity::class.java))
            finish()

        }


    }
}