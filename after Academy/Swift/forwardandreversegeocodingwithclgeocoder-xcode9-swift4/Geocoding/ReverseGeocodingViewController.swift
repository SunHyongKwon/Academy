//
//  ReverseGeocodingViewController.swift
//  Geocoding
//
//  Created by Bart Jacobs on 25/09/16.
//  Copyright © 2016 Cocoacasts. All rights reserved.
//

import UIKit
import CoreLocation

class ReverseGeocodingViewController: UIViewController {

    // MARK: - Properties
    
    @IBOutlet var latitudeTextField: UITextField!
    @IBOutlet var longitudeTextField: UITextField!
    
    @IBOutlet var geocodeButton: UIButton!
    @IBOutlet var activityIndicatorView: UIActivityIndicatorView!
    
    @IBOutlet var locationLabel: UILabel!
    
    // MARK: -
    
    lazy var geocoder = CLGeocoder()
    
    // MARK: - Initialization

    required init?(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)

        title = "Reverse Geocoding"
    }

    // MARK: - View Life Cycle

    override func viewDidLoad() {
        super.viewDidLoad()
    }

    // MARK: - Actions
    
    @IBAction func geocode(_ sender: UIButton) {
        guard let latAsString = latitudeTextField.text, let lat = Double(latAsString) else { return }
        guard let lngAsString = longitudeTextField.text, let lng = Double(lngAsString) else { return }
        
        // Create Location
        let location = CLLocation(latitude: lat, longitude: lng)
        
        // Geocode Location
        geocoder.reverseGeocodeLocation(location) { (placemarks, error) in
            // Process Response
            self.processResponse(withPlacemarks: placemarks, error: error)
        }
        
        // Update View
        geocodeButton.isHidden = true
        activityIndicatorView.startAnimating()
    }
    
    // MARK: - Helper Methods

    private func processResponse(withPlacemarks placemarks: [CLPlacemark]?, error: Error?) {
        // Update View
        geocodeButton.isHidden = false
        activityIndicatorView.stopAnimating()
        
        if let error = error {
            print("Unable to Reverse Geocode Location (\(error))")
            locationLabel.text = "Unable to Find Address for Location"
            
        } else {
            if let placemarks = placemarks, let placemark = placemarks.first {
                locationLabel.text = placemark.compactAddress
            } else {
                locationLabel.text = "No Matching Addresses Found"
            }
        }
        
    }
    
}
