package com.fahmifhusin.radyalabstest.foodapp.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.fahmifhusin.radyalabstest.foodapp.R
import com.fahmifhusin.radyalabstest.foodapp.data.pojo.FoodPojo
import com.fahmifhusin.radyalabstest.foodapp.ui.detail.DetailActivity
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso


class MainAdapter(private var listFood: MutableList<FoodPojo>, private val con: Context) : RecyclerView.Adapter<MainAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
            val mView : View = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_food,
                parent, false
            )
            return MainHolder(mView)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val dataFood:FoodPojo = listFood.get(position)
        Picasso.with(con).setLoggingEnabled(true)
        Picasso.with(con)
            .load(dataFood.getImage())
            .resize(200,200)
            .error(R.drawable.ic_img_fail)
            .into(holder.gambarMakanan)
        Log.d("dataimg", dataFood.getImage().toString())
        holder.namaMakanan.text = dataFood.getName()
        holder.itemView.setOnClickListener({
            val foodDataDetail = FoodPojo(
                dataFood.getImage(),
                dataFood.getName(),
                dataFood.getDesc()
            )
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("DETAIL", foodDataDetail)
            intentDetail.putExtras(bundle)
            con.startActivity(intentDetail)
            Toast.makeText(holder.itemView.context,"Bahan membuat "+dataFood.getName(),Toast.LENGTH_SHORT).show()
            Log.d("dataMakanan", foodDataDetail.toString())
        })
    }

    override fun getItemCount() = listFood.size

    class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
        var namaMakanan:TextView = itemView.findViewById(R.id.tv_nama_makanan)
        var gambarMakanan: ImageView = itemView.findViewById(R.id.img_makanan)
    }
}