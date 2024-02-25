//
//  ViewController.swift
//  AlertActionSheet
//
//  Created by 권순형 on 2023/02/16.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    // 전체를 controller
    // 버튼을 action
    @IBAction func btnAlert(_ sender: UIButton) {
        // controller 만들기
        let testAlert = UIAlertController(title: "Title", message: "Message", preferredStyle: .alert)
        // 버튼 만들기
        let actionDefault = UIAlertAction(title: "Action Default", style: .default)
        let actionDestructive = UIAlertAction(title: "Action Destructive", style: .destructive,handler: {
            ACTION
            in
            print("destructive action called")
        })
        let actionCancel = UIAlertAction(title: "Action Cancel",style: .cancel)
        
        testAlert.addAction(actionDefault)
        testAlert.addAction(actionDestructive)
        testAlert.addAction(actionCancel)
        
        present(testAlert,animated: true)
    }
    
    @IBAction func btnActionSheet(_ sender: UIButton) {
        let testActionSheet = UIAlertController(title: "Title", message: "Message", preferredStyle: .actionSheet)
        
        let actionDefault = UIAlertAction(title: "Action Default", style: .default)
        let actionCancel = UIAlertAction(title: "Action Cancel", style: .cancel)
        let actionDestructive = UIAlertAction(title: "Action Destructive", style: .destructive)
        
        testActionSheet.addAction(actionDefault)
        testActionSheet.addAction(actionCancel)
        testActionSheet.addAction(actionDestructive)
        
        present(testActionSheet,animated: true)
        
    }
    
}

