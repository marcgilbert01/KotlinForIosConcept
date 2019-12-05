
import Foundation
import SharedCode
import RxSwift

class ObservableImpl<T> : SharedCode.Observable {
    
    init(observable: RxSwift.Observable<T>) {
      self.swiftObservable = observable
    }

    var swiftObservable: RxSwift.Observable<T>
    
    func subscribe(onNext: @escaping (Any?) -> Void, onError: @escaping (KotlinThrowable) -> Void) -> SharedCode.Disposable {
           
           return DisposableImpl(disposable:
            self.swiftObservable.subscribe { event in
                
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
        
        let newobs = swiftObservable.delay(.milliseconds(123), scheduler: ViewController.computationScheduler!)
        //maybe we shouldn;t use this scheduler 
        
        return ObservableImpl(observable: newobs)
        
        //return ObservableImpl(observable: observable.delay(.milliseconds(millisec),scheduler: ViewController.computationScheduler))
    }
    
    private func convertToKotlinThrowable (error: Error)-> KotlinThrowable {
        
        return KotlinThrowable(message: "error from rx swift")
    }
    
}
