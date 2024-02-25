//
//  ViewController.swift
//  Quiz32
//
//  Created by 권순형 on 2023/02/09.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var lblMessage: UILabel!
    @IBOutlet weak var tfNum2: UITextField!
    @IBOutlet weak var tfNum1: UITextField!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        lblMessage.text = ""
    }


    @IBAction func btnCalc(_ sender: UIButton) {
        // 입력을 안했을 경우 기본값 0으로 대체하여 계산하기
        let num1 = Int(tfNum1.text!) ?? 0 // Nil병합 연산자
        let num2 = Int(tfNum2.text!) ?? 0
        
        // 숫자 크기를 비교해서 순서 정하기
        var num1st : Int
        var num2nd : Int
        if num1 > num2 {
            num1st = num1
            num2nd = num2
        }else{
            num1st = num2
            num2nd = num1
        }
        
        var total : Int = 0
        
        for i in num2nd...num1st{
            total += i
        }
        
        lblMessage.text = "숫자의 합계는 \(total) 입니다."
        
    }
}

