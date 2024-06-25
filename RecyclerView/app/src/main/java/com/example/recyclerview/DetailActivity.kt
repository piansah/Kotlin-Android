package com.example.recyclerview

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.recyclerview.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val penyakit = intent.getStringExtra("penyakit")
        val penjelasanPenyakit = intent.getStringExtra("penjelasanPenjakit")
        val penjelasanPencegahan = intent.getStringExtra("pencegahan")
        val penjelasanDiagnosis = intent.getStringExtra("diagnosis")
        val penjelasanPerawatan = intent.getStringExtra("perawatan")

        binding.txtPenyakit.text = penyakit
        binding.txtPenjelasanPenyakit.text = penjelasanPenyakit
        binding.txtPenjelasanPencegahan.text = penjelasanPencegahan
        binding.txtPenjelasanDiagnosis.text = penjelasanDiagnosis
        binding.txtPenjelasanPerawatan.text = penjelasanPerawatan
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                onBackPressed()
                true
            }else -> super.onOptionsItemSelected(item)
        }
    }
}


