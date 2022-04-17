package com.example.mobilproje

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_game_start.*

class GameStart : AppCompatActivity() {
    val db by lazy { DBHelper(this)  }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_start)
        showData(db.readData())
    }
    fun click4x4(view:View){
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("CardSize", 4)
        startActivity(intent)
    }
    fun click6x6(view:View){
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("CardSize", 6)
        startActivity(intent)
    }
    fun showData(list:MutableList<User>) {
        ScoreListAdapter.text = ""
        list.forEach {
            ScoreListAdapter.text = ScoreListAdapter.text.toString() + "\n" + it.id +". "+ it.score + " Points " + it.date + " Second"
        }
    }
}