//
//  DetailViewController.swift
//  SQLite
//
//  Created by 권순형 on 2023/02/19.
//

import UIKit

class DetailViewController: UIViewController {

    @IBOutlet weak var tfName: UITextField!
    @IBOutlet weak var tfDept: UITextField!
    @IBOutlet weak var tfPhone: UITextField!
    @IBOutlet weak var tfCode: UITextField!
    
    var receiveId = 0
    var receiveName = ""
    var receiveDept = ""
    var receivePhone = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        tfCode.isUserInteractionEnabled = false
        tfCode.text = String(receiveId)
        tfName.text = String(receiveName)
        tfDept.text = String(receiveDept)
        tfPhone.text = String(receivePhone)
    }
    
    @IBAction func btnDelete(_ sender: UIButton) {
        let db = StudentsDB()
        db.delete(code: receiveId)
        
    }
    
    @IBAction func btnUpdate(_ sender: UIButton) {
        let db = StudentsDB()
        db.update(code: receiveId, name: tfName.text!, dept: tfDept.text!, phone: tfPhone.text!)
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
