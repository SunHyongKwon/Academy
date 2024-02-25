//
//  InsertModel.swift
//  FirebaseList
//
//  Created by 권순형 on 2023/02/19.
//

import Foundation
import Firebase

class InsertModel{
    let db = Firestore.firestore()
    
    
    func insert(_ code:String , name:String ,dept:String, phone:String) -> Bool {
        var status = true
        db.collection("students")
            .addDocument(data: [
                "code":code,
                "name":name,
                "dept":dept,
                "phone":phone
            ]){
                error in
                if error != nil{

                    status = false
                }else{
                    status = true
                }
            }
        
        return status
    }
}
