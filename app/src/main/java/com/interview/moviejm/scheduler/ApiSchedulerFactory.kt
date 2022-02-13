package com.interview.moviejm.scheduler

object ApiSchedulerFactory {

    fun create(): AppSchedulers = DefaultSchedulers()
}