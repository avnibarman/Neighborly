//
//  ViewController.swift
//  Neighborly
//
//  Created by Other users on 4/1/18.
//  Copyright © 2018 Adam Liber. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    @IBOutlet weak var LeftMenuLeadingConstraint: NSLayoutConstraint!
    
    var menuDisplayed = false;
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    @IBAction func OpenMenu(_ sender: Any) {
        if(menuDisplayed){
            LeftMenuLeadingConstraint.constant = -220
            UIView.animate(withDuration: 0.3, animations:{
                self.view.layoutIfNeeded()
            })
            
        }else{
            LeftMenuLeadingConstraint.constant = 0
            UIView.animate(withDuration: 0.3, animations:{
                self.view.layoutIfNeeded()
            })
        }
        menuDisplayed = !menuDisplayed
        
    }
    

}

