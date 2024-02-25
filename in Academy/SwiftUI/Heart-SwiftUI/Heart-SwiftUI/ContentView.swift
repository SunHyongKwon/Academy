//
//  ContentView.swift
//  Heart-SwiftUI
//
//  Created by Jeong Yun Hyeon on 2023/03/29.
//

import SwiftUI

struct ContentView: View {
    
    @State var colorChange: Bool = false
    @State var sizeChange: Bool = false
    
    var body: some View {
        VStack {
            Image(systemName: "heart.fill")
                .font(.system(size: 200))
                .foregroundColor(colorChange ? .yellow : .red)
                .scaleEffect(sizeChange ? 1.5 : 1)
                .animation(.easeInOut(duration: 0.5), value: sizeChange)
                .onTapGesture(perform: {
                    colorChange.toggle()
                })
                .onLongPressGesture(perform: {
                    sizeChange.toggle()
                })
            Text("sdfghuikosdfghjkcvbnmdfghj")
                .fontWeight(.bold)
                .font(.system(size: 50))
                .foregroundColor(.green)
                .multilineTextAlignment(.trailing)
                .padding()
                .rotation3DEffect(.degrees(180), axis: (1,0,0))
                .shadow(color: .gray, radius: 2, x: 0, y: 5)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
