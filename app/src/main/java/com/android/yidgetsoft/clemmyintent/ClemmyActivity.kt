package com.android.yidgetsoft.clemmyintent
import android.support.v4.app.Fragment

class ClemmyActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment {
        return ClemFragment()
    }
}
