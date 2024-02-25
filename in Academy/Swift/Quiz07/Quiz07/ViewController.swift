//
//  ViewController.swift
//  Quiz07
//
//  Created by 권순형 on 2023/02/14.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var lblResult: UILabel!
    @IBOutlet weak var tfNum2: UITextField!
    @IBOutlet weak var tfNum1: UITextField!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func btnAdd(_ sender: UIButton) {
        let calculation = Calculation()
        
        lblResult.text = String(calculation.add(숫자1: tfNum1.text , 숫자2: tfNum2.text))
    }
    
}

