//
//  ContentView.swift
//  Instargram01
//
//  Created by 권순형 on 2023/04/05.
//


import SwiftUI
import URLImage

/// 1. data 가져오는게 지금 한 struct 안에 다 있잖아요.
///     근데 아마 분리가 되어야 되지 않을까라고 생각을 하는데
///     다른 클래스로 분리했을 때 , protocol delegate 사용하는 방법을 좀 알아야 함
///  2. 내일은 View 관련 해서 정리
///
struct ContentView: View{
    @State var items: [Shoe] = []
    @State private var currentIndex: Int = 0
    
    var body: some View {
        List(items, id: \.model) { item in
            VStack {
                ZStack{
                    GeometryReader { geo in
                        ScrollView(.horizontal, showsIndicators: false) {
                            LazyHStack(spacing: 100) {
                                ForEach(item.images, id: \.self) { imageUrl in
                                    URLImage(URL(string: imageUrl)!) { image in
                                        image
                                            .resizable()
                                            .aspectRatio(contentMode: .fill)
                                            .frame(width: geo.size.width - 40, height: 300)
                                            .cornerRadius(30)
                                    }
                                }
                            }
                            .padding(.horizontal, 20)
                            .gesture(DragGesture()
                                .onEnded { value in
                                    let offset = value.translation.width
                                    let threshold = geo.size.width / 3.0
                                    
                                    if offset > threshold {
                                        currentIndex = max(currentIndex - 1, 0)
                                    } else if offset < -threshold {
                                        currentIndex = min(currentIndex + 1, item.images.count - 1)
                                    }
                                }
                            )
                        }
                    }
                }
                Text(item.model)
                Text(item.content)
            }
            .frame(height: 550)
            }
        .onAppear(perform: downloadItem)
    
    } // ---------------------------------------------------
    
    
    // function --------------------------------------------
    func downloadItem(){
        let queryModel = QueryModel()
        queryModel.delegate = self
        queryModel.downloadItems()
    }
    
}

extension ContentView : QueryModelProtocol{
    func itemDownloaded(results: [Shoe]) {
        self.items = results
    }
    
    
}


struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
