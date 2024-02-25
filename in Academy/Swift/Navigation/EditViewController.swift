//
//  EditViewController.swift
//  Navigation
//
//  Created by 권순형 on 2023/02/18.
//

import UIKit

class EditViewController: UIViewController {

    @IBOutlet weak var swIsOn: UISwitch!
    @IBOutlet weak var lblState: UILabel!
    @IBOutlet weak var tfMessage: UITextField!
    @IBOutlet weak var lblLocation: UILabel!
    
    var isOn = Message.state
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        lblLocation.text = Message.location
        tfMessage.text = Message.message
        swIsOn.isOn = Message.state
        
        if Message.state{
            lblState.text = "On"
        }else{
            lblState.text = "Off"
        }
        // Do any additional setup after loading the view.
    }
    
    @IBAction func btnDone(_ sender: UIButton) {
        Message.message = tfMessage.text!
        Message.state = isOn
        navigationController?.popViewController(animated: true)
    }
    
    @IBAction func swImageOff(_ sender: UISwitch) {
        if sender.isOn{
            isOn = true
            lblState.text = "On"
        }else{
            isOn = false
            lblState.text = "Off"
        }
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
