//
//  ViewController.swift
//  Quiz02
//
//  Created by 권순형 on 2023/02/09.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var tfNum1: UITextField!
    @IBOutlet weak var tfNum2: UITextField!
    @IBOutlet weak var tfAdd: UITextField!
    @IBOutlet weak var tfSub: UITextField!
    @IBOutlet weak var tfMul: UITextField!
    @IBOutlet weak var lblMessage: UILabel!
    @IBOutlet weak var tfDivQuotient: UITextField!
    @IBOutlet weak var tfDivRemainder: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        lblMessage.text?.removeAll()
        readOnly()
    }
    
    func readOnly(){
        tfAdd.isUserInteractionEnabled = false
        tfSub.isUserInteractionEnabled = false
        tfMul.isUserInteractionEnabled = false
        tfDivQuotient.isUserInteractionEnabled = false
        tfDivRemainder.isUserInteractionEnabled = false
    }

    // 아무곳이나 눌러 softkeyboard 지우기
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }
    
    
    @IBAction func btnCalc(_ sender: UIButton) {
        guard let strNum1 = tfNum1.text else {return}
        guard let strNum2 = tfNum2.text else {return}
        
        let res1:Int = checkNil(strNum1)
        let res2:Int = checkNil(strNum2)
        
        if res1 + res2 == 2 {
            lblMessage.text = ""
            lblMessage.text = "계산이 완료 되었습니다!"
            calculation(res1: strNum1, res2: strNum2)
            
        }else{
            lblMessage.text = "숫자를 입력하세요"
        }
    }
    
    func calculation(res1:String , res2:String){
        
        if Int(res2) == 0{
            lblMessage.text = "2번째 숫자는 0이 들어가면 안됩니다."
            return
        }
        
        tfAdd.text = String(Int(res1)! + Int(res2)!)
        tfSub.text = String(Int(res1)! - Int(res2)!)
        tfMul.text = String(Int(res1)! * Int(res2)!)
        tfDivQuotient.text = String(Int(res1)! / Int(res2)!)
        tfDivRemainder.text = String(Int(res1)! % Int(res2)!)
        
    }
    
    func checkNil(_ str:String) -> Int{
        let check = str.trimmingCharacters(in: .whitespaces)
        
        if check.isEmpty{
            return 0
        }
        return 1
    }
    
}

