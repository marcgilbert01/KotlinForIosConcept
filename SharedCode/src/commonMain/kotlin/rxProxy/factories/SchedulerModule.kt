package com.jetbrains.handson.mpp.mobile.rxProxy.factories

import com.jetbrains.handson.mpp.mobile.rxProxy.Scheduler

interface SchedulerModule {

    fun io(): Scheduler

    fun ui(): Scheduler

    fun computation(): Scheduler

}