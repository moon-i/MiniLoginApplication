package com.study.miniloginapplication.presentation

//
//  MainAdapter.kt
//  MiniLoginApplication
//
//  Created by moon on 06/08/2021
//

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.study.miniloginapplication.R
import com.study.miniloginapplication.databinding.ItemUserBinding
import com.study.miniloginapplication.domain.entity.User

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    val list = mutableListOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(list[position])
    }

    class ViewHolder(
        private val binding: ItemUserBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        val ivUserProfile: ImageView = itemView.findViewById(R.id.ivUserProfile)

        fun bind(user: User) {
            binding.user = user

            Glide.with(itemView.context).load(user.profile)
                .centerCrop()
                .circleCrop()
                .into(ivUserProfile)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
