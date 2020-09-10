package com.robin.alcproject

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.robin.alcproject.dialogs.SubmissionDialog
import com.robin.alcproject.dialogs.SubmissionDialogType

class SubmissionActivity :
        AppCompatActivity(),
        SubmissionActivityViewModel.SubmissionResultListener{
    private lateinit var firstName : EditText
    private lateinit var lastName : EditText
    private lateinit var emailAddress : EditText
    private lateinit var githubURL : EditText
    private lateinit var newFragment : SubmissionDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submission)
        initViews()
        setUpToolBar()
    }

    private fun initViews() {
        firstName = findViewById(R.id.firstNameEditText)
        lastName = findViewById(R.id.lastNameEditText)
        emailAddress = findViewById(R.id.editTextTextEmailAddress)
        githubURL = findViewById(R.id.editTextGithubURL)
    }

    private fun setUpToolBar() {
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.submitToolbar)
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        setSupportActionBar(toolbar)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_arrow)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    fun submitProject(view: View) {
        showDialog(SubmissionDialogType.CONFIRMATION)
    }

    private fun showDialog(submissionType : SubmissionDialogType) {
        newFragment = SubmissionDialog (submissionType)
        newFragment.show(supportFragmentManager, getString(R.string.submit))
    }

    fun cancelDialog(view: View) {
        newFragment.dismiss()
    }

    fun confirmSubmission(view: View) {
        if(
                firstName.text.isNotEmpty() &&
                lastName.text.isNotEmpty() &&
                emailAddress.text.isNotEmpty() &&
                githubURL.text.isNotEmpty()
        ){
            upLoadDetails()
        }
        else{
            Snackbar.make(
                    findViewById(R.id.submissionLayout),
                    "Please make sure all the fields are filled",
                    Snackbar.LENGTH_LONG
            ).show()
        }
        newFragment.dismiss()
    }

    private fun upLoadDetails() {
        val model: SubmissionActivityViewModel by viewModels()
        model.setSubmissionListener(this)
        model.submitProject(
                firstName.text.toString(),
                lastName.text.toString(),
                emailAddress.text.toString(),
                githubURL.text.toString()
        )
    }

    override fun showResult(isSuccessful: Boolean) {
        if(isSuccessful) showDialog(SubmissionDialogType.SUCCESS) else showDialog(SubmissionDialogType.ERROR)
    }
}