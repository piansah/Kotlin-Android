package com.alifalpian.restapi.model.request


import com.google.gson.annotations.SerializedName

data class DetailDataMahasiswa(
    @SerializedName("NIM")
    val NIM: String,
    @SerializedName("Nama")
    val nama: String,
    @SerializedName("Telepon")
    val telepon: String
)