package com.jetbrains.handson.mpp.mobile.rxProxy

import com.jetbrains.handson.mpp.mobile.rxProxy.Scheduler
import com.jetbrains.handson.mpp.mobile.the_rx.Disposable
import com.jetbrains.handson.mpp.mobile.the_rx.Observable
import java.util.concurrent.TimeUnit

class ObservableImpl<T>(
    private var observable: io.reactivex.Observable<T>
): Observable<T> {

    override fun subscribe(onNext: (T) -> Unit, onError: (Throwable) -> Unit): Disposable {
        return DisposableImpl(
            observable.subscribe(
                onNext,
                onError
            )
        )
    }

    override fun subscribeOn(scheduler: Scheduler): Observable<T> {
        return ObservableImpl(observable.subscribeOn((scheduler as SchedulerImpl).scheduler))
    }

    override fun observeOn(scheduler: Scheduler): Observable<T> {
        return ObservableImpl(observable.observeOn((scheduler as SchedulerImpl).scheduler))
    }

    override fun delay(millisec: Long): Observable<T> {
        return ObservableImpl(
            observable.delay(
                millisec,
                TimeUnit.MILLISECONDS
            )
        )
    }
}