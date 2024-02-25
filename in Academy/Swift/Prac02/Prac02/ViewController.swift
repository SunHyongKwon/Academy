//
//  ViewController.swift
//  Prac02
//
//  Created by 권순형 on 2023/02/16.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var imageView: UIImageView!
    
    var state = true
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        imageView.image = UIImage(named: "lamp_off.png")
        
    }

    @IBAction func btnOn(_ sender: UIButton) {
        if !state{
            
            let alert = UIAlertController(title: "램프 켜기", message: "램프를 켜시겠습니까?", preferredStyle: .alert)
            let actionOne = UIAlertAction(title: "네", style: .default,handler: {
                ACTION
                in
                self.imageView.image = UIImage(named: "lamp_off.png")
                self.state = true
            })
            let actionTwo = UIAlertAction(title: "아니오", style: .default)
            
            alert.addAction(actionOne)
            alert.addAction(actionTwo)
            
            present(alert, animated: true)
            
            
        }else{
            let alert = UIAlertController(title: "경고", message: "램프가 꺼진 상태 입니다.", preferredStyle: .alert)
            let actionTwo = UIAlertAction(title: "네, 알겠습니다", style: .default)
            
            alert.addAction(actionTwo)
            
            present(alert, animated: true)
        }
        
    }
    
    @IBAction func btnOff(_ sender: UIButton) {
        if state{
            
            let alert = UIAlertController(title: "램프 끄기", message: "램프를 끄시겠습니까?", preferredStyle: .alert)
            let actionOne = UIAlertAction(title: "네", style: .default,handler: {
                ACTION
                in
                self.imageView.image = UIImage(named: "lamp_on.png")
                self.state = false
            })
            let actionTwo = UIAlertAction(title: "아니오", style: .default)
            
            alert.addAction(actionOne)
            alert.addAction(actionTwo)
            
            present(alert, animated: true)
            
            
        }else{
            let alert = UIAlertController(title: "경고", message: "램프가 꺼진 상태 입니다.", preferredStyle: .alert)
            let actionTwo = UIAlertAction(title: "네, 알겠습니다", style: .default)
            
            alert.addAction(actionTwo)
            
            present(alert, animated: true)
        }
        
    }
}

