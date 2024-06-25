package com.alifalpian.restapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alifalpian.restapi.model.request.DataAllMahasiswa
import com.alifalpian.restapi.model.request.Mahasiswa
import com.alifalpian.restapi.model.response.ResponseAddDataMahasiswa
import com.alifalpian.restapi.model.response.ResponseDataMahasiswa
import com.alifalpian.restapi.model.response.ResponseDetailDataMahasiswa
import com.alifalpian.restapi.model.response.ResponseUpdateMahasiswa
import com.alifalpian.restapi.network.APIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelMahasiswa : ViewModel(){
    private val getDataMahasiswa = MutableLiveData<List<DataAllMahasiswa>?>()
    private val detailMahasiswa = MutableLiveData<ResponseDetailDataMahasiswa?>()
    private val insertMahasiswa = MutableLiveData<ResponseAddDataMahasiswa?>()
    private val updateMahasiswa = MutableLiveData<ResponseUpdateMahasiswa?>()

    fun getDataMahasiswa() : MutableLiveData<List<DataAllMahasiswa>?>{
        return getDataMahasiswa
    }
    fun getDetailMahasiswa(): MutableLiveData<ResponseDetailDataMahasiswa?> {
        return detailMahasiswa
    }
    fun insertMahasiswa(): MutableLiveData<ResponseAddDataMahasiswa?> {
        return insertMahasiswa
    }
    fun updateMahasiswa(): MutableLiveData<ResponseUpdateMahasiswa?> {
        return updateMahasiswa
    }

    fun showDataMahasiswa(){
        APIClient.instance.getDataMahasiswa().enqueue(object : Callback<ResponseDataMahasiswa>{
            override fun onResponse(
                call: Call<ResponseDataMahasiswa>,
                response: Response<ResponseDataMahasiswa>)
            {
                if (response.isSuccessful){
                    getDataMahasiswa.postValue(response.body()?.data)
                }else{
                    getDataMahasiswa.postValue(null)
                }
            }
            override fun onFailure(call: Call<ResponseDataMahasiswa>,t: Throwable){
                getDataMahasiswa.postValue(null)
            }
        })
    }

    fun getDetailData(nim: String) {
        APIClient.instance.getDetailMahasiswa(nim).enqueue(object : Callback<ResponseDetailDataMahasiswa> {
            override fun onResponse(
                call: Call<ResponseDetailDataMahasiswa>,
                response: Response<ResponseDetailDataMahasiswa>
            ) {
                if (response.isSuccessful) {
                    detailMahasiswa.postValue(response.body())
                } else {
                    detailMahasiswa.postValue(null)
                }
            }

            override fun onFailure(call: Call<ResponseDetailDataMahasiswa>, t: Throwable) {
                detailMahasiswa.postValue(null)
            }
        })
    }

    fun insertDataMahasiswa(nim : String, nama :String,telepon : String){
        APIClient.instance.addDataMahasiswa(Mahasiswa(nim,nama,telepon)).enqueue(object : Callback<ResponseAddDataMahasiswa>{
            override fun onResponse(
                call: Call<ResponseAddDataMahasiswa>,
                response: Response<ResponseAddDataMahasiswa>
            ) {
                if (response.isSuccessful){
                    insertMahasiswa.postValue(response.body())
                }else{
                    insertMahasiswa.postValue(null)
                }
            }

            override fun onFailure(call: Call<ResponseAddDataMahasiswa>, t: Throwable) {
                insertMahasiswa.postValue(null)
            }
        })
    }

    fun updateDataMahasiswa(nim : String, nama :String,telepon : String){
        APIClient.instance.updateDataMahasiswa(nim,Mahasiswa(nim,nama,telepon)).enqueue(object : Callback<ResponseUpdateMahasiswa>{
            override fun onResponse(
                call: Call<ResponseUpdateMahasiswa>,
                response: Response<ResponseUpdateMahasiswa>
            ) {
                if (response.isSuccessful){
                    updateMahasiswa.postValue(response.body())
                }else{
                    updateMahasiswa.postValue(null)
                }
            }

            override fun onFailure(call: Call<ResponseUpdateMahasiswa>, t: Throwable) {
                updateMahasiswa.postValue(null)
            }
        })
    }
}