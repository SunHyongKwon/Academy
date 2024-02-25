//
//  ViewController.swift
//  TabBar
//
//  Created by 권순형 on 2023/02/18.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func btnGoImageView(_ sender: UIButton) {
        // tabBar controller는 tabbar로 연결되면 자동으로 만들어 진다고 생각하면 된다.
        // index는 0부터 시작된다.
        tabBarController?.selectedIndex = 1
    }
    
    @IBAction func btnGoCalc(_ sender: UIButton) {
        tabBarController?.selectedIndex = 2
    }
}

