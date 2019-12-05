package com.jetbrains.handson.mpp.mobile.the_rx

import com.jetbrains.handson.mpp.mobile.rxProxy.Scheduler

interface Observable<T> {

    fun subscribe( onNext:(T) -> Unit , onError:(Throwable) -> Unit ): Disposable

    fun subscribeOn(scheduler: Scheduler): Observable<T>

    fun observeOn(scheduler: Scheduler): Observable<T>

    fun delay(millisec: Long): Observable<T>

}

