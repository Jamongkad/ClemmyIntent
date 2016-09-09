package com.android.yidgetsoft.clemmyintent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

/**
 * Created by Mathew on 06/09/2016.
 */
class ClemFragment : Fragment() {

    lateinit private var mCrime:Crime
    lateinit private var mTitleField: EditText
    lateinit private var mDateButton: Button
    lateinit private var mSolvedCheckbox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mCrime = Crime()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val view: View = inflater!!.inflate(R.layout.fragment_crime, container, false)

        mTitleField = view.findViewById(R.id.crime_title) as EditText
        mDateButton = view.findViewById(R.id.crime_date) as Button
        mSolvedCheckbox = view.findViewById(R.id.crime_solved) as CheckBox

        mTitleField.addTextChangedListener(object: TextWatcher {

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                mCrime.mTitle = s.toString()
            }

            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {}
        })

        mDateButton.text = mCrime.mDate.toString()
        mDateButton.isEnabled = false
        mDateButton.setOnClickListener({
            Log.v("Machu", "Plox")
        })

        mSolvedCheckbox.setOnCheckedChangeListener { buttonView, isChecked ->
            mCrime.mSolved = isChecked
            mDateButton.isEnabled = isChecked
            Log.v("Machu", "Pleex")
        }
        return view
    }
}