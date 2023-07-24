//
//  ViewController.swift
//  Quiz06
//
//  Created by 권순형 on 2023/02/14.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var imgView: UIImageView!
    @IBOutlet weak var btnSize: UIButton!
    
    var isZoom = false
    var imgOn:UIImage? // 켜진 전구 이미지
    var imgOff:UIImage? // 켜진 전구 이미지
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        isZoom = false
        // 이미지 연결
        imgOn = UIImage(named: "lamp_off.png")
        imgOff = UIImage(named: "lamp_on.png")
        
        imgView.image = imgOn
    }
    

    @IBAction func btnResize(_ sender: UIButton) {
        let scale:CGFloat = 2.0
        var newWidth:CGFloat?
        var newHeight:CGFloat?
        
        if isZoom{
            newWidth = imgView.frame.width / scale
            newHeight = imgView.frame.height / scale
            
            btnSize.setTitle("축소", for: .normal)
            
        }else{
            newWidth = imgView.frame.width * scale
            newHeight = imgView.frame.height * scale
            
            btnSize.setTitle("확대", for: .normal)
        }
        
        imgView.frame.size = CGSize(width: newWidth!, height: newHeight!)
        
        isZoom = !isZoom
    }
    
    @IBAction func swithImageOnOff(_ sender: UISwitch) {
        // sender switch의 state를 알려준다.
//        if sender.isOn{
//            imgView.image = imgOn
//        }else{
//            imgView.image = imgOff
//        }
        
        switch sender.isOn{
        case true:
            imgView.image = imgOn
        default:
            imgView.image = imgOff
        }
        
    }
}

