//
//  AccountViewController.swift
//  Neighborly
//
//  Created by Avni Barman on 4/8/18.
//  Copyright © 2018 Adam Liber. All rights reserved.
//

import UIKit

class AccountViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {
    
    
    @IBOutlet weak var tableView: UITableView!
    @IBOutlet weak var segmentControl: UISegmentedControl!
    
    let borrowedItems:[String] = ["Ladder", "Power Drill"]
    let myItems:[String] = ["Camera", "Snowboard", "Camping Tent"]
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Do any additional setup after loading the view.
    }
    
    @IBAction func segmentControlClicked(_ sender: Any) {
        tableView.reloadData();
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        
        
        switch(segmentControl.selectedSegmentIndex){
        case 0:
            return borrowedItems.count
            break
        case 1:
            return myItems.count
            break
        default:
            break
        }
        
        return 0
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let myCell =  tableView.dequeueReusableCell( withIdentifier: "myCell", for: indexPath)
        switch(segmentControl.selectedSegmentIndex){
        case 0:
            myCell.textLabel!.text = borrowedItems[indexPath.row]
            break
        case 1:
            myCell.textLabel!.text = myItems[indexPath.row]
            break
        default:
            break
        }
        
        return myCell
    }
}
