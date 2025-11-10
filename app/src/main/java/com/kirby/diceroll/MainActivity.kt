package com.kirby.diceroll

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.kirby.diceroll.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val historyAdapter = RollHistoryAdapter()
    private var rollCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.historyRecycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = historyAdapter
        }

        binding.diceImage.setOnClickListener { rollDice() }
        binding.rollButton.setOnClickListener { rollDice() }

        binding.diceImage.setImageResource(R.drawable.dice_1)
        binding.diceImage.contentDescription = getString(R.string.dice_default)
    }

    private fun rollDice() {
        val dice = Dice(6)
        val result = dice.roll()
        val drawable = when (result) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        binding.diceImage.setImageResource(drawable)
        binding.diceImage.contentDescription = getString(R.string.dice_rolled, result)

        rollCounter++
        historyAdapter.addRoll(rollCounter, result)
    }
}