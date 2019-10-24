//
//  NYNewsRepository.swift
//  NYTimeMPSwift
//
//  Created by Atif on 23/10/2019.
//  Copyright © 2019 Atif. All rights reserved.
//

import Foundation

enum  NewsAPIResponse {
    case success(result: NewsArray)
    case failure
}
class NYNewsRepository: Service {
    func getNews(page:Int, completion: @escaping (NewsAPIResponse) -> Void ) {
        super.callEndPoint(endPoint:APIEndPoint.getPopular.rawValue) { [weak self] (response) in
            guard let strongSelf = self else { return }
            switch response {
            case .success(let result):
                strongSelf.parseResult(result: result, completion: completion)
                break
            default:
                completion(.failure)
                break
            }
        }
    }
    private func parseResult(result: JsonDictionay,completion: @escaping (NewsAPIResponse) -> Void) {
        guard let data = NewsArray(json: result) else {
            completion(.failure)
            return
        }
        completion(.success(result: data))
    }
}
