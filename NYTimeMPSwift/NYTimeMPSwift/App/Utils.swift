//
//  Utils.swift
//  NYTimeMPSwift
//
//  Created by Atif on 23/10/2019.
//  Copyright © 2019 Atif. All rights reserved.
//

import UIKit

class Utils: NSObject {
    static func fakeDate() -> String {
        let date = Date()
        let formatter = DateFormatter()
        formatter.dateFormat = "yyyy-MM-dd"
        return formatter.string(from: date)
    }
    
    static func formateDate(date: String) -> String {
        return "📅 " + date
    }
}
