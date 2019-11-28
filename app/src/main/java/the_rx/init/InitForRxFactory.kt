package the_rx.init

import com.jetbrains.handson.mpp.mobile.the_rx.Observable
import io.reactivex.Completable
import the_rx.ObservableImpl

class InitForRxFactory {

    fun initialise() : Completable {
        return Completable.fromAction{
//            Observable.global = object : Observable.Global {
//                override fun <T> just(t: T): Observable<T> {
//                    return ObservableImpl<T>(io.reactivex.Observable.just(t))
//                }
//            }
        }
    }
}