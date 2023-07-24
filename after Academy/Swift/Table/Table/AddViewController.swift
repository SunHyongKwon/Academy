//
//  AddViewController.swift
//  Table
//
//  Created by 권순형 on 2023/02/18.
//

import UIKit

protocol AddDelgate{
    func addDone(_ controller:AddViewController,model:Message)
}

class AddViewController: UIViewController {

    @IBOutlet weak var pickerImage: UIPickerView!
    @IBOutlet weak var tfAddItem: UITextField!
    
    @IBOutlet weak var imageView: UIImageView!
    
    var imageFileName = [
        "cart.png",
        "clock.png",
        "pencil.png"
    ]
    
    var imageArray = [UIImage?]()
    var imageName = "cart.png"
    
    var delegate:AddDelgate?
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        for i in 0..<imageFileName.count{
            imageArray.append(UIImage(named: imageFileName[i]))
        }
        
        imageView.image = imageArray[0]
        
        pickerImage.dataSource = self
        pickerImage.delegate = self
    }
    

    @IBAction func btnAddItem(_ sender: UIButton) {
        
        delegate?.addDone(self, model: Message(item: tfAddItem.text!,imtesImageFile: imageName))
        navigationController?.popViewController(animated: true)
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

extension AddViewController:UIPickerViewDataSource , UIPickerViewDelegate{
    
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
        imageView.frame = CGRect(x: 0, y: 0, width: 50, height: 50)
        
        return imageView
    }
    
    // 선택된 파일명을 이미지로 보이기
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        
        imageView.image = imageArray[row]
        imageName = imageFileName[row]
        
    }
}
