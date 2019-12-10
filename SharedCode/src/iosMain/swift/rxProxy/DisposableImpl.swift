
import Foundation
import RxSwift
import SharedCode

class DisposableImpl : SharedCode.Disposable {
    
    init(disposable: RxSwift.Disposable) {
        self.disposable = disposable
    }
    
    private var disposable: RxSwift.Disposable
    
    func dispose() {
        disposable.dispose()
    }

    func isDisposed() -> Bool {
        return false
    }
}
