package com.jetbrains.handson.mpp.mobile.the_rx.factories

import com.jetbrains.handson.mpp.mobile.rxProxy.factories.SchedulerModule
import com.jetbrains.handson.mpp.mobile.rxProxy.factories.Sleeper

interface RxFactories {

    fun getObservableFactory(): ObservableFactory

    fun getSchedulerModule(): SchedulerModule

    fun getSleeper(): Sleeper

}