package com.example.prueva1.Activityes

import android.graphics.Bitmap
import android.graphics.Color

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.prueva1.R
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_collapsing_toolbar.*


class collapsingToolbar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing_toolbar)
        collapsingToolbar_layout
        setSupportActionBar(toolbar)
        val bitmap= expandedImage.drawable.toBitmap()
        window.statusBarColor = getDominantContrassColor(bitmap)
        toolbar.setTitleTextColor(getDominantContrassColor(bitmap))

        app_bar.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener{
            var isShow=false
            var scrollRange=-1
            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollRange==-1){
                    scrollRange= appBarLayout.totalScrollRange
                }
                //========== when scrollbar on the top=============
                if (scrollRange+verticalOffset==0){
                    collapsingToolbar_layout.title="Collapsed"
                    collapsingToolbar_layout.setCollapsedTitleTextColor(Color.WHITE)
                    toolbar.setBackgroundColor(getDominantContrassColor(bitmap))
                    isShow=true
                    //========== when scrollbar at down side=============
                }else if(isShow){
                    collapsingToolbar_layout.title="Expanded"
                    collapsingToolbar_layout.setExpandedTitleColor(getDominantContrassColor(bitmap))
                    toolbar.setBackgroundColor(Color.TRANSPARENT)
                    isShow=false
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    fun getDominantContrassColor(bitmat: Bitmap): Int{
        val gbitmap=Bitmap.createScaledBitmap(bitmat,1,1,true)
        var gcolor= gbitmap.getPixel(0,0)
        var red=Color.red(gcolor)
        var green=Color.green(gcolor)
        var blue=Color.blue(gcolor)
        val newcolor=Color.rgb(255-red,255-green,255-blue)
        return newcolor

    }
}