//
//  ViewController.swift
//  ConceprFirstRxSwift
//
//  Created by Marc Gilbert on 18/11/2019.
//  Copyright © 2019 Marc Gilbert. All rights reserved.
//

import UIKit
import RxSwift
import SharedCode

class ViewController: UIViewController, MainContractView {

    static var computationScheduler: SchedulerType?
    
    var presenter : MainContractPresenter?
    
    override func viewDidLoad() {
        super.viewDidLoad()
                
//        self.presenter = MainPresenter(view: self, rxFactories: IosRxFactories())
//        self.presenter?.onViewStart()
//
        
        let operationQueue = OperationQueue()
        operationQueue.maxConcurrentOperationCount = 3
        operationQueue.qualityOfService = QualityOfService.userInitiated
        ViewController.computationScheduler = OperationQueueScheduler(operationQueue: operationQueue) as? SchedulerType
        
  /*
        RxSwift.Observable
            .just("obs")

        //.delay(.seconds(5), scheduler: ViewController.computationScheduler!)
            //.delay(.seconds(5), scheduler: ConcurrentDispatchQueueScheduler(qos: .background))
            .delay(.seconds(5), scheduler: MainScheduler.instance)
            //.observeOn(ConcurrentDispatchQueueScheduler(qos: .background))
            //.observeOn(MainScheduler.instance)
            .observeOn(MainScheduler.instance)
            .subscribe { event in
                
                //sleep(3000)
                
                switch event {
                    
                case .next(let value):
                    self.showMessage(message: value)
                case .error(let error):
                    self.showMessage(message: error.localizedDescription)
                default:
                    break
                }
            }
    */
        
        self.presenter = MainPresenter(view: self, rxFactories: IosRxFactories())
        self.presenter?.onViewStart()
        
    }
    
    override func viewDidAppear(_ animated: Bool) {
        presenter?.onViewStart()
    }

    func showMessage(message: String) {
        let button: UIButton = self.view.viewWithTag(123) as! UIButton
        button.setTitle(message, for: .normal)
    }
    
    func displaySomeObject(someObject: SomeObject) {
        let label: UILabel = self.view.viewWithTag(222) as! UILabel
        label.text = someObject.str
        let button: UIButton = self.view.viewWithTag(123) as! UIButton
        button.setTitle(String(someObject.number), for: .normal)
    }
    
    class IosRxFactories : SharedCode.RxFactories {
        
        func getObservableFactory() -> ObservableFactory {
            return IosObservableFactory()
        }
        
        func getSchedulerModule() -> SchedulerModule {
            return IosSchedulerModule()
        }

        func getSleeper() -> Sleeper {
            return IosSleeper()
        }
    }

    class IosObservableFactory: ObservableFactory {

        func just(t: Any?) -> SharedCode.Observable {
            return ObservableImpl(observable: RxSwift.Observable.just(t))
        }
    }
    
    
    class IosSchedulerModule: SchedulerModule {
        func io() -> Scheduler {
            return SchedulerImpl(schedulerType: ConcurrentDispatchQueueScheduler(qos: .background))
        }
        
        func ui() -> Scheduler {
            return SchedulerImpl(schedulerType: MainScheduler.instance)
        }
        
        func computation() -> Scheduler {
            return SchedulerImpl(schedulerType: ViewController.computationScheduler!)
        }
    }
    
    class IosSleeper: Sleeper {
        func sleepFor(millisec: Int64) {
            sleep(UInt32(millisec))
        }
    }
}

//        static let operationQueue = NSOperationQueue()
//    operationQueue.maxConcurrentOperationCount = 3
//    operationQueue.qualityOfService = NSQualityOfService.UserInitiated
//    let backgroundWorkScheduler
//      = OperationQueueScheduler(operationQueue: operationQueue)
