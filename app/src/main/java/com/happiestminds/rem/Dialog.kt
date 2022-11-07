package com.happiestminds.rem

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.google.android.material.snackbar.Snackbar

class MyDialog: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var dlg: Dialog? = null
        val message = arguments?.getString("msg")
        val title = arguments?.getString("title")
        val descr = arguments?.getString("description")
        val date = arguments?.getString("date")
        val time = arguments?.getString("time")

        val rem = Remind(title!!,descr!!,date!!,time!!)

        //create a dialog here
        context?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Confirmation")
            builder.setMessage(message)
            builder.setPositiveButton("yes"){ dialog, i ->
                // executed button clicking
                DBWrapper(it).deleteRemainder(rem)
                activity?.finish()

            }
            builder.setNegativeButton("No") { dialog, i ->
                dialog.cancel()
            }
            builder.setNeutralButton("Cancel") { dialg, i ->
                dialg.cancel()

            }
            dlg = builder.create()
        }
        return dlg!!
    }
}
