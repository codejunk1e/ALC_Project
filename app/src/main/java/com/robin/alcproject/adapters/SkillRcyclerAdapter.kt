package com.robin.alcproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.robin.alcproject.R
import com.robin.alcproject.models.SkillItem

/**
 * @author robin
 * Created on 9/9/20
 */

class SkillRcyclerAdapter(private var items: List<SkillItem> , private var context : Context) : RecyclerView.Adapter<SkillRcyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private var name : TextView = itemView.findViewById(R.id.skill_name)
        private var score : TextView = itemView.findViewById(R.id.skill_score)

        fun bind(boardItem: SkillItem) {
            name.text = boardItem.name
            score.text = context.getString(R.string.scores_main_text_skill, boardItem.hours.toString(), boardItem.country )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_skill, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

     fun updateAdapter ( items: List<SkillItem>){
        this.items = items
         notifyDataSetChanged()
    }

}