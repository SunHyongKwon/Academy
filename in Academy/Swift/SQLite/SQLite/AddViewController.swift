//
//  AddViewController.swift
//  SQLite
//
//  Created by 권순형 on 2023/02/19.
//

import UIKit

class AddViewController: UIViewController {
    @IBOutlet weak var tfDept: UITextField!
    
    @IBOutlet weak var tfPhone: UITextField!
    @IBOutlet weak var tfName: UITextField!
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
    @IBAction func btnAdd(_ sender: UIButton) {
        let db = StudentsDB()
        
        db.insert(name: tfName.text!,
                  dept: tfDept.text!,
                  phone: tfPhone.text!)
        
        
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
