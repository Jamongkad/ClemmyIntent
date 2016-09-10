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
import java.util.*

/**
 * Created by Mathew on 06/09/2016.
 */
class ClemFragment : Fragment() {

    private var mCrime:Crime? = null
    lateinit private var mTitleField: EditText
    lateinit private var mDateButton: Button
    lateinit private var mSolvedCheckbox: CheckBox

    /*
    companion object Factory {

        private var ARG_CRIME_ID: String = "crime_id"

        fun newInstance(crimeId: UUID?): ClemFragment {
            val args: Bundle = Bundle()
            args.putSerializable(ARG_CRIME_ID, crimeId)

            val clemFragment: ClemFragment = ClemFragment()
            clemFragment.arguments = args
            return clemFragment
        }
    }
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val crimeId: UUID = arguments.getSerializable(ClemmyActivity().EXTRA_CRIME_ID) as UUID
        val crimeId: UUID? = activity.intent.getSerializableExtra(ClemmyActivity().EXTRA_CRIME_ID) as? UUID

        val crimeLab: CrimeLab? = CrimeLab?.create(activity)
        mCrime = crimeLab?.getCrime(crimeId)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val view: View = inflater!!.inflate(R.layout.fragment_crime, container, false)

        mTitleField = view.findViewById(R.id.crime_title) as EditText
        mDateButton = view.findViewById(R.id.crime_date) as Button
        mSolvedCheckbox = view.findViewById(R.id.crime_solved) as CheckBox

        mTitleField.addTextChangedListener(object: TextWatcher {

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                mCrime?.mTitle = s.toString()
            }

            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {}
        })

        mDateButton.text = mCrime?.mDate.toString()
        mDateButton.setOnClickListener({
            Log.v("Machu", "Plox")
        })

        mSolvedCheckbox.setOnCheckedChangeListener { buttonView, isChecked ->
            mCrime?.mSolved = isChecked
            Log.v("Machu", "Pleex")
        }

        mTitleField.setText(mCrime?.mTitle)
        mDateButton.text = mCrime?.mDate.toString()
        mSolvedCheckbox.isChecked = mCrime!!.mSolved

        return view
    }
}