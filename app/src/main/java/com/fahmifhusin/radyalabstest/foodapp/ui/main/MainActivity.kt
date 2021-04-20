package com.fahmifhusin.radyalabstest.foodapp.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fahmifhusin.radyalabstest.foodapp.R
import com.fahmifhusin.radyalabstest.foodapp.data.pojo.FoodPojo


class MainActivity : AppCompatActivity() {
    private lateinit var rvFood: RecyclerView
    private lateinit var adapterFood: MainAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var dataResult:MutableList<FoodPojo>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (getSupportActionBar() != null) {
            getSupportActionBar()?.setTitle(getResources().getString(R.string.food_home))
        }
        rvFood = findViewById(R.id.rv_food)
        layoutManager = GridLayoutManager(this, 2)
        rvFood.setLayoutManager(layoutManager)
            val moviesViewModel = ViewModelProviders.of(this,
                this.let { MainViewModelFactory(it) }).get(MainViewModel::class.java)
            moviesViewModel.getFoodViewData().observe(this, object : Observer<ArrayList<FoodPojo>> {
                override fun onChanged(t: ArrayList<FoodPojo>) {
                    dataResult = mutableListOf()
                    adapterFood = MainAdapter(dataResult, this@MainActivity)
                    rvFood.setAdapter(adapterFood)
                    dataResult.clear()
                    t.let { dataResult.addAll(it) }
                    adapterFood.notifyDataSetChanged()
                    Log.d("size", dataResult.size.toString())
                }
            })
        }
}