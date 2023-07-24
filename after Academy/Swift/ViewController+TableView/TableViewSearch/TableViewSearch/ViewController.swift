//
//  ViewController.swift
//  TableViewSearch
//
//  Created by Kenny on 2023/03/05.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var tvListView: UITableView!
    @IBOutlet weak var searchTitle: UITextField!
    
    var todoLists: [TodoList] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        tvListView.delegate = self
        tvListView.dataSource = self
        
        // >>>>>> Long Press <<<<<<<<
        let longPress = UILongPressGestureRecognizer(target: self, action: #selector(handleLongPress(sender:)))
        tvListView.addGestureRecognizer(longPress)
        // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    }
    
    
    override func viewWillAppear(_ animated: Bool) {
        selectData()
    }

    // >>>>>> Long Press <<<<<<<<
    @objc private func handleLongPress(sender: UILongPressGestureRecognizer) {
        if sender.state == .began {
//            let touchPoint = sender.location(in: tableView)
            let touchPoint = sender.location(in: tvListView)
            if tvListView.indexPathForRow(at: touchPoint) != nil {
                // your code here, get the row for the indexPath or do whatever you want
                let touchNumber = tvListView.indexPathForRow(at: touchPoint)![1]
                print("Long Pressed!", touchNumber)
                alertDialog(touchNumber)
            }
        }
    }

    func alertDialog(_ touchNumber: Int){
        
        let addAlert = UIAlertController(title: "TodoList", message: "해당 항목을 작업 완료로 설정 하시겠습니끼?", preferredStyle: UIAlertController.Style.alert
        )
        
        // configurationHandler의 파라미터 부분에 엔터
        addAlert.addTextField { addText in
            addText.text = self.todoLists[touchNumber].content
            addText.isUserInteractionEnabled = false
        }
            
        let cancelAction = UIAlertAction(title: "취소", style: .default, handler: nil)

        let okAction = UIAlertAction(title: "완료", style: .default, handler: {ACTION in
            let todoListDB = TodoListDB()
            _ = todoListDB.updateDidDB(id: self.todoLists[touchNumber].id, status: "complete")
            self.selectData()
        })

        let nokAction = UIAlertAction(title: "미완료", style: .default, handler: {ACTION in
            let todoListDB = TodoListDB()
            _ = todoListDB.updateDidDB(id: self.todoLists[touchNumber].id, status: "no")
            self.selectData()
        })

        addAlert.addAction(cancelAction)
        addAlert.addAction(okAction)
        addAlert.addAction(nokAction)
        
        present(addAlert, animated: true, completion: nil)

    }
    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    func selectData(){
        let todoListDB = TodoListDB()
        todoLists.removeAll()
        todoListDB.delegate = self
//        todoListDB.tempInsert()
        todoListDB.queryDB()
        tvListView.reloadData()

    }

    @IBAction func btnAddition(_ sender: UIBarButtonItem) {
        let addAlert = UIAlertController(title: "Todo List", message: "추가할 내용을 입력하세요!", preferredStyle: UIAlertController.Style.alert
        )
        
        // configurationHandler의 파라미터 부분에 엔터
        addAlert.addTextField { addText in
            addText.placeholder = "추가 내용"
        }
            
        let cancelAction = UIAlertAction(title: "취소", style: .default, handler: nil)

        let okAction = UIAlertAction(title: "추가", style: .default, handler: {ACTION in
            if addAlert.textFields![0].text!.isEmpty{
                return
            }
            let todoListDB = TodoListDB()
            _ = todoListDB.insertDB(content: addAlert.textFields![0].text!)
            self.selectData()
        })
        
        addAlert.addAction(cancelAction)
        addAlert.addAction(okAction)
        
        present(addAlert, animated: true, completion: nil)
    }
    
    @IBAction func searchAction(_ sender: UIButton) {
        let searchName = searchTitle.text!
        let todoListDB = TodoListDB()
        todoLists.removeAll()
        todoListDB.delegate = self
//        todoListDB.tempInsert()
        todoListDB.conditionDB(searchName: searchName)
        tvListView.reloadData()

        
    }
    
    // 아무곳이나 눌러 softkeyboard 지우기
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }

}


extension ViewController: UITableViewDelegate{
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let addAlert = UIAlertController(title: "Todo List", message: "수정할 내용을 입력하세요!", preferredStyle: UIAlertController.Style.alert
        )
        
        // configurationHandler의 파라미터 부분에 엔터
        addAlert.addTextField { addText in
            addText.text = self.todoLists[indexPath.row].content
        }
            
        let cancelAction = UIAlertAction(title: "취소", style: .default, handler: nil)

        let okAction = UIAlertAction(title: "수정", style: .default, handler: {ACTION in
            if addAlert.textFields![0].text!.isEmpty{
                return
            }
            let todoListDB = TodoListDB()
            _ = todoListDB.updateDB(id: self.todoLists[indexPath.row].id, content: addAlert.textFields![0].text!)
            self.selectData()
        })
        
        addAlert.addAction(cancelAction)
        addAlert.addAction(okAction)
        
        present(addAlert, animated: true, completion: nil)
    }
    
    func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            let todoListDB = TodoListDB()
            _ = todoListDB.deleteDB(id: todoLists[indexPath.row].id)
            self.selectData()
        }
    }

    func tableView(_ tableView: UITableView, moveRowAt sourceIndexPath: IndexPath, to destinationIndexPath: IndexPath) {
        // 이동할 item의 위치
        let itemToMove = todoLists[sourceIndexPath.row]
        // 이동할 item을 삭제하면 item들의 index가 재정렬됨
        todoLists.remove(at: sourceIndexPath.row)
        // 삭제된 item을 이동할 위치로 삽입하면 item들의 index가 재정렬됨
        todoLists.insert(itemToMove, at: destinationIndexPath.row)
        let todoListDB = TodoListDB()
        _ = todoListDB.deleteAllDB()
        for i in 0..<todoLists.count{
            let content = todoLists[i].content
            let did = todoLists[i].did
            let icon = todoLists[i].icon
            _ = todoListDB.insertAllDB(content: content, did: did, icon: icon)
        }
        selectData()

    }
    
}

extension ViewController: UITableViewDataSource{
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return todoLists.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "myCell", for: indexPath)

        // Configure the cell...

        var content = cell.defaultContentConfiguration()
        content.text = todoLists[indexPath.row].content
        
        if todoLists[indexPath.row].did == 0{
            content.image = UIImage(systemName: "pencil.circle")
        }else{
            content.image = UIImage(systemName: "eraser")
        }
        
        if todoLists[indexPath.row].did == 1{
            cell.isUserInteractionEnabled = false
        }else{
            cell.isUserInteractionEnabled = true
        }
    
        cell.contentConfiguration = content

        return cell

    }
    
}

extension ViewController: QueryModelProtocol{
    func itemDownloaded(items: [TodoList]) {
        todoLists = items
        self.tvListView.reloadData()
    }
}
