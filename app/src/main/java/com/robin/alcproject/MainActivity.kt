package com.robin.alcproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.robin.alcproject.viewpager.PagerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val demoCollectionAdapter = PagerAdapter(this)
        val viewPager : ViewPager2 = findViewById(R.id.viewPager)
        viewPager.adapter = demoCollectionAdapter
        val mainActivityViewModel: MainActivityViewModel by viewModels ()
        mainActivityViewModel.fetchNeedData()

        val tabLayout : TabLayout = findViewById(R.id.tabLayout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when(position){
                0 -> tab.text = "Learning Leaders"
                1 -> tab.text = "Skill IQ Leaders"
            }
        }.attach()
    }

    fun openSubmitActivity(view: View) {
        startActivity(Intent(this, SubmissionActivity::class.java))
    }
}



