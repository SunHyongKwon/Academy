//
//  QueryModel.swift
//  ServerJsonCardList
//
//  Created by 권순형 on 2023/02/19.
//

import Foundation

protocol QueryModelProtocol{
    func itemDownloaded(items: [DBModel])
}

class QueryModel {
    var delegate:QueryModelProtocol!
    let urlPath:String = "https://zeushahn.github.io/Test/ios/cards.json"
    
    func downloadItems() {
        let url: URL = URL(string: urlPath)!
        
        // url 에 가서 데이터 가져오는 거니까 비동기 처리 필요
        DispatchQueue.global().async {
            // 뭐가 들어올지 모르니까 최상단 오브젝트로 받는다.
            let data = try? Data(contentsOf: url)
            DispatchQueue.main.async {
                self.parseJSON(data!)
            }
        }
    }
    
    func parseJSON(_ data:Data){
        // json을 읽을 수 있는 변수 선언
        let decoder  = JSONDecoder()
        
        // json을 해독해서 넣을 모델 리스트 만들기
        var locations: [DBModel] = []
        
        // try catch 같은거
        do{
            // data의 json 모양을 studnet 모델의 리스트로 만든 것이다.
            let images = try decoder.decode([ImageJson].self, from: data)
            
            for image in images {
                let query = DBModel(dbImage: image.image , dbCategory: image.category, dbHeading: image.heading, dbAuthor: image.author)
                locations.append(query)
            }

        }catch let error{
            print("Fail : \(error.localizedDescription)")
        }
        
        DispatchQueue.main.async {
            self.delegate.itemDownloaded(items: locations)
        }
    }
}
