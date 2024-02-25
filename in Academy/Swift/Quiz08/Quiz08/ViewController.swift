//
//  ViewController.swift
//  Quiz08
//
//  Created by 권순형 on 2023/02/14.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var imgView: UIImageView!
    @IBOutlet weak var nextView: UIImageView!
    @IBOutlet weak var imgTitle: UILabel!
    @IBOutlet weak var prevBtn: UIButton!
    @IBOutlet weak var nextBtn: UIButton!
    
    var images = [
        "flower_01.png",
        "flower_02.png",
        "flower_03.png",
        "flower_04.png",
        "flower_05.png",
        "flower_06.png"
    ]
    
    var count = 0
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        displayImage()
    }
    
    // 버튼 많을 때 같이 쓰는 법
    @IBAction func buttons(_ sender: UIButton) {
        
        if sender == prevBtn {
            count -= 1
            if count < 0 {
                count = images.count - 1
            }
        } else{
            count += 1
        }
        
        displayImage()
    }
    
    
    // ------------- func
    func displayImage(){
        imgTitle.text = images[count%6]
        imgView.image = UIImage(named: images[count%6])
        nextView.image = UIImage(named: images[(count+1)%6])
    }
    
}

