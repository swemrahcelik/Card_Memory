package com.example.mobilproje


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilproje.R.drawable.*



import kotlinx.android.synthetic.main.activity_main.*

import java.util.*

class MainActivity : AppCompatActivity() {
    var adapter: CardAdapter? = null
    var cardsize=0;

    override fun onCreate(savedInstanceState: Bundle?) {
        val card = mutableListOf<Card>()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = getIntent()
        cardsize =intent.getIntExtra("CardSize",0)
        if(cardsize==4){
            card.add(Card("v1", e_1))
            card.add(Card("v1", e_1))
            card.add(Card("v2", e_2))
            card.add(Card("v2", e_2))
            card.add(Card("v3", e_3))
            card.add(Card("v3", e_3))
            card.add(Card("v4", e_4))
            card.add(Card("v4", e_4))
            card.add(Card("v5", e_5))
            card.add(Card("v5", e_5))
            card.add(Card("v6", e_6))
            card.add(Card("v6", e_6))
            card.add(Card("v7", e_7))
            card.add(Card("v7", e_7))
            card.add(Card("v8", e_8))
            card.add(Card("v8", e_8))
        }else{
            card.add(Card("v1", e_1))
            card.add(Card("v1", e_1))
            card.add(Card("v2", e_2))
            card.add(Card("v2", e_2))
            card.add(Card("v3", e_3))
            card.add(Card("v3", e_3))
            card.add(Card("v4", e_4))
            card.add(Card("v4", e_4))
            card.add(Card("v5", e_5))
            card.add(Card("v5", e_5))
            card.add(Card("v6", e_6))
            card.add(Card("v6", e_6))
            card.add(Card("v7", e_7))
            card.add(Card("v7", e_7))
            card.add(Card("v8", e_8))
            card.add(Card("v8", e_8))
            card.add(Card("v9", e_9))
            card.add(Card("v9", e_9))
            card.add(Card("v10", e_10))
            card.add(Card("v10", e_10))
            card.add(Card("v11", e_11))
            card.add(Card("v11", e_11))
            card.add(Card("v12", e_12))
            card.add(Card("v12", e_12))
            card.add(Card("v13", e_13))
            card.add(Card("v13", e_13))
            card.add(Card("v14", e_14))
            card.add(Card("v14", e_14))
            card.add(Card("v15", e_15))
            card.add(Card("v15", e_15))
            card.add(Card("v16", e_16))
            card.add(Card("v16", e_16))
            card.add(Card("v17", e_17))
            card.add(Card("v17", e_17))
            card.add(Card("v18", e_18))
            card.add(Card("v18", e_18))
        }
        card.shuffle()

        cardsGridView.numColumns=cardsize
        cardsGridView.adapter=CardAdapter(this, card,this,cardsize)
        txtMatch.text="Match:0/"+(cardsize*cardsize)/2

    }
}


