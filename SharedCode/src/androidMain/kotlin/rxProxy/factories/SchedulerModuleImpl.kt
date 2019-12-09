package com.jetbrains.handson.mpp.mobile.rxProxy.factories

import com.jetbrains.handson.mpp.mobile.rxProxy.Scheduler

class SchedulerModuleImpl(
    private val ioScheduler: Scheduler,
    private val uiScheduler: Scheduler,
    private val computationScheduler: Scheduler
): SchedulerModule {

    override fun io() = ioScheduler

    override fun ui() = uiScheduler

    override fun computation() = computationScheduler
}