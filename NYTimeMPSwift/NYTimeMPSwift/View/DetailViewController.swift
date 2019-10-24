//
//  DetailViewController.swift
//  NYTimeMPSwift
//
//  Created by Atif on 23/10/2019.
//  Copyright © 2019 Atif. All rights reserved.
//

import UIKit

class DetailViewController: UIViewController {
    @IBOutlet weak var lblNewsTitle: UILabel!
    @IBOutlet weak var lblNewsBy: UILabel!
    @IBOutlet weak var lblNewsDate: UILabel!
    @IBOutlet weak var imagView: UIImageView!
    var item: NYModel? = nil
    override func viewDidLoad() {
        super.viewDidLoad()
        //TODO: get default values from requirement provider
        lblNewsTitle.text = item!.title == "" ? "Fantastic News" : item!.title
        lblNewsBy.text = item!.byline == "" ? "By Atif Naveed" : item!.abstract
        if ((item?.media.count)! > 0) {
            let media = item!.media[0]
            if (media.media_metadata.count > 0) {
                for image in media.media_metadata {
                    if image.format == "superJumbo" {
                        imagView?.image(url: image.url)
                    }
                }
            }
        }
        lblNewsDate.text = item!.published_date == "" ? Utils.formateDate(date: Utils.fakeDate()) : Utils.formateDate(date: item!.published_date)
    }
}
