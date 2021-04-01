package com.fahmifhusin.radyalabstest.foodapp.data

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.fahmifhusin.radyalabstest.foodapp.data.api.ApiClient
import com.fahmifhusin.radyalabstest.foodapp.data.pojo.FoodPojo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RepositoryFood {
    fun getMutableLiveDataFood(context: Context) : MutableLiveData<ArrayList<FoodPojo>>{
        val mutableLiveData = MutableLiveData<ArrayList<FoodPojo>>()
        ApiClient.apiService.getFood().enqueue(object : Callback<MutableList<FoodPojo>> {
            override fun onFailure(call: Call<MutableList<FoodPojo>>, t: Throwable) {
                Log.e("error", t.localizedMessage)
            }
            override fun onResponse(call: Call<MutableList<FoodPojo>>, response: Response<MutableList<FoodPojo>>
            ) {
                val dataResponse = response.body()
                dataResponse?.let { mutableLiveData.value = it as ArrayList<FoodPojo> }
            }
        })
        return mutableLiveData
    }
}