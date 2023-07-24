//
//  ViewController.swift
//  BMI
//
//  Created by 권순형 on 2023/02/18.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var imageView: UIImageView!
    @IBOutlet weak var lblResult: UILabel!
    @IBOutlet weak var pickerView: UIPickerView!
    
    var height:[Int] = []
    var weight:[Int] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        lblResult.text = ""
        imageView.image = UIImage(named: "bmi.png")
        
        createData()
        pickerView.dataSource = self
        pickerView.delegate = self
        
        // pickerView의 초기값 Setting
        pickerView.selectRow(60 ,inComponent: 0,animated:true)
        pickerView.selectRow(40 ,inComponent: 1,animated: true)
        
    }

    func createData(){
        for i in 20...200{
            weight.append(i)
        }
        
        for i in 100...200{
            height.append(i)
        }
                   
    }
    
}

extension ViewController: UIPickerViewDataSource , UIPickerViewDelegate{
    
    
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 2
    }
    
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        if component == 0{
            return height.count
        }else{
            return weight.count
        }
    }
        
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        if component == 0{
            return String(height[row])
        }else{
            return String(weight[row])
        }
    }
    
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        var he = 0
        var we = 0
        
        if component == 0{
            he = height[row]
        }else{
            we = weight[row]
        }
        
        var bmi = we / ((he/100)*(he/100))
        
        lblResult.text = "신장은 \(he) 이고 몸무게는 \(we) 이고 BMI 수치는 \(bmi) 입니다."
        
    }
    
}

