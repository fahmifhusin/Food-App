package com.fahmifhusin.radyalabstest.foodapp.ui.detail

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.fahmifhusin.radyalabstest.foodapp.R
import com.fahmifhusin.radyalabstest.foodapp.data.pojo.FoodPojo

class DetailActivity : AppCompatActivity() {
    private lateinit var imgDetail:ImageView
    private lateinit var namaDetail:TextView
    private lateinit var descDetail:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val actionBar: ActionBar? = supportActionBar
        if (supportActionBar != null) {
            supportActionBar?.title = resources.getString(R.string.detail)
            actionBar?.setDisplayHomeAsUpEnabled(true)
        imgDetail = findViewById(R.id.img_detail)
        namaDetail = findViewById(R.id.tv_detail_name)
        descDetail = findViewById(R.id.tv_detail_desc)
        val bundle = intent.extras
        val foodDetail: FoodPojo = bundle!!.getSerializable("DETAIL") as FoodPojo
            Glide.with(this)
                .load(foodDetail.getImage())
                .into(imgDetail)
            namaDetail.text = foodDetail.getName()
            descDetail.text = foodDetail.getDesc()
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Toast.makeText(this,R.string.msg_to_main, Toast.LENGTH_SHORT).show()
    }
}