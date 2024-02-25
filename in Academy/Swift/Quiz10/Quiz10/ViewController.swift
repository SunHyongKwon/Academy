//
//  ViewController.swift
//  Quiz10
//
//  Created by 권순형 on 2023/02/16.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var imageView: UIImageView!
    
    let images = [
        "flower_01.png",
        "flower_02.png",
        "flower_03.png",
        "flower_04.png",
        "flower_05.png",
        "flower_06.png"
    ]
    
    var count = 0
    var interval = 3.0
    
    @IBOutlet weak var tfTime: UITextField!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        imageView.image = UIImage(named: images[0])
        
        // 시간 간격 1초
        
        
        // timeselector 정의
        let timeSelector : Selector =  #selector(ViewController.updateTime)
        
        // 시작하고 1초 2초 이렇게 보여주는 거 현재시간을 불러와서 이걸 더하면 되겠네??
        Timer.scheduledTimer(timeInterval: interval,
                             target: self,
                             selector: timeSelector,
                             userInfo: nil,
                             repeats: true
                            )
    }
    
    @IBAction func toFirst(_ sender: UIButton) {
        imageView.image = UIImage(named: images[0])
        count = 0
    }
    
    @IBAction func changeInterval(_ sender: UIButton) {
        interval = Double(tfTime.text!) ?? 3.0
        viewDidLoad()
    }
    
    
    @objc func updateTime(){
        count += 1
        
        if count < 6{
            imageView.image = UIImage(named: images[count])
        }else{
            count = 0
            imageView.image = UIImage(named: images[count])
        }
        
        
    }
    

}

