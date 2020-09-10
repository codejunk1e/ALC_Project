package com.robin.alcproject

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.robin.alcproject.dialogs.SubmissionDialog
import com.robin.alcproject.dialogs.SubmissionDialogType

class SubmissionActivity : AppCompatActivity() {
    lateinit var newFragment : SubmissionDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submission)
        setUpToolBar()
    }

    private fun setUpToolBar() {
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.submitToolbar)
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        setSupportActionBar(toolbar)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_arrow)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    fun submitProject(view: View) {
        showDialog()
    }

    private fun showDialog() {
        newFragment = SubmissionDialog (SubmissionDialogType.CONFIRMATION)
        newFragment.show(supportFragmentManager, getString(R.string.submit))
    }

    fun cancelDialog(view: View) {
        newFragment.dismiss()
    }

    fun confirmSubmission(view: View) {
        upLoadDetails()
        newFragment.dismiss()
    }

    private fun upLoadDetails() {

    }
}