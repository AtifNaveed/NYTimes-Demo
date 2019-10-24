//
//  NYTableCell.swift
//  NYTimeMPSwift
//
//  Created by Atif on 23/10/2019.
//  Copyright © 2019 Atif. All rights reserved.
//

import UIKit

class NYTableCell: UITableViewCell {
    @IBOutlet weak var lblNewsTitle: UILabel!
    @IBOutlet weak var lblNewsBy: UILabel!
    @IBOutlet weak var lblNewsDate: UILabel!
    @IBOutlet weak var imagView: UIImageView!
    func configure(whitViewModel dataItems:NYModel, row: Int) {
        //TODO: get default values from requirement provider
        lblNewsTitle.text = dataItems.title == "" ? "Fantastic News" : dataItems.title
        lblNewsBy.text = dataItems.byline == "" ? "By Atif Naveed" : dataItems.byline
        lblNewsDate.text = dataItems.published_date == "" ? Utils.formateDate(date: Utils.fakeDate()) : Utils.formateDate(date: dataItems.published_date)
        if (dataItems.media.count > 0) {
            let media = dataItems.media[0]
            if (media.media_metadata.count > 0) {
                let image = media.media_metadata[0]
                imagView?.image(url: image.url)
            }
        }
    }
    override func awakeFromNib() {
        super.awakeFromNib()
    }
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
    }
}


