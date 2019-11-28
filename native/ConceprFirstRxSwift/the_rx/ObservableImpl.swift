
import Foundation
import SharedCode
import RxSwift

class ObservableImpl : SharedCode.Observable {

    init(observable: RxSwift.Observable<String>) {
      self.observable = observable
    }

    var observable: RxSwift.Observable<String>
    
      
    func subscribe(onNext: @escaping (String) -> Void, onError: @escaping (KotlinThrowable) -> Void) -> SharedCode.Disposable {
    
        let rxDisposable = observable.subscribe { event in
//            //onNext(event.element)
//            let str : String = event.element ?? <#default value#>
//            onNext(str)
            
            switch event {
                case .next(let value):
                    onNext(value)
                case .error(let error):
                    onError(self.convertToKotlinThrowable(error: error))
                case .completed:
                    print("compelter")
            }
        }
        
        return DisposableImpl(disposable: rxDisposable)
    }
    
    
    private func convertToKotlinThrowable (error: Error)-> KotlinThrowable {
        
        return KotlinThrowable(message: "error from rx swift")
    }
    
  
    
    
//    func subscribe(onNext: @escaping (Any?) -> Void, onError: @escaping (KotlinThrowable) -> Void) -> SharedCode.Disposable {
//        let disposable = observable.subscribe(onNext)
//        return DisposableImpl(disposable: disposable)
//    }
    
    
//    func subscribe(onNext: @escaping (Any?) -> Void, onError: @escaping (KotlinThrowable) -> Void)->SharedCode.Disposable {
//
//        //return observable?.subscribe(onNext)
//
//        //return DisposableImpl(observable?.subscribe(onNext))
//    }
    

}
