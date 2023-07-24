//
//  TableViewController.swift
//  SQLite
//
//  Created by 권순형 on 2023/02/19.
//

import UIKit

class TableViewController: UITableViewController {
    @IBOutlet var tblListView: UITableView!
    
    var studentList:[Students] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
        
    }
    
    override func viewWillAppear(_ animated: Bool) {
        makeDB()
    }
    
    func makeDB(){
        let db = StudentsDB()
        studentList.removeAll()
        db.delegate = self
//        db.temp_insert()
        db.queryDB()
        tblListView.reloadData()
    }
    
    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return studentList.count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "myCell", for: indexPath)

        // Configure the cell...
        var content = cell.defaultContentConfiguration()
        content.text = studentList[indexPath.row].name
        content.secondaryText = studentList[indexPath.row].dept
        
        cell.contentConfiguration = content

        return cell
    }
    

    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    /*
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    */

    /*
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
        if segue.identifier == "sgDetail"{
            let detailViewController = segue.destination as! DetailViewController
            
            let cell = sender as! UITableViewCell
            let indexPath = self.tblListView.indexPath(for: cell)
            
            detailViewController.receiveId = studentList[indexPath!.row].id
            detailViewController.receiveDept = studentList[indexPath!.row].dept
            detailViewController.receiveName = studentList[indexPath!.row].name
            detailViewController.receivePhone = studentList[indexPath!.row].phone
            
        }
        
    }
    

}

extension TableViewController:QueryModelProtocol{
    func itemDownloaded(items: [Students]) {
        studentList = items
        tblListView.reloadData()
    }
}
