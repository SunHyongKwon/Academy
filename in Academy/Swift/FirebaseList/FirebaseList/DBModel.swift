//
//  DBModel.swift
//  FirebaseList
//
//  Created by 권순형 on 2023/02/19.
//

import Foundation

struct DBModel{
    
    // key 값 위해
    var documentId:String
    
    // db 값들
    var code:String
    var name:String
    var dept:String
    var phone:String
    
    init(documentId: String, code: String, name: String, dept: String, phone: String) {
        self.documentId = documentId
        self.code = code
        self.name = name
        self.dept = dept
        self.phone = phone
    }
    
    init(code: String, name: String, dept: String, phone: String) {
        self.documentId = ""
        self.code = code
        self.name = name
        self.dept = dept
        self.phone = phone
    }
}
