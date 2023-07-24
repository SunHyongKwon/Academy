//
//  ViewController.swift
//  Navigation
//
//  Created by 권순형 on 2023/02/18.
//

import UIKit

class ViewController: UIViewController {
     // 여기부터
    @IBOutlet weak var imgView: UIImageView!
    @IBOutlet weak var tfMessage: UITextField!
    
    let imgOn = UIImage(named: "lamp_on.png")
    let imgOff = UIImage(named: "lamp_off.png")
    var isOn = true
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        imgView.image = imgOn
    }
    // 여기까지는 화면이 처음 구성 될 때만 실행된다.
    
    // 버튼 으로 화면 넘기는 것을 여기서 할 필요는 없다.
    // 그거는 저기 뷰에서 끝나는 거다.
    
    // 화면이 뒤에 있다가 다시 앞에 나왔을 때 실행하는 함수
    // 처음 화면이 뜰때도 실행이 된다는 것을 알고 있어야 한다.
    override func viewWillAppear(_ animated: Bool) {
        tfMessage.text = Message.message
        isOn = Message.state
        if Message.state{
            imgView.image = imgOn
            
        }else{
            imgView.image = imgOff
        }
    }
    
    // 화면 넘길 때 사용되는 함수이다.
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        Message.message = tfMessage.text!
        Message.state = isOn
        
        if segue.identifier == "editButton"{
            Message.location = "Segue : Use Button!"
        }else{
            Message.location = "Segue : Use BarButton!"
        }
    }
    

    
} // ViewController

