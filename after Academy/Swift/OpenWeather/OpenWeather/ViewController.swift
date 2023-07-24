//
//  ViewController.swift
//  OpenWeather
//
//  Created by 권순형 on 2023/02/19.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var minTemp: UILabel!
    @IBOutlet weak var maxTemp: UILabel!
    @IBOutlet weak var lblTemparature: UILabel!
    @IBOutlet weak var lblWeather: UILabel!
    @IBOutlet weak var lblCity: UILabel!
    @IBOutlet weak var myActivityIndicator: UIActivityIndicatorView!
    @IBOutlet weak var tfCity: UITextField!
    
    var locations:[DBModel] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        cleanUpLabel()
        myActivityIndicator.isHidden = true
    }
    
    func cleanUpLabel(){
        minTemp.text = ""
        maxTemp.text = ""
        lblTemparature.text = ""
        lblWeather.text = ""
        lblCity.text = ""
    }

    @IBAction func btnGetWeather(_ sender: UIButton) {
        myActivityIndicator.startAnimating()
        myActivityIndicator.isHidden = false
        
        let queryModel = QueryModel()
        queryModel.delegate = self
        queryModel.downloadItems(cityName: tfCity.text!)
    }
    
}

extension ViewController:QueryModelProtocol{
    func itemDownloaded(items: [DBModel]) {
        minTemp.text = String(Int(items[0].r_temp_min - 273.15))
        maxTemp.text = String(Int(items[0].r_temp_max - 273.15))
        lblCity.text = items[0].r_name
        lblTemparature.text = String(Int(items[0].r_temp - 273.15))
        lblWeather.text = items[0].r_description
        
        myActivityIndicator.stopAnimating()
        myActivityIndicator.isHidden = true
    }
    
    
}

