//
//  QueryModel.swift
//  Instargram01
//
//  Created by 권순형 on 2023/04/05.
//

import Foundation

protocol QueryModelProtocol{
    func itemDownloaded(results:[Shoe])
}

class QueryModel {
    var delegate : QueryModelProtocol?
    
    func downloadItems() {
        // Define the URL
        guard let url = URL(string: "https://sunhyongkwon.github.io/data.json") else {
            print("Invalid URL")
            return
        }

        // Create a URL request
        let request = URLRequest(url: url)

        // Create a URL session
        let session = URLSession.shared

        // Create a data task
        let task = session.dataTask(with: request) { data, response, error in
            // Handle errors
            if let error = error {
                print("Error: \(error.localizedDescription)")
                return
            }

            // Ensure there is data
            guard let data = data else {
                print("No data returned")
                return
            }
            
            do {
                // Decode the JSON data
                let decodedData = try JSONDecoder().decode(Shoes.self,from: data)
                
                
                // Use the decoded data to update your UI
                DispatchQueue.main.async {
                    // Update UI here
                    self.delegate?.itemDownloaded(results: decodedData.results)
                }
            } catch {
                print("Error decoding JSON: \(error.localizedDescription)")
            }
        }

        // Start the data task
        task.resume()

    }
}
