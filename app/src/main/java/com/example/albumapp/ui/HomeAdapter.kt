package com.example.albumapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.albumapp.R
import com.example.albumapp.data.PostModel
import kotlinx.android.synthetic.main.home_rv_item_view.view.*

class HomeAdapter(mainActivity: MainActivity) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){

    private var data : ArrayList<PostModel>?=null

    fun setData(list: ArrayList<PostModel>){
        data = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_rv_item_view, parent, false))
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = data?.get(position)
        holder.bindView(item)
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindView(item: PostModel?) {
            itemView.tv_home_item_title.text = item?.title
            itemView.tv_home_item_body.text = item?.body
        }

    }
}