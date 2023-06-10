package com.example.a10102768uts.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a10102768uts.R
import com.example.a10102768uts.model.Friend

class FriendListAdapter : RecyclerView.Adapter<FriendListAdapter.ViewHolder>() {
    private val data = mutableListOf<Friend>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.friend_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(newData: List<Friend>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.frienlist_name)
        private val imageView: ImageView = itemView.findViewById(R.id.friendList_img)

        fun bind(item: Friend) {
            nameTextView.text = item.name
            imageView.setImageResource(item.imageResId)
        }
    }
}