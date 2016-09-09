package com.android.yidgetsoft.clemmyintent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager

/**
 * Created by Mathew on 09/09/2016.
 */
abstract class SingleFragmentActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val fm: FragmentManager = supportFragmentManager
        fm.beginTransaction().add(R.id.fragment_container, createFragment()).commit()

        /*
        var fragment: Fragment = fm.findFragmentById(R.id.fragment_container)
        if (fragment == null) {
            fragment = ClemFragment()
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit()
        }
        */
    }

    protected abstract fun createFragment(): Fragment
}