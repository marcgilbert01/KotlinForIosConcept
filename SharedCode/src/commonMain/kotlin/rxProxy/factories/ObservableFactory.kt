package com.jetbrains.handson.mpp.mobile.the_rx.factories

import com.jetbrains.handson.mpp.mobile.the_rx.Observable

interface ObservableFactory {

    fun <T>just(t: T): Observable<T>

}