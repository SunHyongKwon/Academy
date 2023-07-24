//
//  ViewController.swift
//  Welcome
//
//  Created by 권순형 on 2023/02/09.
//

// 바뀔 애를 outlet이라고 한다.

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var tfname: UITextField!
    @IBOutlet weak var lblWelcome: UILabel!
    
    let welcomeString = "Welcome!"
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        lblWelcome.text = welcomeString
    }
    
    @IBAction func bgnSend(_ sender: UIButton) {
//        lblWelcome.text?.append(tfname.text!)
        // guardlet : normal한 case
        guard let strName = tfname.text else {return}
        lblWelcome.text?.append(strName)
        
    }
    
    @IBAction func btnClear(_ sender: UIButton) {
        lblWelcome.text = welcomeString
        tfname.text = ""
    }
    
    // 아무곳이나 눌러 softkeyboard 지우기
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }
    
    
}

