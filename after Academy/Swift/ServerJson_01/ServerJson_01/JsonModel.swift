//
//  JsonModel.swift
//  ServerJson_01
//
//  Created by 권순형 on 2023/02/18.
//

import Foundation

// json과 여기 변수값이 같아야 된다.
struct Student: Codable{
    var code:String
    var phone:String
    var name:String
    var dept:String
}
