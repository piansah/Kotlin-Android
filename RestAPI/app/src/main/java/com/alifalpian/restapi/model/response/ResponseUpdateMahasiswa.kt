package com.alifalpian.restapi.model.response


import com.google.gson.annotations.SerializedName

data class ResponseUpdateMahasiswa(
    @SerializedName("data")
    val data: String,
    @SerializedName("status")
    val status: String
)