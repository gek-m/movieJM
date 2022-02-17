package com.interview.moviejm.scheduler

import io.reactivex.Scheduler

interface AppSchedulers {

    fun background(): Scheduler
    fun main(): Scheduler
}