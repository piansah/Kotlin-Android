package com.alifalpian.restapi.model.request


import com.google.gson.annotations.SerializedName

data class DataAllMahasiswa(
    @SerializedName("NIM")
    val NIM: String,
    @SerializedName("Nama")
    val nama: String,
    @SerializedName("Telepon")
    val telepon: String
)