package com.fahmifhusin.radyalabstest.foodapp.data.api

import com.fahmifhusin.radyalabstest.foodapp.data.pojo.FoodPojo
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("foods")
    fun getFood(): Call<MutableList<FoodPojo>>
}