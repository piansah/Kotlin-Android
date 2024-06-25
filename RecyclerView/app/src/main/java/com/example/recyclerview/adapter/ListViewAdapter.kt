package com.example.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.DetailActivity
import com.example.recyclerview.model.MyContact
import com.example.recyclerview.databinding.ListviewLayoutBinding

class ListViewAdapter(private val context : Context,  private val listStudent : ArrayList<MyContact>) : RecyclerView.Adapter<ListViewAdapter.ViewHolder>() {
    class ViewHolder(val binding : ListviewLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ListviewLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listStudent.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.binding.tvNama.text = listStudent[position].nama
       holder.binding.tvNim.text = listStudent[position].nim
       holder.binding.tvNomorTelepon.text = listStudent[position].nomorTelepon
       holder.binding.itemView.setOnClickListener{
           val inten = Intent(context, DetailActivity::class.java)
           inten.putExtra("nim", listStudent[position].nim)
           inten.putExtra("nama", listStudent[position].nama)
           inten.putExtra("telepon", listStudent[position].nomorTelepon)
           inten.putExtra("foto", listStudent[position].foto)
           context.startActivity(inten)
       }
    }
}















