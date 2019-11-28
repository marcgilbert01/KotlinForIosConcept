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
    
    var presenter : MainContractPresenter?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
//        TheRxInit().initialise()
//            .subscribe { completable in
//                switch completable {
//                    case .completed:
//                        print("Completed with no error")
//                        self.presenter = MainPresenter(view: self)
//                        self.presenter?.onViewStart()
//
//                    case .error(let error):
//                        print("Completed with an error: \(error.localizedDescription)")
//                }
//            }
        
            
        
        self.presenter = MainPresenter(view: self, rxFactories: IosRxFactories())
        self.presenter?.onViewStart()
        
    }
    
    override func viewDidAppear(_ animated: Bool) {
        presenter?.onViewStart()
    }

    func showMessage(message: String) {
        let button: UIButton = self.view.viewWithTag(123) as! UIButton
        button.setTitle(message, for: .normal)    }
    
    
    class IosRxFactories : SharedCode.RxFactories {
        
        func getObservableFactory() -> ObservableFactory {
            return IosObservableFactory()
        }
    
    }
    
    class IosObservableFactory: ObservableFactory {
        
        func just(str: String) -> SharedCode.Observable {
            
            return ObservableImpl(
                observable: RxSwift.Observable.just(str)
            )
        }
    }
    
}

