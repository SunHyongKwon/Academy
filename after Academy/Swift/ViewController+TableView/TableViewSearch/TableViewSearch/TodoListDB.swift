//
//  TodoListDB.swift
//  TableViewSearch
//
//  Created by Kenny on 2023/03/05.
//

import Foundation
import SQLite3 // <<<

protocol QueryModelProtocol{
    func itemDownloaded(items: [TodoList])
}

class TodoListDB{
    var db: OpaquePointer?
    var todoList: [TodoList] = []
    var delegate: QueryModelProtocol!
    
    init() {
        let fileURL = try! FileManager.default.url(for: .documentDirectory, in: .userDomainMask, appropriateFor: nil, create: false).appending(path: "TodoListData.sqlite")
        
        if sqlite3_open(fileURL.path(percentEncoded: true), &db) != SQLITE_OK{
            print("error opening database")
        }
        
        // Table 만들기
        if sqlite3_exec(db, "CREATE TABLE IF NOT EXISTS todolists (sid INTEGER PRIMARY KEY AUTOINCREMENT, scontent TEXT, sdid INTEGER, sicon TEXT)", nil, nil, nil) != SQLITE_OK{
            let errMsg = String(cString: sqlite3_errmsg(db)!)
            print("error creating table :\(errMsg)")
        }
    } // ----
    
    func tempInsert(){
        var stmt: OpaquePointer?
        let SQLITE_TRANSIENT = unsafeBitCast(-1, to: sqlite3_destructor_type.self)
        
        let queryString = "INSERT INTO todolists (scontent, sdid, sicon) VALUES (?,?,?)"
        
        if sqlite3_prepare(db, queryString, -1, &stmt, nil) != SQLITE_OK{
            let errMsg = String(cString: sqlite3_errmsg(db)!)
            print("error preparing insert : \(errMsg)")
            return
        }
        
        sqlite3_bind_text(stmt, 1, "App Test", -1, SQLITE_TRANSIENT)
        sqlite3_bind_int(stmt, 2, 0)
        sqlite3_bind_text(stmt, 3, "pencil.circle", -1, SQLITE_TRANSIENT)

        if sqlite3_step(stmt) != SQLITE_DONE{
            let errMsg = String(cString: sqlite3_errmsg(db)!)
            print("error insert data : \(errMsg)")
        }
    } // ----

    func queryDB(){
        var stmt: OpaquePointer?
        let queryString = "SELECT * FROM todolists"
        
        if sqlite3_prepare(db, queryString, -1, &stmt, nil) != SQLITE_OK{
            let errMsg = String(cString: sqlite3_errmsg(db)!)
            print("error preparing select : \(errMsg)")
            return
        }
        
        while(sqlite3_step(stmt) == SQLITE_ROW){
            let id = Int(sqlite3_column_int(stmt, 0))
            let content = String(cString: sqlite3_column_text(stmt, 1))
            let did = Int(sqlite3_column_int(stmt, 2))
            let icon = String(cString: sqlite3_column_text(stmt, 3))
            todoList.append(TodoList(id: id, content: content, did: did, icon: icon))
        }
        self.delegate.itemDownloaded(items: todoList)
    } // ----

