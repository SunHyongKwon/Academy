//
//  JSONModel.swift
//  OpenWeather
//
//  Created by 권순형 on 2023/02/19.
//

import Foundation

struct WeatherJSON:Codable{
    let weather:[Weather] // list 타입일 때
    let main:Main // map 타입일 때
    let name:String
}

// Weather 객체 생성
struct Weather:Codable{
    let id:Int
    let main:String
    let description:String
    let icon:String
}

struct Main:Codable{
    let temp:Double
    let feels_like:Double
    let temp_min:Double
    let temp_max:Double
}
