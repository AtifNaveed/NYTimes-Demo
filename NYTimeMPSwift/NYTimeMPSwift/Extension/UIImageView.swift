//
//  UIImageView.swift
//  NYTimeMPSwift
//
//  Created by Atif on 24/10/2019.
//  Copyright © 2019 Atif. All rights reserved.
//

import Foundation
import UIKit

extension UIImageView {
    public func image(url: String) {
        if let url = URL(string: url) {
            let task = URLSession.shared.dataTask(with: url) { data, response, error in
                guard let data = data, error == nil else { return }
                DispatchQueue.main.async() {
                    self.image = UIImage(data: data)
                }
            }
            task.resume()
        }
    }
}
