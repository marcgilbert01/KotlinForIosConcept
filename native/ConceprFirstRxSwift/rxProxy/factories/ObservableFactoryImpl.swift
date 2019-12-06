//
//  ObservableFactoryImpl.swift
//  ConceprFirstRxSwift
//
//  Created by Marc Gilbert on 06/12/2019.
//  Copyright © 2019 Marc Gilbert. All rights reserved.
//

import Foundation
import SharedCode
import RxSwift

class ObservableFactoryImpl: ObservableFactory {
   
    func just(t: Any?) -> SharedCode.Observable {
        return ObservableImpl(observable: RxSwift.Observable.just(t))
    }
}
