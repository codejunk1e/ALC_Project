package com.robin.alcproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar

class SubmissionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submission)
        setUpToolBar()
    }

    private fun setUpToolBar() {
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.submitToolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_arrow)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

}