package com.alifalpian.restapi.network

import com.alifalpian.restapi.model.request.Mahasiswa
import com.alifalpian.restapi.model.response.ResponseAddDataMahasiswa
import com.alifalpian.restapi.model.response.ResponseDataMahasiswa
import com.alifalpian.restapi.model.response.ResponseDeleteDataMahasiswa
import com.alifalpian.restapi.model.response.ResponseDetailDataMahasiswa
import com.alifalpian.restapi.model.response.ResponseUpdateMahasiswa
import retrofit2.Call
import retrofit2.http.*

interface APIService {
    @GET("datamahasiswa/")
    fun getDataMahasiswa() : Call<ResponseDataMahasiswa>

    @GET("datamahasiswa/{nim}")
    fun getDetailMahasiswa(@Path("nim") nim : String) : Call<ResponseDetailDataMahasiswa>

    @POST("datamahasiswa/")
    fun addDataMahasiswa(@Body data: Mahasiswa) : Call<ResponseAddDataMahasiswa>

    @DELETE("datamahasiswa/{nim}")
    fun deleteDataMahasiswa(@Path("nim") nim : String) : Call<ResponseDeleteDataMahasiswa>

    @POST("datamahasiswa/{nim}")
    fun updateDataMahasiswa(@Path("nim") nim : String, @Body data: Mahasiswa) : Call<ResponseUpdateMahasiswa>

}