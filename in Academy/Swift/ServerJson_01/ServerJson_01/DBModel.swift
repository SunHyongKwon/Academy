//
//  DBModel.swift
//  ServerJson_01
//
//  Created by 권순형 on 2023/02/18.
//

import Foundation

class DBModel{
    var scode:String
    var sname:String
    var sdept:String
    var Sphone:String
    
    init(scode: String, sname: String, sdept: String, Sphone: String) {
        self.scode = scode
        self.sname = sname
        self.sdept = sdept
        self.Sphone = Sphone
    }
}
