//
//  SchedulerImpl.swift
//  ConceprFirstRxSwift
//
//  Created by Marc Gilbert on 05/12/2019.
//  Copyright © 2019 Marc Gilbert. All rights reserved.
//

import Foundation
import SharedCode
import RxSwift

class SchedulerImpl: SharedCode.Scheduler {
    
    private let scheduler: ImmediateSchedulerType
    
    init(schedulerType: RxSwift.ImmediateSchedulerType ) {
        self.scheduler = schedulerType
    }
}

