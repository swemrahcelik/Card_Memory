package com.example.mobilproje

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class modal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modal)
    }
    fun clickhome(iew: View){
        val intent = Intent(this, GameStart::class.java)
        startActivity(intent)
    }
}