package com.example.canlender

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class AdapterPlan(private val context : SecondFragment,
            private val dataSet : List<String>)
    : RecyclerView.Adapter<AdapterPlan.HolderItemView>()
{
    inner class HolderItemView(view : View) : RecyclerView.ViewHolder(view),View.OnClickListener {
        val titlePlan : TextView = view.findViewById(R.id.txtTitlePlan)
        val titleColor : CircleImageView = view.findViewById(R.id.titleColor)
        init {
            view.isClickable = true
            view.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            context.gotoPlan()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderItemView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,null)
        return HolderItemView(view)
    }

    override fun onBindViewHolder(holder: HolderItemView, position: Int) {
        val item = dataSet[position]
        holder.titlePlan.text = item
        holder.titleColor.setOnClickListener {
//            context.gotoPlan()
        }
    }

    override fun getItemCount() = dataSet.size
}