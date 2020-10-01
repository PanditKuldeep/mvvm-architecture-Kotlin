package com.kuldeep.mvvm_architecture_kotlin.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kuldeep.mvvm_architecture_kotlin.R
import com.kuldeep.mvvm_architecture_kotlin.utils.OnItemClickListener


class HomeRecyclerAdapter(
    private val mContext: Context,
    private var list: List<Response>?,
    private val onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<HomeRecyclerAdapter.HomeRecyclerVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerVH {
        val view = LayoutInflater.from(mContext).inflate(R.layout.single_recycler, parent, false)
        return HomeRecyclerVH(view)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: HomeRecyclerVH, position: Int) {
        holder.bind(position)
    }


    inner class HomeRecyclerVH(private val root: View) : RecyclerView.ViewHolder(root) {
        fun bind(position: Int) {
            val employee = list!![position]
            root.findViewById<TextView>(R.id.text).text = employee.employee_name
            root.setOnClickListener {
                onItemClickListener.onItemClickListener(adapterPosition,employee.employee_name)
            }
        }
    }
}
