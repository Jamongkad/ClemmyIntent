package com.android.yidgetsoft.clemmyintent
import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.util.Log
import java.util.*

class ClemmyActivity : SingleFragmentActivity() {

    var EXTRA_CRIME_ID: String = "com.bignerdranch.android.criminalintent.crime_id"

    override fun createFragment(): Fragment {
        return ClemFragment()
        /*
        val crimeId: UUID? = intent.getSerializableExtra(EXTRA_CRIME_ID) as UUID
        Log.v("Fragment", "Crime Id #" + crimeId)
        return ClemFragment.newInstance(crimeId)
        */
    }

    companion object Factory {

        fun newIntent(packageContent: Context, crimeId: UUID?): Intent {
            val intent: Intent = Intent(packageContent, ClemmyActivity::class.java)
            intent.putExtra(ClemmyActivity().EXTRA_CRIME_ID, crimeId)
            return intent
        }
    }
}
