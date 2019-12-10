//
//  RxFactoriesImpl.swift
//  ConceprFirstRxSwift
//
//  Created by Marc Gilbert on 06/12/2019.
//  Copyright © 2019 Marc Gilbert. All rights reserved.
//

import Foundation
import SharedCode

class RxFactoriesImpl : RxFactories {
    
    let observableFactory = ObservableFactoryImpl()
    let schedulerModuler = SchedulerModuleImpl()
    let sleeper = SleeperImpl()
    
    func getObservableFactory() -> ObservableFactory {
        return observableFactory
    }
    
    func getSchedulerModule() -> SchedulerModule {
        return schedulerModuler
    }
    
    func getSleeper() -> Sleeper {
        return sleeper
    }
}
