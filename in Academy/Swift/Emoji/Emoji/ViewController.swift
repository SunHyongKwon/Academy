//
//  ViewController.swift
//  Emoji
//
//  Created by 권순형 on 2023/02/09.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var emojiLbl: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        emojiLbl.text = ""
        view.backgroundColor = .blue
    }

    @IBAction func btnThree(_ sender: UIButton, forEvent event: UIEvent) {
        emojiLbl.text! += "🤐" // ! forced unwrapping 이라고 한다.
        view.backgroundColor = .red
    }
    
    @IBAction func btnOne(_ sender: UIButton, forEvent event: UIEvent) {
        emojiLbl.text?.append("😍")
        view.backgroundColor = .green
    }
    
    @IBAction func btnTwo(_ sender: UIButton, forEvent event: UIEvent) {
        emojiLbl.text?.append("🥳")
        view.backgroundColor = .yellow
    }
}

