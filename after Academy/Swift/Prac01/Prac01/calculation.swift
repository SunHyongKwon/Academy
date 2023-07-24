//
//  calculation.swift
//  Prac01
//
//  Created by 권순형 on 2023/02/14.
//

import Foundation


class Calculation{
    
    func calc(_ num1:String? ,_ num2:String?)-> [Float]{
        var anum1 = Float(num1!) ?? 0
        var anum2 = Float(num2!) ?? 0
        
        var list = [Float]()
        
        list.append(anum1+anum2)
        list.append(anum1-anum2)
        list.append(anum1*anum2)
        list.append(anum1/anum2)
        
        return list
    }
    
}
