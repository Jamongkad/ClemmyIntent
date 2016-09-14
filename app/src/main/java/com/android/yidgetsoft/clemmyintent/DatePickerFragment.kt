package com.android.yidgetsoft.clemmyintent

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View

/**
 * Created by Mathew on 14/09/2016.
 */
class DatePickerFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val datePickerView: View = LayoutInflater.from(activity).inflate(R.layout.dialog_date, null)

        return AlertDialog.Builder(activity)
                          .setTitle(R.string.date_picker_title)
                          .setView(datePickerView)
                          .setPositiveButton(android.R.string.ok, null)
                          .create()

    }

}