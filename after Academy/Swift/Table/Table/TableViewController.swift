//
//  TableViewController.swift
//  Table
//
//  Created by 권순형 on 2023/02/18.
//

import UIKit

class TableViewController: UITableViewController {
    
    @IBOutlet var tvListView: UITableView!
    
    // list view는 무조건 배열로 작동을 한다.
    var dataArray:[Model] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        dataInit()

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // edit 버튼 만들기
        self.navigationItem.leftBarButtonItem = self.editButtonItem
    }
    
    func dataInit(){
        
        dataArray.append(Model(
            imageFileName: "cart.png",
            text: "책 구매"
        ))
        
        dataArray.append(Model(
            imageFileName: "clock.png",
            text: "철수와 약속"
        ))
        
        dataArray.append(Model(
            imageFileName: "pencil.png",
            text: "스터디 준비"
        ))
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return dataArray.count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "MyCell", for: indexPath)

        // Configure the cell...
        var content = cell.defaultContentConfiguration()
        content.text = dataArray[indexPath.row].text
        content.image = UIImage(named: dataArray[indexPath.row].imageFileName!)
        
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

    
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            // 지우기
            dataArray.remove(at: indexPath.row)
            //
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    
    // 한글로 바꾸기
    override func tableView(_ tableView: UITableView, titleForDeleteConfirmationButtonForRowAt indexPath: IndexPath) -> String? {
        return "삭제"
    }

    
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {
        let imteToMove = dataArray[fromIndexPath.row]
        dataArray.remove(at: fromIndexPath.row)
        dataArray.insert(imteToMove, at: to.row)
    }
    

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
            // 몇번째 클릭한건지 알 수 있다.
            let cell = sender as! UITableViewCell
            let indexPath = tvListView.indexPath(for: cell)
            let detailView = segue.destination as! DetailViewController
            detailView.receiveItem = dataArray[indexPath!.row].text!
            detailView.receiveImage = dataArray[indexPath!.row].imageFileName!
        }else{
            let addViewController = segue.destination as! AddViewController
            addViewController.delegate = self
        }
    }
    
}

extension TableViewController: AddDelgate {
    
    func addDone(_ controller: AddViewController, model: Message) {
        dataArray.append(Model(imageFileName: model.imtesImageFile,text: model.item))
        tvListView.reloadData()
    }
    
    
}
