
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
      
//    func subscribe(onNext: @escaping (String) -> Void, onError: @escaping (KotlinThrowable) -> Void) -> SharedCode.Disposable {
//
//        let rxDisposable = observable.subscribe { event in
//
//            switch event {
//                case .next(let value):
//                    onNext(value)
//                case .error(let error):
//                    onError(self.convertToKotlinThrowable(error: error))
//                case .completed:
//                    print("compelter")
//            }
//        }
//
//        return DisposableImpl(disposable: rxDisposable)
//    }
    
    
    private func convertToKotlinThrowable (error: Error)-> KotlinThrowable {
        
        return KotlinThrowable(message: "error from rx swift")
    }
}
