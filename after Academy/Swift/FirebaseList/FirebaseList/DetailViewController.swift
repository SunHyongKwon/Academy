//
//  DetailViewController.swift
//  FirebaseList
//
//  Created by 권순형 on 2023/02/19.
//

import UIKit

class DetailViewController: UIViewController {
    
    @IBOutlet weak var tfPhone: UITextField!
    @IBOutlet weak var tfDept: UITextField!
    @IBOutlet weak var tfName: UITextField!
    @IBOutlet weak var tfCode: UITextField!
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        tfPhone.text = Message.phone
        tfDept.text = Message.dept
        tfCode.text = Message.code
        tfName.text = Message.name
        
        tfDept.isUserInteractionEnabled = false
    }
    
    @IBAction func btnUpdate(_ sender: UIButton) {
        guard let code = tfCode.text else {return}
        guard let name = tfName.text else {return}
        guard let dept = tfDept.text else {return}
        guard let phone = tfPhone.text else {return}
        
        print(code)
        
        if !code.trimmingCharacters(in: .whitespaces).isEmpty{
            let updateModel = UpdateModel()
            
            let result = updateModel.update(Message.documentId, code: code, name: name, dept: dept, phone: phone)
            
            if result{
                let resultAlert = UIAlertController(title: "완료",
                                                    message: "성공했다.", preferredStyle: .alert)
                
                let onAction = UIAlertAction(title: "OK",
                                             style: .default,
                                             handler: {
                    ACTION in self.navigationController?.popViewController(animated: true)
                }
                )
                
                resultAlert.addAction(onAction)
                
                present(resultAlert,animated: true)
                
            }else{
                let resultAlert = UIAlertController(title: "오류",
                                                    message: "실패했다.", preferredStyle: .alert)
                
                let onAction = UIAlertAction(title: "AGAIN", style: .default)
                
                resultAlert.addAction(onAction)
                
                present(resultAlert,animated: true)
            }
        }
    }
    
    @IBAction func btnDelete(_ sender: UIButton) {
        
        let deleteModel = DeleteModel()
        deleteModel.delete(documentId: Message.documentId)
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
