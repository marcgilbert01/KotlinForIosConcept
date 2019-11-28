
import Foundation
import RxSwift

class TheRxInit {

    func initialise() -> Completable {
        var completables: Array<Completable> = Array()

        completables.append(InitForObservable().initialise())

        return  Completable.zip(completables)
    }

}
