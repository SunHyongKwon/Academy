//
//  ViewController.swift
//  Computer
//
//  Created by 권순형 on 2023/02/07.
//

import UIKit

class ViewController: UIViewController {
    
    // 상단에는 바뀔 위젯들을 선언한다.
    @IBOutlet weak var bagTf: UITextField!
    @IBOutlet weak var weightTf: UITextField!
    @IBOutlet weak var sizeTf: UITextField!
    @IBOutlet weak var productNameTf: UITextField!
    @IBOutlet weak var colorTf: UITextField!
    
    @IBOutlet weak var clearBtn: UIButton!
    @IBOutlet weak var okBtn: UIButton!
    
    let pcName:String = "맥북프로"
    let pcSize:Int = 16
    let pcWeight:Double = 2.56
    let pcBag:Bool = false
    let pcColor:Character = "백"
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    

    @IBAction func clearBtn(_ sender: UIButton) {
        bagTf.text = ""
        productNameTf.text = ""
        sizeTf.text = ""
        weightTf.text = ""
        colorTf.text = ""
    }
    
    @IBAction func okBtn(_ sender: UIButton) {
        bagTf.text = String(pcBag)
        productNameTf.text = pcName
        sizeTf.text = String(pcSize)
        weightTf.text = String(pcWeight)
        colorTf.text = String(pcColor)
    }
}

