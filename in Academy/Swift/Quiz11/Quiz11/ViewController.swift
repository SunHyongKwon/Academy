//
//  ViewController.swift
//  Quiz11
//
//  Created by 권순형 on 2023/02/16.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var lblText: UILabel!
    @IBOutlet weak var tfText: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        // extension은 view controller와 연결을 시켜주는 것이다.
        // 이거를 다시 field와 연결 시켜 줘야 된다.
        tfText.delegate = self
    }

    @IBAction func changeText(_ sender: UIButton) {
        lblText.text = tfText.text
        
        // return 누르면 닫히게 하자.
    }
    
} // ViewController

// delegate는 대리자라는 말이다.
extension ViewController: UITextFieldDelegate{
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        lblText.text = tfText.text
        return true
    }
}

