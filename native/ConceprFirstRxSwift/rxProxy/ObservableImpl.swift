
import Foundation
import SharedCode
import RxSwift

class ObservableImpl<T> : SharedCode.Observable {
    
    init(observable: RxSwift.Observable<T>) {
      self.observable = observable
    }

    var observable: RxSwift.Observable<T>
    
    func subscribe(onNext: @escaping (Any?) -> Void, onError: @escaping (KotlinThrowable) -> Void) -> SharedCode.Disposable {
           
           return DisposableImpl(disposable:
            self.observable.subscribe { event in
                
                switch event {
                    
                case .next(let value):
                    onNext(value)
                case .error(let error):
                    onError(self.convertToKotlinThrowable(error: error))
                default:
                    break
                }
            }
           )
       }
    
    func subscribeOn(scheduler: Scheduler) -> SharedCode.Observable {
        return self
    }
    
    func observeOn(scheduler: Scheduler) -> SharedCode.Observable {
        return self
    }
    
    func delay(millisec: Int64) -> SharedCode.Observable {
        return observable.delay(.milliseconds(millisec), null)
    }
    
    private func convertToKotlinThrowable (error: Error)-> KotlinThrowable {
        
        return KotlinThrowable(message: "error from rx swift")
    }
    
}
