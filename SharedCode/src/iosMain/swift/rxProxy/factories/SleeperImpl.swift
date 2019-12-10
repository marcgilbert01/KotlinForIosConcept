//
//  SleeperImpl.swift
//  ConceprFirstRxSwift
//
//  Created by Marc Gilbert on 06/12/2019.
//  Copyright © 2019 Marc Gilbert. All rights reserved.
//

import Foundation
import SharedCode

class SleeperImpl: Sleeper {
    func sleepFor(millisec: Int64) {
        sleep(UInt32(millisec))
    }
}
