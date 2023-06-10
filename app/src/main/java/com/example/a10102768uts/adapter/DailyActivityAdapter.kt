package com.example.a10102768uts.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a10102768uts.R
import com.example.a10102768uts.ViewPagerAdapter
import com.example.a10102768uts.model.DailyActivity
import com.example.a10102768uts.model.DailyActivityModel

class DailyActivityAdapter : RecyclerView.Adapter<DailyActivityAdapter.ViewHolder>() {
    private val data = mutableListOf<DailyActivity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.daily_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(newData: List<DailyActivity>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.daily_title)
        private val imageView: ImageView = itemView.findViewById(R.id.daily_img)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.daily_desc)

        fun bind(item: DailyActivity) {
            titleTextView.text = item.title
            imageView.setImageResource(item.imageResId)
            descriptionTextView.text = item.description
        }
    }
}