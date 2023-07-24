//
//  DeleteModel.swift
//  FirebaseList
//
//  Created by 권순형 on 2023/02/19.
//

import Foundation
import Firebase

class DeleteModel{
    let db = Firestore.firestore()
    
    
    func delete(documentId: String) -> Bool {
        var status:Bool = true
    
        db.collection("students").document(documentId).delete()
        {error in
            if error != nil{

                status = false
            }else{
                status = true
            }
        }
        
        return status
    }
}
