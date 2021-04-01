package com.fahmifhusin.radyalabstest.foodapp.ui.main

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fahmifhusin.radyalabstest.foodapp.data.RepositoryFood
import com.fahmifhusin.radyalabstest.foodapp.data.pojo.FoodPojo

class MainViewModel(private val context: Context): ViewModel() {
    private var viewModelFoodData = MutableLiveData<ArrayList<FoodPojo>>()
    init{
        val repository : RepositoryFood by lazy {
            RepositoryFood
         }
        viewModelFoodData = repository.getMutableLiveDataFood(context)
    }
    fun getFoodViewData() = viewModelFoodData
    }
