//
//  TableViewCell.swift
//  ServerJsonCardList
//
//  Created by 권순형 on 2023/02/19.
//

import UIKit

class TableViewCell: UITableViewCell {
    @IBOutlet weak var jsonImage: UIImageView!
    
    @IBOutlet weak var jsonCategory: UILabel!
    
    @IBOutlet weak var jsonHeading: UILabel!
    
    @IBOutlet weak var jsonAuthor: UILabel!
    
    @IBOutlet weak var contentViewCell: UIView! // contentView를 연결해야 card형태의 모양 생성이 가능하다.
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
        contentViewCell.layer.cornerRadius = 15
        contentViewCell.backgroundColor = .white
        
        self.backgroundColor = .lightGray
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
        if selected{
            contentView.layer.borderWidth=2
            contentView.layer.borderColor = UIColor.red.cgColor
        }else{
            contentView.layer.borderWidth=1
            contentView.layer.borderColor = UIColor.blue.cgColor
        }
        
    }
    
    // table cell간의 간격 조정
    override func layoutSubviews() {
        super.layoutSubviews()
        contentView.frame = contentView.frame.inset(by: UIEdgeInsets(top: 0, left: 16.0, bottom: 0, right: 16.0))
    }

}
