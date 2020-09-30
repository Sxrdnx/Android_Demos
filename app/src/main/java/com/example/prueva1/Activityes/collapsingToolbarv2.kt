package com.example.prueva1.Activityes

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.palette.graphics.Palette
import com.example.prueva1.R
import kotlinx.android.synthetic.main.activity_collapsing_toolbarv2.*
import java.util.*

class CollapsingToolbarv2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing_toolbarv2)
        setSupportActionBar(toolbarv2)
        Objects.requireNonNull(supportActionBar)!!.setDisplayHomeAsUpEnabled(true)

        val bitmap:Bitmap=BitmapFactory.decodeResource(resources,R.drawable.cielo)
        Palette.from(bitmap).generate(object :Palette.PaletteAsyncListener{
            override fun onGenerated(palette: Palette?) {
               if(palette!=null){
                   collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(R.attr.colorPrimary))
               }
            }

        })


    }
}