package com.robin.alcproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * @author robin
 * Created on 9/9/20
 */

class IQRecyclerAdapter(private val items: List<BoardItem>) : RecyclerView.Adapter<IQRecyclerAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private var name : TextView = itemView.findViewById(R.id.name_iq)
        private var score : TextView = itemView.findViewById(R.id.iq_score)

        fun bind(boardItem: BoardItem) {
            name.text = boardItem.name
            score.text = boardItem.score
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_iq, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

}