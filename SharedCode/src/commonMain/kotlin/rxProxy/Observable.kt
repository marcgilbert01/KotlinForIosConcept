package com.jetbrains.handson.mpp.mobile.the_rx

interface Observable<T> {

    fun subscribe( onNext:(T) -> Unit , onError:(Throwable) -> Unit ): Disposable

}

