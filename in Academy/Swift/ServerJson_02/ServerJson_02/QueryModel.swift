//
//  QueryModel.swift
//  ServerJson_02
//
//  Created by 권순형 on 2023/02/18.
//

import Foundation

// view에 값을 넘겨주기 위해서 필요
protocol QueryModelProtocol{
    func select(models:[DBModel])
}

// QueryModelProtocol을 implement 받는다고 생각하면된다.
class QueryModel{
    var delegate: QueryModelProtocol!
    let urlpath = "https://zeushahn.github.io/Test/ios/student.json"
    
    // restAPI 방식으로 데이터 가져오기
    func openURL(){
        // url 변수 만들기
        let url = URL(string: urlpath)
        
        // restAPI 할려면 비동기 방식으로 해서 열 때 까지 기다려야 된다.
        // 그때 사용되는 것이 DispatchQueue 클래스
        // 약간 비동기 처리 되는것을 관리해준다 생각하면 된다.
        DispatchQueue.global().async {
            // 이제 비동기로 데이터를 받아와야 겠지??
            // try? 가 await 같은 거라고 생각하면 된다.
            let data = try? Data(contentsOf: url!)
            DispatchQueue.main.async {
                // 이제 이거를 json으로 parse 해서 DBModel로 만들어 줘야 됨
                self.toJSON(data!)
            }
        }
    }
    
    // JSON을 DBModel로 변경하기
    func toJSON(_ data:Data){
        let decoder = JSONDecoder()
        
        // DBModel 변경해서 받을 리스트가 필요
        var list :[DBModel] = []
        
        // data -> json(jsonmodel) -> DBModel로 하나하나 바꿔줘야 된다.
        // 굳이 이럴필요는 없는 듯
        // 그냥 한방에 해도 되는데 몬가 model과 view model 나눠 준것 같다.
        do{
            let students = try decoder.decode([Student].self, from: data)
            
            for student in students {
                list.append(DBModel(scode: student.code, sname: student.name, sphone: student.phone, sdept: student.dept))
            }
            
        }catch let error{
            print("error : \(error.localizedDescription)")
        }
        self.delegate.select(models: list)
        
    }
    
    
    // 그래서 그거를 protocol을 이용해서 view에 넘겨주면 된다.
    
}
