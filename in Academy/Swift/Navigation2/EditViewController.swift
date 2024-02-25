//
//  EditViewController.swift
//  Navigation
//
//  Created by 권순형 on 2023/02/18.
//

import UIKit

// 없어지고 이전 페이지에 데이털르 넘기기 위해 필요한 부분
// 자바의 interface와 비슷하다고 생각하면 된다.
// 따로 파일을 만들어도 된다.
protocol EditDelegate{
    func didMessageEditDone(_ controller: EditViewController, message: String)
    func didEditDone(_ controller: EditViewController, model: Model)
}

class EditViewController: UIViewController {

    @IBOutlet weak var swIsOn: UISwitch!
    @IBOutlet weak var lblState: UILabel!
    @IBOutlet weak var tfMessage: UITextField!
    @IBOutlet weak var lblLocation: UILabel!
    
    var textWayValue:String = ""
    var textMessage:String = ""
    var isOn:Bool = false
    
    // 프로토콜과 연결 위해 필요한 부분
    var delegate:EditDelegate?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        lblLocation.text = textWayValue
        tfMessage.text = textMessage
        swIsOn.isOn = isOn
        if isOn{
            lblState.text = "On"
        }else{
            lblState.text = "Off"
        }
        // Do any additional setup after loading the view.
    }
    
    @IBAction func btnDone(_ sender: UIButton) {
        
        // 어떤거를 넘겨줄지를 여기서 정하는 것이다.
//        delegate?.didMessageEditDone(self, message: tfMessage.text!)
        delegate?.didEditDone(self, model: Model(isOn: isOn ,message: tfMessage.text))
        navigationController?.popViewController(animated: true)
    }
    
    @IBAction func swImageOff(_ sender: UISwitch) {
        
        if sender.isOn{
            isOn = true
            lblState.text = "On"
        }else{
            isOn = false
            lblState.text = "Off"
        }
    }
    
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
