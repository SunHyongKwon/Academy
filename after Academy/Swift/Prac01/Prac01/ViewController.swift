//
//  ViewController.swift
//  Prac01
//
//  Created by 권순형 on 2023/02/14.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var tfNum1: UITextField!
    
    @IBOutlet weak var tfNum2: UITextField!
    
    @IBOutlet weak var tfAdd: UITextField!
    
    @IBOutlet weak var tfSub: UITextField!
    
    @IBOutlet weak var tfMul: UITextField!
    
    @IBOutlet weak var tfDiv: UITextField!
    
    @IBOutlet weak var addSwitch: UISwitch!

    @IBOutlet weak var subSwitch: UISwitch!
    
    @IBOutlet weak var mulSwitch: UISwitch!
    
    @IBOutlet weak var divSwitch: UISwitch!
    
    
    var results:[Float]?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        tfAdd.isUserInteractionEnabled = false
        tfSub.isUserInteractionEnabled = false
        tfMul.isUserInteractionEnabled = false
        tfDiv.isUserInteractionEnabled = false
        
    }

    @IBAction func btnCalc(_ sender: UIButton) {
        let calc = Calculation()
        
        results = calc.calc(tfNum1.text,tfNum2.text)
        
        tfAdd.text = addSwitch.isOn ? String(Int(results![0])) : ""
        tfSub.text = subSwitch.isOn ? String(Int(results![1])) : ""
        tfMul.text = mulSwitch.isOn ? String(Int(results![2])) : ""
        tfDiv.text = divSwitch.isOn ? String(results![3]) : ""
    }
    
    @IBAction func btnDel(_ sender: UIButton) {
        tfAdd.text = ""
        tfSub.text = ""
        tfMul.text = ""
        tfDiv.text = ""
        
        tfNum1.text = ""
        tfNum2.text = ""
        
        results = []
        
    }
    
    @IBAction func addSwi(_ sender: UISwitch) {
        tfAdd.text = sender.isOn ? String(Int(results![0])) : ""
    }
    
    @IBAction func subSwi(_ sender: UISwitch) {
        tfSub.text = sender.isOn ? String(Int(results![1])) : ""
    }
    
    @IBAction func mulSwi(_ sender: UISwitch) {
        tfMul.text = sender.isOn ? String(Int(results![2])) : ""
    }
    
    @IBAction func divSwi(_ sender: UISwitch) {
        tfDiv.text = sender.isOn ? String(results![3]) : ""
    }
    

    
}

