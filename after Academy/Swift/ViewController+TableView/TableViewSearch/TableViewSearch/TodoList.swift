//
//  TodoList.swift
//  TableViewSearch
//
//  Created by Kenny on 2023/03/05.
//

import Foundation

struct TodoList{
    var id: Int
    var content: String
    var did: Int
    var icon: String
    
    init(id: Int, content: String, did: Int, icon: String) {
        self.id = id
        self.content = content
        self.did = did
        self.icon = icon
    }
    
}
