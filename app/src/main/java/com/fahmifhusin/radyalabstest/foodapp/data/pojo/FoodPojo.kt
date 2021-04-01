package com.fahmifhusin.radyalabstest.foodapp.data.pojo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FoodPojo(
    @SerializedName("image")
    private var image:String?= null,
    @SerializedName("name")
    private var name:String?= null,
    @SerializedName("desc")
    private var desc:String?= null
):Serializable
{
   fun getImage()=image
    fun getName() =name
    fun getDesc() =desc
}