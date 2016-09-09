package com.android.yidgetsoft.clemmyintent
import android.support.v4.app.Fragment

/**
 * Created by Mathew on 09/09/2016.
 */
class ClemListActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment {
        return ClemListFragment()
    }

}