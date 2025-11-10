package com.kirby.diceroll

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kirby.diceroll.databinding.ItemRollBinding

class RollHistoryAdapter : RecyclerView.Adapter<RollHistoryAdapter.ViewHolder>() {

    private val rolls = mutableListOf<Pair<Int, Int>>()

    class ViewHolder(val binding: ItemRollBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRollBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (num, value) = rolls[position]
        holder.binding.rollNumber.text = "Roll #$num"
        holder.binding.rollValue.text = value.toString()
    }

    override fun getItemCount() = rolls.size

    fun addRoll(rollNumber: Int, value: Int) {
        rolls.add(Pair(rollNumber, value))
        if (rolls.size > 10) {
            rolls.removeAt(0)
            notifyItemRemoved(0)
        }
        notifyItemInserted(rolls.size - 1)
    }
}