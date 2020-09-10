package com.robin.alcproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.robin.alcproject.R
import com.robin.alcproject.models.IQItem
import com.robin.alcproject.models.SkillItem

/**
 * @author robin
 * Created on 9/9/20
 */

class IQRecyclerAdapter(private var items: List<IQItem>,  private var context : Context) : RecyclerView.Adapter<IQRecyclerAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private var name : TextView = itemView.findViewById(R.id.name_iq)
        private var score : TextView = itemView.findViewById(R.id.iq_score)

        fun bind(skillItem: IQItem) {
            name.text = skillItem.name
            score.text = context.getString(R.string.scores_main_text_iq, skillItem.score.toString(), skillItem.country
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_iq, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size


    fun updateAdapter ( items: List<IQItem>){
        this.items = items
    }
}