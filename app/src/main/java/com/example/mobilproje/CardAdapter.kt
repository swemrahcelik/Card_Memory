package com.example.mobilproje



import android.app.Dialog
import android.content.Context
import android.os.CountDownTimer
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_modal.view.*
import kotlinx.android.synthetic.main.card_item.view.*
import java.util.*


class CardAdapter: BaseAdapter {
    var fruitList = mutableListOf<Card>()
    var context: Context? = null
    lateinit var mainActivity:MainActivity
    var score=0
    var time=0
    var move=0
    var match=0
    var cardsize=0;





    constructor(
        context: Context,
        fruitList: MutableList<Card>,
        mainActivity: MainActivity,
        cardSize: Int
    ) : super() {
        this.context = context
        this.fruitList = fruitList
        this.mainActivity=mainActivity
        this.cardsize=cardSize
        this.starttimer()
    }

    override fun getCount(): Int {
        return fruitList.size
    }

     fun ControlCard():Int{
         var adet= fruitList.filter { it.isOpen==true }
         if (adet.count()==2) {
             if (adet[0].name == adet[1].name) {
                 fruitList.filter { it.isOpen==true }.forEach{it.isvisible=true }
                 match=match+1
                 mainActivity.txtMatch.text="Match: " + match+"/"+(cardsize*cardsize)/2
                 score=score+10
                 mainActivity.txtScore.text="Score:" +score
             }else{
                 score=score-2
                 mainActivity.txtScore.text="Score:" +score
                 fruitList.filter { it.isOpen==true }.forEach{it.isvisible=false }

             }
             fruitList.forEach{it.isOpen=false }
         }
         if (match==(cardsize*cardsize)/2)
             openmodal()
         else
             this!!.notifyDataSetChanged()
        return  0
    }
    fun openmodal(){
        val db by lazy { DBHelper(mainActivity) }
        var lasttime=120-time
        db.insertData(User(score=score,date = lasttime.toString()))
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var modal = inflator.inflate(R.layout.activity_modal, null)
        modal.txtScoreModal.text=score.toString()
        val settingsDialog = Dialog(mainActivity)
        settingsDialog.getWindow()?.requestFeature(Window.FEATURE_NO_TITLE)
        settingsDialog.setContentView(modal)
        settingsDialog.setCancelable(false)
        settingsDialog.setCanceledOnTouchOutside(false)
        settingsDialog.show()
    }
    fun starttimer(){
        object : CountDownTimer(120000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                time= millisUntilFinished.toInt()/1000
                mainActivity.txtTime.setText("Time: " + millisUntilFinished / 1000)
            }
            override fun onFinish() {
                openmodal()
            }
        }.start()
    }

    override fun getItem(position: Int): Any {
        return fruitList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val fruit = this.fruitList[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var fruitItemView = inflator.inflate(R.layout.card_item, null)


        fruitItemView.fruitButton.setOnClickListener {
            fruitItemView.fruitButton.setImageResource(fruit.image!!)
            fruit.isOpen=true
            fruit.isvisible=true

            val handler = Handler()
            handler.postDelayed({
                ControlCard()
            }, 1000)
            move=move+1
            mainActivity.txtmove.text="Moves:" + move.toString()

        }
        if(fruit.isvisible)
            fruitItemView.fruitButton.setImageResource(fruit.image!!)
        else
            fruitItemView.fruitButton.setImageResource(fruit.backimage!!)


        return fruitItemView


    }
}