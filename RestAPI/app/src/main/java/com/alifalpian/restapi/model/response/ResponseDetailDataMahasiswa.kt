package com.alifalpian.restapi.model.response


import com.alifalpian.restapi.model.request.DetailDataMahasiswa
import com.google.gson.annotations.SerializedName

data class ResponseDetailDataMahasiswa(
    @SerializedName("data")
    val data: DetailDataMahasiswa,
    @SerializedName("status")
    val status: String
)