package com.example.smartummah.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smartummah.R
import com.example.smartummah.model.Prayer

class PrayerTimeAdapter(val items: List<Prayer>) :
    RecyclerView.Adapter<PrayerTimeAdapter.MyViewHolder>() {
//    private lateinit var prayerTimeList: List<Prayer>
//    init{
//        this.prayerTimeList = items
//    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val prayerTime: TextView = itemView.findViewById(R.id.tv_prayer_time)
        val prayerName: TextView = itemView.findViewById(R.id.tv_prayer_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_prayer_time, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        items.run {
            holder.prayerName.text = this[position].prayerName
            holder.prayerTime.text = this[position].prayerTime
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}