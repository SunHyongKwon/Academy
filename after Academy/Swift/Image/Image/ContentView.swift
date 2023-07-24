//
//  ContentView.swift
//  Image
//
//  Created by 권순형 on 2023/03/29.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        // Step 1: SF Symbols
        //        Image(systemName: "cloud.heavyrain")
        //            .font(.system(size: 100))
        //            .foregroundColor(.blue)
        //            .shadow(color: .gray, radius: 4, x: 1, y: 10)
        
        // Step 2: 일반 이미지
        //        Image("paris")
        //            .resizable()
        //            .edgesIgnoringSafeArea(.all)
        ////            .aspectRatio(contentMode: .fit)
        //            .aspectRatio(contentMode: .fill)
        //            .frame(width: 300)
        //            .clipped()
        
        // Step 3: 일반 이미지 Filtering
        //        Image("paris")
        //            .resizable()
        //            .edgesIgnoringSafeArea(.all)
        ////            .aspectRatio(contentMode: .fit)
        //            .aspectRatio(contentMode: .fill)
        //            .frame(width: 300)
        //            .clipped()
        ////            .cornerRadius(200)
        //            .clipShape(Capsule())
        //            .opacity(0.5) // 투명도
        
        // Step 4: Overlay with SF Symbols
        //        Image("paris")
        //            .resizable()
        //            .edgesIgnoringSafeArea(.all)
        //            .aspectRatio(contentMode: .fill)
        //            .frame(width: 300)
        //            .clipped()
        //            .clipShape(Circle())
        //            .opacity(0.5)
        //            .overlay(
        //                Image(systemName: "heart.fill"))
        //            .font(.system(size: 50))
        //            .foregroundColor(.pink)
        //            .opacity(0.5)
        
        // Step 5 : Overlay with Text
        //        Image("paris")
        //            .resizable()
        //            .aspectRatio(contentMode: .fit)
        //            .overlay(
        //                Text("If you are lucky enough to have lived in Paris as a young man, then wherever you go for the rest of your life it stays with you, for Paris is a moveab le feast.\n\n- Ernest Hemingway")
        //                .font(.system(.headline , design: .rounded))
        //                .fontWeight(.bold)
        //                .foregroundColor(.white)
        //                .padding() // font에 대한 패딩
        //                .background(.black)
        //                .cornerRadius(10)
        //                .opacity(0.7)
        //                .padding() // 박스에 대한 패딩 !!! 순서가 중요하다 !!!!
        //            ,
        //                alignment: .top
        //            )
        
        // Step 6 : Darken an Image Using Overlay
        Image("paris")
            .resizable()
            .aspectRatio(contentMode: .fit)
            .overlay(
                Rectangle()
                    .opacity(0.4)
                    .overlay(
                        Text("Paris")
                            .font(.largeTitle)
                            .fontWeight(.black)
                            .foregroundColor(.white)
                    )
                
            )
    }
    
}

// 실제 빌드할 때는 이거 없이 나간다잇
struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

