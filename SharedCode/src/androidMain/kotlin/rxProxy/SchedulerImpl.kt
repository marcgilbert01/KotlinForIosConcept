package com.jetbrains.handson.mpp.mobile.rxProxy

class SchedulerImpl(
    val scheduler: io.reactivex.Scheduler
): Scheduler