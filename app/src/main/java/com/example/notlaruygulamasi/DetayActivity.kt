package com.example.notlaruygulamasi

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar

@Suppress("DEPRECATION")
class DetayActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)
        val toolbarNotDetay = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarNotDetay)
        toolbarNotDetay.title = "Not Detay"
        setSupportActionBar(toolbarNotDetay)



        val not = intent.getSerializableExtra("nesne") as Notlar
        val editTextDers = findViewById<android.widget.EditText>(R.id.editTextDers)
        val editTextNot1 = findViewById<android.widget.EditText>(R.id.editTextNot1)
        val editTextNot2 = findViewById<android.widget.EditText>(R.id.editTextNot2)
        editTextDers.setText(not.ders_adi)
        editTextNot1.setText((not.not1).toString())
        editTextNot2.setText((not.not2).toString())


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_sil -> {
                val toolbarNotDetay = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarNotDetay)
                Snackbar.make(toolbarNotDetay,"Not Silinsin mi ?",Snackbar.LENGTH_LONG).setAction("Evet"){
                    startActivity(Intent(this@DetayActivity,MainActivity::class.java))
                    finish()
                }.show()
                //silme işlemleri
                return true
            }
            R.id.action_duzenle -> {
                startActivity(Intent(this@DetayActivity,MainActivity::class.java))
                //düzenleme işlemleri
                return true
            }
            else -> return false
        }

    }
}