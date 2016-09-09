package com.android.yidgetsoft.clemmyintent

import java.util.*

/**
 * Created by Mathew on 06/09/2016.
 */
class Crime() {

    var mID: UUID
    var mTitle: String
    var mDate: Date
    var mSolved: Boolean

    init {
        mID = UUID.randomUUID()
        mTitle = ""
        mDate = Date()
        mSolved = false
    }
}