    func conditionDB(searchName: String){
        var stmt: OpaquePointer?
        let queryString = "SELECT * FROM todolists where scontent like '%\(searchName)%'"
        
        if sqlite3_prepare(db, queryString, -1, &stmt, nil) != SQLITE_OK{
            let errMsg = String(cString: sqlite3_errmsg(db)!)
            print("error preparing select : \(errMsg)")
            return
        }
        
        while(sqlite3_step(stmt) == SQLITE_ROW){
            let id = Int(sqlite3_column_int(stmt, 0))
            let content = String(cString: sqlite3_column_text(stmt, 1))
            let did = Int(sqlite3_column_int(stmt, 2))
            let icon = String(cString: sqlite3_column_text(stmt, 3))
            todoList.append(TodoList(id: id, content: content, did: did, icon: icon))
        }
        self.delegate.itemDownloaded(items: todoList)
    } // ----

    
    func insertDB(content: String) -> Bool{
        var stmt: OpaquePointer?
        let SQLITE_TRANSIENT = unsafeBitCast(-1, to: sqlite3_destructor_type.self)
        
        let queryString = "INSERT INTO todolists (scontent, sdid, sicon) VALUES (?,?,?)"
        
        sqlite3_prepare(db, queryString, -1, &stmt, nil)
        
        sqlite3_bind_text(stmt, 1, content, -1, SQLITE_TRANSIENT)
        sqlite3_bind_int(stmt, 2, 0)
        sqlite3_bind_text(stmt, 3, "pencil.circle", -1, SQLITE_TRANSIENT)

        if sqlite3_step(stmt) == SQLITE_DONE{
            return true
        }else{
            return false
        }
    } // ---
    
    func updateDB(id: Int, content: String) -> Bool{
        var stmt: OpaquePointer?
        let SQLITE_TRANSIENT = unsafeBitCast(-1, to: sqlite3_destructor_type.self)
        
        let queryString = "UPDATE todolists SET scontent = ? WHERE sid = ?"
        
        sqlite3_prepare(db, queryString, -1, &stmt, nil)
        
        sqlite3_bind_text(stmt, 1, content, -1, SQLITE_TRANSIENT)
        sqlite3_bind_int(stmt, 2, Int32(id))

        if sqlite3_step(stmt) == SQLITE_DONE{
            return true
        }else{
            return false
        }
    } // ---

    func updateDidDB(id: Int, status: String) -> Bool{
        var stmt: OpaquePointer?
        var queryString: String = ""
//        let SQLITE_TRANSIENT = unsafeBitCast(-1, to: sqlite3_destructor_type.self)
        
        if status == "complete"{
            queryString = "UPDATE todolists SET sdid = 1 WHERE sid = ?"
        }else{
            queryString = "UPDATE todolists SET sdid = 0 WHERE sid = ?"
        }
        
        sqlite3_prepare(db, queryString, -1, &stmt, nil)
        
        sqlite3_bind_int(stmt, 1, Int32(id))

        if sqlite3_step(stmt) == SQLITE_DONE{
            return true
        }else{
            return false
        }
    } // ---

    func deleteDB(id: Int) -> Bool{
        var stmt: OpaquePointer?
                
        let queryString = "DELETE FROM todolists WHERE sid = ?"
        
        sqlite3_prepare(db, queryString, -1, &stmt, nil)
        
        sqlite3_bind_int(stmt, 1, Int32(id))

        if sqlite3_step(stmt) == SQLITE_DONE{
            return true
        }else{
            return false
        }
    } // ---
    
    func deleteAllDB() -> Bool{
        var stmt: OpaquePointer?
                
        let queryString = "DELETE FROM todolists"
        
        sqlite3_prepare(db, queryString, -1, &stmt, nil)
        
        if sqlite3_step(stmt) == SQLITE_DONE{
            return true
        }else{
            return false
        }

    } // ---

    func insertAllDB(content: String, did: Int, icon: String) -> Bool{
        var stmt: OpaquePointer?
        let SQLITE_TRANSIENT = unsafeBitCast(-1, to: sqlite3_destructor_type.self)
        
        let queryString = "INSERT INTO todolists (scontent, sdid, sicon) VALUES (?,?,?)"
        
        sqlite3_prepare(db, queryString, -1, &stmt, nil)
        
        sqlite3_bind_text(stmt, 1, content, -1, SQLITE_TRANSIENT)
        sqlite3_bind_int(stmt, 2, Int32(did))
        sqlite3_bind_text(stmt, 3, icon, -1, SQLITE_TRANSIENT)

        if sqlite3_step(stmt) == SQLITE_DONE{
            return true
        }else{
            return false
        }
    } // ---

    
} // TodoListDB
