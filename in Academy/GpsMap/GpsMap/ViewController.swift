//
//  ViewController.swift
//  GpsMap
//
//  Created by Kenny on 2023/03/22.
//

import UIKit
import MapKit // <<<<

class ViewController: UIViewController {

    @IBOutlet weak var locationGo: UISegmentedControl!
    @IBOutlet weak var myMap: MKMapView!
    @IBOutlet weak var addr1: UILabel!
    @IBOutlet weak var addr2: UILabel!
    
    let myLoc = CLLocationManager()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        myLoc.delegate = self
        myLoc.requestWhenInUseAuthorization() // 승인 허용 문구 받아서 처리
        myLoc.startUpdatingLocation() // GPS 좌표 받기 시작
        myMap.showsUserLocation = true  // 지도에서 현재 위치 보이기
        
        // 현재 위치 좌표
        print("--- lng, lat ---")
        print(myLoc.location?.coordinate.longitude as Any)
        print(myLoc.location?.coordinate.latitude as Any)
        print("----------------")
        // 더조은 학원 좌표 : 현재 위치로 설정
        //mapMove(37.494904, 127.030396, "더조은 컴퓨터 학원")

    }
    
    func mapMove(_ lat: CLLocationDegrees, _ lon: CLLocationDegrees, _ tLoc: String){
        let pLoc = CLLocationCoordinate2DMake(lat, lon)
        
        // 배율
        let pSpan = MKCoordinateSpan(latitudeDelta: 0.02, longitudeDelta: 0.02)
        
        // 좌표정보
        let pRegion = MKCoordinateRegion(center: pLoc, span: pSpan)
        
        // 현재 지도를 좌표 정보로 보기
        myMap.setRegion(pRegion, animated: true)
        
        // 주소 가져오기
        let addrLoc = CLLocation(latitude: lat, longitude: lon)
        addr1.text = tLoc
        
        CLGeocoder().reverseGeocodeLocation(addrLoc, completionHandler: {place, error in
            let pm = place?.first
            
            self.addr2.text = "\(pm!.country!) \(pm!.locality!) \(pm!.thoroughfare!)"
        })
        
        // 위치 Pin
        setPoint(pLoc, tLoc, addr2.text!)
    }

    func setPoint(_ loc: CLLocationCoordinate2D, _ tLoc1: String, _ tLoc2: String){
        let pin = MKPointAnnotation()
        
        pin.coordinate = loc
        pin.title = tLoc1
//        pin.subtitle = tLoc2
        
        myMap.addAnnotation(pin)
    }
    

    @IBAction func locationGo(_ sender: UISegmentedControl) {
        if sender.selectedSegmentIndex == 0{
            myLoc.startUpdatingLocation() // 내 위치 업데이트 시키기
        }else if sender.selectedSegmentIndex == 1{
            mapMove(37.65243153, 127.0276397, "둘리 뮤지엄")
        }else{
            mapMove(37.57244171, 126.9595412, "서대문 형무소 역사관")
        }
    }
} // ViewController

extension ViewController: CLLocationManagerDelegate{
    func locationManager(_ manager: CLLocationManager, didUpdateLocations locations: [CLLocation]) {
        let lastLoc = locations.last
        mapMove(lastLoc!.coordinate.latitude, lastLoc!.coordinate.longitude, "현재위치")
        myLoc.stopUpdatingLocation() // 좌표 받기 중지
    }
}
