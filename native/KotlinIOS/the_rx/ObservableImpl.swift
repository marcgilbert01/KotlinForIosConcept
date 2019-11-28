

public class ObservableImpl<T>( {
  init() {
  }
}
    private let observable: io.reactivex.Observable<T>
): Observable<T> {

    override func subscribe(onNext: (T) -> Void, onError: (Throwable) -> Void) -> Disposable {
        return DisposableImpl(observable.subscribe(onNext, onError))
    }
}
