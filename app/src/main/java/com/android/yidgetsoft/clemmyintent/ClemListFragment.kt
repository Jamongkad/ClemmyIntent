package com.android.yidgetsoft.clemmyintent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView

/**
 * Created by Mathew on 09/09/2016.
 */
class ClemListFragment : Fragment() {

    lateinit private var mCrimeRecyclerView: RecyclerView
    lateinit private var mAdapter: CrimeAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = inflater!!.inflate(R.layout.fragment_crime_list, container, false)
        mCrimeRecyclerView = view.findViewById(R.id.crime_recycler_view) as RecyclerView
        mCrimeRecyclerView.layoutManager = LinearLayoutManager(activity)

        updateUI()

        return view
    }

    private fun updateUI() {

        val crimeLab: CrimeLab? = CrimeLab.create(activity)
        val crimes: List<Crime>? = crimeLab?.getCrimes()

        mAdapter = CrimeAdaptor(crimes, activity)
        mCrimeRecyclerView.adapter = mAdapter
    }

    class CrimeHolder(view: View, activity: Activity) : RecyclerView.ViewHolder(view) {

        var mTitleTextView: TextView
        var mDateTextView: TextView
        var mSolvedCheckBox: CheckBox
        var mCrime: Crime? = null

        init {
            mTitleTextView = view.findViewById(R.id.list_item_crime_title_text_view) as TextView
            mDateTextView = view.findViewById(R.id.list_item_crime_date_text_view) as TextView
            mSolvedCheckBox = view.findViewById(R.id.list_item_crime_solved_check_box) as CheckBox

            var activity: Activity = activity

            view.setOnClickListener {
                val intent: Intent = ClemmyActivity.newIntent(activity, mCrime?.mID)
                activity.startActivity(intent)
            }
        }

        fun bindCrime(crime: Crime?) {
            mCrime = crime
            mTitleTextView.text = crime?.mTitle
            mDateTextView.text  = crime?.mDate.toString()
            mSolvedCheckBox.isChecked = crime!!.mSolved
        }
    }

    class CrimeAdaptor(crimes: List<Crime>?, activity: Activity) : RecyclerView.Adapter<CrimeHolder>() {

        val mCrimes: List<Crime>? = crimes
        val mActivity: Activity = activity

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CrimeHolder {
            val layoutInflater: LayoutInflater = LayoutInflater.from(mActivity)
            val view: View = layoutInflater.inflate(R.layout.list_item_crime, parent, false)
            return CrimeHolder(view, mActivity)
        }

        override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
            val crime: Crime? = mCrimes?.get(position)
            holder.bindCrime(crime)
        }

        override fun getItemCount():Int {
            return mCrimes!!.size
        }
    }
}

