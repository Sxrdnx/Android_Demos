package com.example.prueva1.Activityes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prueva1.Adapters.ItemAdapter
import com.example.prueva1.Models.Item
import com.example.prueva1.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val exampleList=getItems(100)
        recyclerPrueva.adapter =
            ItemAdapter(exampleList)
        recyclerPrueva.layoutManager = LinearLayoutManager(this)
        recyclerPrueva.setHasFixedSize(true)
    }

    fun getItems(size :Int):List<Item>{
        val list= ArrayList<Item>()
        for( i in 0 until size){
            val draw=when(i%3){
                0-> R.drawable.ic_cilla
                1-> R.drawable.ic_sendato
                else-> R.drawable.ic_launcher_foreground
            }
            val item=
                Item(draw, "Item $i", "juazjuaz")
            list.add(item)
        }
        return list
    }
}