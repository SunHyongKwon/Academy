//
//  CLPlacemark.swift
//  Geocoding
//
//  Created by Bart Jacobs on 13/06/2018.
//  Copyright © 2018 Cocoacasts. All rights reserved.
//

import CoreLocation

extension CLPlacemark {
    
    var compactAddress: String? {
        if let name = name {
            var result = ""
               
            if let country = country {
                result += "\(country)"
            }
            
            if let city = locality {
                result += ", \(city)"
            }
            
            if let street = thoroughfare {
                result += ", \(street), "
            }
            
            result += name
            return result
        }
        
        return nil
    }
    
}
