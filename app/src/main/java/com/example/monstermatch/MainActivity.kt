package com.example.monstermatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.monstermatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val monsters: List<Monster> = listOf(
        Monster(R.drawable.monster1_head, R.drawable.monster1_body, R.drawable.monster1_feet, "Sab"),
        Monster(R.drawable.monster2_head, R.drawable.monster2_body, R.drawable.monster2_feet, "Russ"),
        Monster(R.drawable.monster3_head, R.drawable.monster3_body, R.drawable.monster3_feet, "Pat")
    )

    private fun shuffleMonsters() {
        val monsterHead =  monsters.random().head
        val monsterBody = monsters.random().body
        val monsterFeet = monsters.random().feet

             binding.monsterHeadImageView.setImageResource(monsterHead)
             binding.monsterBodyImageView.setImageResource(monsterBody)
             binding.monsterFeetImageView.setImageResource(monsterFeet)
             binding.matchButton.setOnClickListener{
            shuffleMonsters()
        }

        if ((monsterHead == R.drawable.monster1_head) && (monsterBody == R.drawable.monster1_body) && (monsterFeet == R.drawable.monster1_feet)) {
            binding.successMessage.setText("You matched " + monsters[0].name)
        } else if ((monsterHead == R.drawable.monster2_head) && (monsterBody == R.drawable.monster2_body) && (monsterFeet == R.drawable.monster2_feet)) {
            binding.successMessage.setText("You matched " + monsters[1].name)
        } else if((monsterHead == R.drawable.monster3_head) && (monsterBody == R.drawable.monster3_body) && (monsterFeet == R.drawable.monster3_feet)){
            binding.successMessage.setText("You matched " + monsters[2].name)
        }else {
            binding.successMessage.setText("")
        }
    }

    data class Monster(val head: Int, val body: Int, val feet: Int, val name: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        shuffleMonsters()
        binding.matchButton.setOnClickListener{
            shuffleMonsters()
        }
    }

}