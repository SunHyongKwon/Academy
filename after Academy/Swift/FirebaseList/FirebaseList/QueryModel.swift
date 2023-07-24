//
//  QueryModel.swift
//  FirebaseList
//
//  Created by 권순형 on 2023/02/19.
//

import Foundation
import Firebase

protocol QueryModelProtocol{
    func itemDownloaded(items:[DBModel])
}

class QueryModel{
    var delegate:QueryModelProtocol!
    let db = Firestore.firestore()
    
    
    func downloadItmes(){
        var locations:[DBModel] = []
        
        // collection 이름 가져온다.
        db.collection("students")
            .order(by: "code")
            .getDocuments(completion: {
                (querySnapshot, err) in
                if let err = err{
                    print("error getting documents: \(err)")
                }else{
                    print("data is downloaded.")
                    for document in querySnapshot!.documents{
                        guard let data = document.data()["code"] else {return}
                        
                        print("\(document.documentID) => \(data)")
                        
                        let query = DBModel(documentId: document.documentID ,
                                            code: document.data()["code"] as! String,
                                            name: document.data()["name"] as! String,
                                            dept: document.data()["dept"] as! String,
                                            phone: document.data()["phone"] as! String)
                        
                        locations.append(query)
                    }
                    
                    self.delegate.itemDownloaded(items: locations)

                }
            })
        
        
    }
    
}
