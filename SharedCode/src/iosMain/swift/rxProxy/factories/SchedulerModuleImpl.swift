//
//  SchedulerModuleImpl.swift
//  ConceprFirstRxSwift
//
//  Created by Marc Gilbert on 06/12/2019.
//  Copyright © 2019 Marc Gilbert. All rights reserved.
//

import Foundation
import SharedCode
import RxSwift

class SchedulerModuleImpl: SharedCode.SchedulerModule {
    
    let ioScheduler = SchedulerImpl(schedulerType: ConcurrentDispatchQueueScheduler(qos: .background))
    let uiScheduler = SchedulerImpl(schedulerType: MainScheduler.instance)

    func io() -> SharedCode.Scheduler {
        return ioScheduler
    }
    
    func ui() -> SharedCode.Scheduler {
        return uiScheduler
    }
    
    func computation() -> SharedCode.Scheduler {
        return ioScheduler
    }
}
