
import Foundation
import RxSwift
import SharedCode

class InitForObservable {
    
    func initialise() -> RxSwift.Completable {
        
            return RxSwift.Completable.create(subscribe: { observer in

                SharedCode.ObservableCompanion.init().global = ObservableGlobalImpl()
                
                observer(.completed)
               
                return RxSwift.Disposables.create()
            })
        }

    class ObservableGlobalImpl : ObservableGlobal {
        func just(t: Any?) -> SharedCode.Observable {
            return ObservableImpl(observable: RxSwift.Observable.just(t))
        }
    }
}



