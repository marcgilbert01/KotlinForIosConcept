package rxProxy

import com.jetbrains.handson.mpp.mobile.the_rx.Disposable
import com.jetbrains.handson.mpp.mobile.the_rx.Observable

class ObservableImpl<T>(
    private val observable: io.reactivex.Observable<T>
): Observable<T> {

    override fun subscribe(onNext: (T) -> Unit, onError: (Throwable) -> Unit): Disposable {
        return DisposableImpl(observable.subscribe(onNext, onError))
    }
//
//    override fun subscribe(onNext: (String) -> Unit, onError: (Throwable) -> Unit): Disposable {
//
//        return DisposableImpl(observable.subscribe(onNext, onError))
//    }
}