//
//  ContentView.swift
//  Stacks_01
//
//  Created by 권순형 on 2023/03/29.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack(alignment: .leading, spacing : 2){
            HeaderView(text: "Choose")
            HeaderView(text: "Your Plan")
            HStack{
                ButtonView(
                    title: "Basic",
                    price: "$9",
                    desc: "per month",
                    color: colorChange ? .white : .purple,
                    fontColor: fontChange ? .black : .white
                )
                ButtonView(
                    title: "Pro",
                    price: "$18",
                    desc: "per month" ,
                    color: colorChange ? .purple : .white ,
                    fontColor: fontChange ? .white : .black
                )
            }
            .onTapGesture(perform: {
                colorChange.toggle()
                fontChange.toggle()
            })
        }
        .padding()
    }
    
    @State var colorChange: Bool = false
    @State var fontChange: Bool = false
    
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}


struct HeaderView : View {
    var body : some View {
        Text(text)
            .font(.system(.largeTitle, design: .rounded))
            .fontWeight(.black)
    }
    
    var text : String
    
    init(text : String) {
        self.text = text
    }
}

struct ButtonView : View {
    var body : some View {
        VStack{
            Text(title)
                .font(.system(.title, design: .rounded))
                .fontWeight(.black)
                .foregroundColor(fontColor)
            Text(price)
                .font(.system(size : 40, weight: .heavy))
                .fontWeight(.black)
                .foregroundColor(fontColor)
            Text(desc)
                .font(.headline)
                .fontWeight(.black)
                .foregroundColor(fontColor)
        }
        .padding(40)
        .background(color)
        .cornerRadius(10)
        .frame(minWidth: 0,maxWidth: .infinity, minHeight: 100)
    }
    
    var title : String
    var price : String
    var desc : String
    var color : Color
    var fontColor : Color

    
    // 요게 필요 없음
//    init(title : String , price : String , desc : String , color : Color , fontColor : Color, subColor : Color ){
//        self.title = title
//        self.price = price
//        self.desc = desc
//        self.color = color
//        self.fontColor = fontColor
//        self.subColor = subColor
//    }
}
