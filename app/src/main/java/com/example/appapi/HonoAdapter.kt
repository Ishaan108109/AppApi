package com.example.appapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.appapi.databinding.RecyclerviewHonoBinding

class HonoAdapter (
    private val honos: HonoItems

        ):RecyclerView.Adapter<HonoAdapter.HonoViewHolder>(){

    override fun getItemCount() = honos.data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= HonoViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recyclerview_hono,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: HonoViewHolder, position: Int) {
        holder.recyclerviewHonoBinding.hono = honos.data[position]
    }

    inner class HonoViewHolder(
                val recyclerviewHonoBinding: RecyclerviewHonoBinding
            ): RecyclerView.ViewHolder(recyclerviewHonoBinding.root)
        }