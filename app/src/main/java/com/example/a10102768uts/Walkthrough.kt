package com.example.a10102768uts

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator3
import android.content.Intent

class Walkthrough : AppCompatActivity() {
    private var titlesList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()
    private lateinit var viewPager: ViewPager2
    private lateinit var indicator: CircleIndicator3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.walkthrough)

        postToList()
        viewPager = findViewById<ViewPager2>(R.id.w_pages)
        val viewpager2Adapter = ViewPagerAdapter(titlesList,descList,imagesList)
        viewPager.adapter = viewpager2Adapter

        indicator = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(viewPager)

        val lewati_btn = findViewById<Button>(R.id.lewati)
        lewati_btn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun addToList(title: String, description: String, image: Int){
        titlesList.add(title)
        descList.add(description)
        imagesList.add(image)
    }

    private fun postToList(){
        for (i in 1..3){
//            addToList("Page ${i}", "ini wt ${i}", R.drawable.undraw_female_avatar_efig)
            if (i == 1){
                addToList("Syifa's Daily Activity", "Get to know what Syifa's activity", R.drawable.undraw_suburbs_re_en49)
            } else if (i==2){
                addToList("Favorite Music", "Get Syifa's fav music lists", R.drawable.undraw_happy_music_g6wc)
            } else {
                addToList("Everithing About Syifa!", "Enjoy the little project...", R.drawable.undraw_travelers_re_y25a)
            }
        }
    }
}