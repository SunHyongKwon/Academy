//
//  ViewController.swift
//  ServerImage_01
//
//  Created by 권순형 on 2023/02/19.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var imgView: UIImageView!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func btnNo2(_ sender: UIButton) {
    }
    
    
    // dispatchQueue 오류 잡는 방법
    @IBAction func btnNo1(_ sender: UIButton) {
        let url
        let defaultSession = Foundation.URLSession(configuration:  .default)
        
        let task defaultSession.dataTask(with: url!) { data, response, error in
            if error != null{
                print("Fail")
            }else{
                DispatchQueue.main.async {
                    imgView.image = data
                }
            }
        }
    }
}

