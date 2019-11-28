package the_rx

import com.jetbrains.handson.mpp.mobile.the_rx.Disposable
import com.jetbrains.handson.mpp.mobile.the_rx.Observable

class ObservableImpl(
    private val observable: io.reactivex.Observable<String>
): Observable {

//    override fun subscribe(onNext: (T) -> Unit, onError: (Throwable) -> Unit): Disposable {
//        return DisposableImpl(observable.subscribe(onNext, onError))
//    }

    override fun subscribe(onNext: (String) -> Unit, onError: (Throwable) -> Unit): Disposable {
        return DisposableImpl(observable.subscribe(onNext, onError))
    }
}