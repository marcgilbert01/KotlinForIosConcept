package rxProxy.factories

import com.jetbrains.handson.mpp.mobile.the_rx.Observable
import com.jetbrains.handson.mpp.mobile.the_rx.factories.ObservableFactory
import rxProxy.ObservableImpl

class ObservableFactoryImpl: ObservableFactory{
    override fun <T> just(t: T): Observable<T> {
        return ObservableImpl(io.reactivex.Observable.just(t))
    }
}