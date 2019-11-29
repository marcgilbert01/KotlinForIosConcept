package rxProxy

import com.jetbrains.handson.mpp.mobile.the_rx.Disposable

class DisposableImpl(
    private val disposable: io.reactivex.disposables.Disposable
) : Disposable {

    override fun dispose() {
        disposable.dispose()
    }

    override fun isDisposed(): Boolean {
        return disposable.isDisposed
    }
}