package com.android.yidgetsoft.clemmyintent

import android.content.Context
import android.util.Log
import java.util.*

/**
 * Created by Mathew on 09/09/2016.
 */
class CrimeLab private constructor(context: Context) {

    lateinit private var mCrimes: ArrayList<Crime>

    init {
        println("This ($this) is a singlepwet")
        mCrimes = ArrayList<Crime>()
        for(i in 1..100) {
            val c: Crime = Crime()
            c.mTitle = "Clemmy Crime #" + i
            c.mSolved = i % 2 == 0
            mCrimes.add(c)
        }
    }

    companion object Factory {

        private var mCrimeLab: CrimeLab? = null

        fun create(context: Context):CrimeLab? {
            if(mCrimeLab == null) {
                mCrimeLab = CrimeLab(context)
            }
            return mCrimeLab
        }
    }

    fun getCrimes():ArrayList<Crime>? {
       return mCrimes
    }

    fun getCrime(id: UUID?):Crime {

        var chosenCrime: Crime = Crime()

        for (c: Crime in mCrimes) {
            if(c.mID == id) {
                Log.v("Crime", "Crime Found!")
                chosenCrime = c
            }
        }

        return chosenCrime
    }
}