//
//  HomeViewController.swift
//  NYTimeMPSwift
//
//  Created by Atif on 23/10/2019.
//  Copyright © 2019 Atif. All rights reserved.
//

import UIKit
import SwiftyProgressHud

class HomeViewController: UIViewController, ViewModelDelegate {
    var hud: SwiftyProgressHud!
    @IBOutlet weak var tableView: UITableView!
    var viewModel = NYViewModel()
    override func viewDidLoad() {
        super.viewDidLoad()
        setup()
    }
    func setup() {
        tableView.dataSource = self
        tableView.delegate = self
        viewModel.delegate = self
        hud = SwiftyProgressHud()
        hud.show(view: self.view)
        viewModel.getNews()
    }
    func reloadTable() {
        DispatchQueue.main.sync {
            self.tableView.reloadData()
            hud.hide()
        }
    }
}
extension HomeViewController: UITableViewDataSource, UITableViewDelegate {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return viewModel.item.count
    }
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: NYTableCell.stringFromClass) as! NYTableCell
        if viewModel.item.count > 0 {
            let dataItems = viewModel.item[indexPath.row]
            cell.configure(whitViewModel: dataItems, row: indexPath.row)
        }
        return cell
    }
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        guard let vc = appDelegate().storyboard().instantiateViewController(withIdentifier: DetailViewController.stringFromClass) as? DetailViewController else { return }
        if viewModel.item.count > 0 {
            vc.item = viewModel.item[indexPath.row]
            appDelegate().rootNavigation().pushViewController(vc, animated: true)
        }
    }
}
