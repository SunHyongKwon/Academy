//
//  ViewController.swift
//  Calc
//
//  Created by 권순형 on 2023/02/14.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var tvResult: UITextView!
    @IBOutlet weak var tfDan: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        tvResult.isEditable = false
    }


    @IBAction func btnDan(_ sender: UIButton) {
        tvResult.text = ""
        
        guard let dan = tfDan.text?.trimmingCharacters(in: .whitespaces) else {return}
        
        var result = ""
        
        for i in 1...9{
            result = "\(dan) * \(i) = \(Int(dan)! * i) \n"
            tvResult.text += result
        }
        
    }
}

