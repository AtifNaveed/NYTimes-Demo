//
//  APIConstants.swift
//  NYTimeMPSwift
//
//  Created by Atif on 23/10/2019.
//  Copyright © 2019 Atif. All rights reserved.
//

import UIKit
import Foundation

enum APIEndPoint: String {
    case getPopular  = "/mostpopular"
}

struct APIConstants {
    static let protocolo    : String = "https://"
    static let apiVersion   : String = "/v2"
    static let domain       : String = "api.nytimes.com/svc"
    static let subDomain    : String = "/mostviewed"
    static let section      : String = "/all-sections"
    static let period       : String = "/7"
    static let apiKey       : String = "ADYf7cnwk6WOZNfRsUe4XZvke5KkGf6f"
    static let keyPath      : String = "api-key="
    static let urlExtension : String = ".json?"
    static let baseUrl      : String = APIConstants.protocolo
                                        + APIConstants.domain
}
