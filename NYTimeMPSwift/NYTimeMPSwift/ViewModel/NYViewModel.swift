//
//  NYViewModel.swift
//  NYTimeMPSwift
//
//  Created by Atif on 23/10/2019.
//  Copyright © 2019 Atif. All rights reserved.
//

import Foundation

protocol ViewModelDelegate: class {
    func reloadTable()
}
class NYViewModel {
    var item = [NYModel]()
    var repository: NYNewsRepository?
    weak var delegate: ViewModelDelegate?
    init() {
        repository = NYNewsRepository()
    }
    func getNews() {
        guard let repo = repository else { return }
        repo.getNews(page: 0) { [weak self](response) in
            guard let strongSelf = self else { return }
            switch response {
            case .success(let result):
                strongSelf.item = result.results
                strongSelf.delegate?.reloadTable()
            case.failure:
                break
            }
        }
    }
}

