package com.android.yidgetsoft.clemmyintent

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.KeyEvent
import java.text.FieldPosition
import java.util.*

/**
 * Created by Mathew on 12/09/2016.
 */
class ClemPagerActivity : FragmentActivity() {

    lateinit private var mViewPager: ViewPager
    private var mCrimes: ArrayList<Crime>? = null

    var EXTRA_CRIME_ID: String = "com.bignerdranch.android.criminalintent.crime_id"

    companion object Factory {

        fun newIntent(packageContent: Context, crimeId: UUID?): Intent {
            val intent: Intent = Intent(packageContent, ClemPagerActivity::class.java)
            intent.putExtra(ClemPagerActivity().EXTRA_CRIME_ID, crimeId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crime_pager)

        val crimeId: UUID = intent.getSerializableExtra(EXTRA_CRIME_ID) as UUID

        mViewPager = findViewById(R.id.activity_crime_pager_view_pager) as ViewPager

        val crimeLab: CrimeLab? = CrimeLab.create(applicationContext)
        mCrimes = crimeLab?.getCrimes()

        val fm: FragmentManager = supportFragmentManager

        class InnerPageAdaptor(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
            override fun getItem(position: Int): Fragment {
                val crime: Crime? = mCrimes?.get(position)
                return ClemFragment.newInstance(crime?.mID)
            }

            override fun getCount(): Int {
                return mCrimes!!.size
            }
        }

        mViewPager.adapter = InnerPageAdaptor(fm)

        var position: Int = 0
        for (c: Crime in mCrimes.orEmpty()) {
            if(c.mID == crimeId) {
                mViewPager.currentItem = position
            }
            position += 1
        }

    }
}