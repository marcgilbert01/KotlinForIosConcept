package com.jetbrains.handson.mpp.mobile.the_rx.factories

import com.jetbrains.handson.mpp.mobile.the_rx.Observable

interface ObservableFactory {

    fun just(str: String): Observable

}