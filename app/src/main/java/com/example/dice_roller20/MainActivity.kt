package com.example.dice_roller20

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Dice(val sides: Int) {
    fun roll(): Int{
        var side_range = 1..sides;
        var res = side_range.random()
        return res
    }
}


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var timesRolled = 0;
        val dice = Dice(6)
        val rollButton: Button = findViewById(R.id.button)
        val times_rolles_textview: TextView = findViewById(R.id.times_rolled_textview)
        val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
        rollButton.setOnClickListener{
            toast.show()
            val diceImage: ImageView = findViewById(R.id.imageView)
            timesRolled+=1
            times_rolles_textview.setText("Dice rolled ${timesRolled} times")
            var res  = dice.roll()
            when(res){
                1 -> diceImage.setImageResource(R.drawable.dice_1)
                2 -> diceImage.setImageResource(R.drawable.dice_2)
                3 -> diceImage.setImageResource(R.drawable.dice_3)
                4 -> diceImage.setImageResource(R.drawable.dice_4)
                5 -> diceImage.setImageResource(R.drawable.dice_5)
                6 -> diceImage.setImageResource(R.drawable.dice_6)
            }
        }
    }
}