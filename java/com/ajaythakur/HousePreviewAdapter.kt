package com.ajaythakur

import com.ajaythakur.stayhook.HouseDescriptionActivity
import com.ajaythakur.stayhook.R


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//import com.project.stayhook.R
//import com.project.stayhook.common.HouseDescriptionActivity

class HousePreviewAdapter(val list:ArrayList<String>,val context: Context): RecyclerView.Adapter<HousePreviewAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val price=itemView.findViewById<TextView>(R.id.price)
        val rating=itemView.findViewById<TextView>(R.id.rating)
        val description=itemView.findViewById<TextView>(R.id.description)
        val location=itemView.findViewById<TextView>(R.id.location)
        val distance=itemView.findViewById<TextView>(R.id.distance)
        val houseCard=itemView.findViewById<RelativeLayout>(R.id.houseCard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.house_preview_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.description.text=list.get(position)

//        holder.houseCard.setOnClickListener{
//            context.startActivity(Intent(context, HouseDescriptionActivity::class.java))
//        }
    }
}
