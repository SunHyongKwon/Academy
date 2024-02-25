//
//  ViewController.swift
//  Quiz09
//
//  Created by 권순형 on 2023/02/16.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var lblPickerTime: UILabel!
    
    @IBOutlet weak var lblCurrentTime: UILabel!
    
    var count = 0
    var alarmTime: String?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        // 시간 간격 1초
        let interval = 1.0
        
        // timeselector 정의
        let timeSelector : Selector =  #selector(ViewController.updateTime)
        
        // 시작하고 1초 2초 이렇게 보여주는 거 현재시간을 불러와서 이걸 더하면 되겠네??
        Timer.scheduledTimer(timeInterval: interval,
                             target: self,
                             selector: timeSelector,
                             userInfo: nil,
                             repeats: true
                            )
    }


    @IBAction func changeDatePicker(_ sender: UIDatePicker) {
        let datePickerView = sender
        
        let formatter = DateFormatter()
        
        formatter.locale = Locale(identifier: "ko")
        
        formatter.dateFormat = "yyyy-mm-dd EEE a hh:mm:ss" // E : 요일 , a : am , pm
        lblPickerTime.text = "고른시간 : \(formatter.string(from: datePickerView.date as Date))"
        
        formatter.dateFormat = "a hh:mm"
        alarmTime = formatter.string(from: datePickerView.date as Date)
    }
    
    
    // 1초에 한번씩 함수가 불려온다.
    @objc func updateTime() {
        count += 1
        
        let date = NSDate()
        let formatter = DateFormatter()
        
        formatter.locale = Locale(identifier: "ko")
        
        formatter.dateFormat = "yyyy-mm-dd EEE a hh:mm:ss" // E : 요일 , a : am , pm
        lblCurrentTime.text = "현재시간 : \(formatter.string(from: date as Date))"
        
        formatter.dateFormat = "a hh:mm"
        let currentTime = formatter.string(from: date as Date)
        
        if alarmTime == currentTime{
            if count % 2 == 0{
                view.backgroundColor = .red
            }else{
                view.backgroundColor = .blue
            }
        }else{
            view.backgroundColor = .white
        }
        
    }
    
}

