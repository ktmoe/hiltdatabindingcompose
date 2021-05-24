package com.ktmmoe.daggerhilttutorial.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ktmmoe.daggerhilttutorial.R
import com.ktmmoe.daggerhilttutorial.data.model.User
import kotlinx.android.synthetic.main.item_layout.view.*

/**
 * Created by ktmmoe on 24, May, 2021
 **/
class MainAdapter (private val users: ArrayList<User>): RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {
            itemView.tvUserName.text = user.name
            itemView.tvUserEmail.text = user.email
            Glide.with(itemView.ivAvatar.context)
                .load(user.avatar)
                .into(itemView.ivAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder = DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) = holder.bind(users[position])

    override fun getItemCount(): Int = users.count()

    fun addData(list: List<User>) {
        users.addAll(list)
        notifyDataSetChanged()
    }

}