//
//  ViewController.swift
//  KotlinIOS
//
//  Created by Marc Gilbert on 08/11/2019.
//  Copyright © 2019 Marc Gilbert. All rights reserved.
//

import UIKit
import SharedCode

class ViewController: UIViewController, MainContractView{
   
    var presenter: MainPresenter?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Do any additional setup after loading the view.
        let label = UILabel(frame: CGRect(x: 0, y: 0, width: 300, height: 21))
        label.center = CGPoint(x: 160, y: 285)
        label.textAlignment = .center
        label.font = label.font.withSize(25)
        label.text = CommonKt.createApplicationScreenMessage()
        view.addSubview(label)

        presenter = MainPresenter(view :self)
    }
    
    override func viewDidAppear(_ animated: Bool) {
        presenter?.onViewStart()
    }
    
    func showMessage(message: String) {
        let button: UIButton = self.view.viewWithTag(123) as! UIButton
        button.setTitle(message, for: .normal)
    }
  
}

