//
//  Model.swift
//  Table
//
//  Created by 권순형 on 2023/02/18.
//

import Foundation

struct Model{
    var imageFileName:String?
    var text:String?
    
    // 생성자
    init(imageFileName: String? = nil, text: String? = nil) {
        self.imageFileName = imageFileName
        self.text = text
    }
}
