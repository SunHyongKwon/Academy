//
//  calculation.swift
//  Quiz07
//
//  Created by 권순형 on 2023/02/14.
//

import Foundation


class Calculation{
    
    // 내부적으로 쓰는 파라미터 값은 뒤애 오는 것이다.
    func add(숫자1 num1:String? ,숫자2 num2:String?) -> String {
        
        let anum = Int(num1!) ?? 0
        let bnum = Int(num2!) ?? 0
        
        return String(anum + bnum)
        
    }
    
}
