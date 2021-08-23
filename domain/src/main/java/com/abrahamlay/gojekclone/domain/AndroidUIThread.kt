package com.abrahamlay.gojekclone.domain

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by Abraham Lay on 2019-12-28.
 */

class AndroidUIThread : com.abrahamlay.gojekclone.domain.PostExecutionThread {
    override fun getScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}