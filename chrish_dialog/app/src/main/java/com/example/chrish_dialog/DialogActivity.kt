package com.example.chrish_dialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class DialogActivity :AppCompatActivity(){

    private lateinit var mPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
        //binding=ActivityMainBinding.inflate(layoutInflater)
        mPager = findViewById(R.id.view_pager)

        val Adapter = PagerAdapter(supportFragmentManager)
        // 뷰 페이저에 어댑터 연결
        mPager.adapter=Adapter


        // 탭 레아아웃에 뷰페이저 연결

    }
}