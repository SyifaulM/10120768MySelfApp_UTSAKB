package com.example.a10102768uts.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a10102768uts.R
import com.example.a10102768uts.model.DailyActivity
import com.example.a10102768uts.model.Music

class MusicAdapter: RecyclerView.Adapter<MusicAdapter.ViewHolder>() {
    private val data = mutableListOf<Music>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.music_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(newData: List<Music>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.music_title)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.music_desc)

        fun bind(item: Music) {
            titleTextView.text = item.title
            descriptionTextView.text = item.description
        }
    }
}