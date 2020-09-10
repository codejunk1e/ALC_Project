package com.robin.alcproject.dialogs

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.robin.alcproject.R

/**
 * @author robin
 * Created on 9/10/20
 */
class SubmissionDialog(private val dialogType : SubmissionDialogType) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater;
            builder.setView(
                    when (dialogType){
                        SubmissionDialogType.SUCCESS -> inflater.inflate(R.layout.success_dialog, null)
                        SubmissionDialogType.ERROR ->   inflater.inflate(R.layout.unsuccessful_dialog, null)
                        SubmissionDialogType.CONFIRMATION -> inflater.inflate(R.layout.confirmation_dialog, null)
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}

enum class SubmissionDialogType{
    CONFIRMATION,
    ERROR,
    SUCCESS
}