package com.example.recyclerview.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerview.DetailActivity
import com.example.recyclerview.model.MyContact
import com.example.recyclerview.databinding.CardviewLayoutBinding
import com.example.recyclerview.model.MyDisease

class CardViewAdapter(private val context : Context, private val listDisease : ArrayList<MyDisease>) : RecyclerView.Adapter<CardViewAdapter.ViewHolder>() {
    class ViewHolder(val binding : CardviewLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = CardviewLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listDisease.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.txtPenyakit.text = listDisease[position].penyakit
        Glide.with(holder.itemView.context).load(listDisease[position].foto).into(holder.binding.images)
        holder.binding.CardView.setOnClickListener {
            val inten = Intent(context, DetailActivity::class.java)
            inten.putExtra("penyakit", listDisease[position].penyakit)
            inten.putExtra("penjelasan", listDisease[position].penjelasanPenyakit)
            inten.putExtra("Pencegahan", listDisease[position].penjelasanPencegahan)
            inten.putExtra("Diagnosis", listDisease[position].penjelasanDiagnosis)
            inten.putExtra("Perawatan", listDisease[position].penjelasanPerawatan)
            context.startActivity(inten)
        }
    }
}















