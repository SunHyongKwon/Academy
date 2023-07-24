//
//  ViewController.swift
//  Keyboard
//
//  Created by 권순형 on 2023/02/18.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        setKeyboardEvent()
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }
    
    func setKeyboardEvent(){
        
        // 키보드 올라왔을 때 실행될 함수
        NotificationCenter.default.addObserver(self, selector: #selector(keyBoardWillAppear(_ :)), name: UIResponder.keyboardWillShowNotification, object: nil)
        
        // 키보드 없어졌을 때 실행될 함수
        NotificationCenter.default.addObserver(self, selector: #selector(keyBoardWillDisappear(_ :)), name: UIResponder.keyboardWillHideNotification, object: nil)
    }
    
    @objc func keyBoardWillAppear(_ sender:NotificationCenter){
        self.view.frame.origin.y = -150
    }
    
    @objc func keyBoardWillDisappear(_ sender:NotificationCenter){
        self.view.frame.origin.y = 0
    }
}

