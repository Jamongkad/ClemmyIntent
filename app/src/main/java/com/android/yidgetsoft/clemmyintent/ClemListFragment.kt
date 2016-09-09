package com.android.yidgetsoft.clemmyintent

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        val crimeLab: CrimeLab = CrimeLab.create(activity)
        val crimes: List<Crime> = crimeLab.getCrimes()

        mAdapter = CrimeAdaptor(crimes, activity)
        mCrimeRecyclerView.adapter = mAdapter
    }

    class CrimeHolder(view: View) : RecyclerView.ViewHolder(view) {

        var mTitleTextView : TextView

        init {
            mTitleTextView = view as TextView
        }
    }

    class CrimeAdaptor(crimes: List<Crime>, activity: Activity) : RecyclerView.Adapter<CrimeHolder>() {

        val mCrimes: List<Crime> = crimes
        var mActivity: Activity = activity

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CrimeHolder {
            val layoutInflater: LayoutInflater = LayoutInflater.from(mActivity)
            val view: View = layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false)
            return CrimeHolder(view)
        }

        override fun onBindViewHolder(holder: CrimeHolder?, position: Int) {
            val crime: Crime = mCrimes[position]
            holder?.mTitleTextView?.text = crime.mTitle
        }

        override fun getItemCount():Int {
            return mCrimes.size
        }
    }
}

