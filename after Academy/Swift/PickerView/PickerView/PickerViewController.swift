//
//  ViewController.swift
//  PickerView
//
//  Created by 권순형 on 2023/02/16.
//

import UIKit

class PickerViewController: UIViewController {
    @IBOutlet weak var pickerImage: UIPickerView!
    
    @IBOutlet weak var lblImageFileName: UILabel!
    
    @IBOutlet weak var imageView: UIImageView!
    
    
    var imageFileName = [
        "w1.jpg",
        "w2.jpg",
        "w3.jpg",
        "w4.jpg",
        "w5.jpg",
        "w6.jpg",
        "w7.jpg",
        "w8.jpg",
        "w9.jpg",
        "w10.jpg"
    ]
    
    var imageArray = [UIImage?]()
    
    var count = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        // 화면 띄고 나서 이미지 불러오는 시간이 걸리면 안된다.
        // 그러므로 화면 띄우기 전에 이미지를 다 불러오고 띄우면 된다.
        for i in 0..<imageFileName.count{
            imageArray.append(UIImage(named: imageFileName[i]))
        }
        
        lblImageFileName.text = imageFileName[0]
        imageView.image = imageArray[0]
        
        pickerImage.dataSource = self
        pickerImage.delegate = self
    }

    
} // ViewController

// , 찍어서 한번에 넣을 수도 있다.
extension PickerViewController:UIPickerViewDataSource , UIPickerViewDelegate{
    
    // PickerView의 컬럼 갯수
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    // PickerView의 로우 갯수
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return imageFileName.count
    }
    
    func pickerView(_ pickerView: UIPickerView, rowHeightForComponent component: Int) -> CGFloat {
        return 150
    }
    
// picker view에 파일명 배치
//    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
//        return imageFileName[row]
//    }
    
    // picker view에 썸네일 배치
    func pickerView(_ pickerView: UIPickerView, viewForRow row: Int, forComponent component: Int, reusing view: UIView?) -> UIView {
        let imageView = UIImageView(image: imageArray[row])
        imageView.frame = CGRect(x: 0, y: 0, width: 200, height: 80)
        
        return imageView
    }
    
    // 선택된 파일명을 이미지로 보이기
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        
        imageView.image = imageArray[row]
        lblImageFileName.text = imageFileName[row]
        
    }
}

