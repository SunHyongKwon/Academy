//
//  StudentsDB.swift
//  SQLite
//
//  Created by 권순형 on 2023/02/19.
//

import Foundation
import SQLite3 // <<<< 까묵지 마라 죽인다.

protocol QueryModelProtocol{
    func itemDownloaded(items:[Students])
}

class StudentsDB{
    var delegate:QueryModelProtocol!
    var db:OpaquePointer?
    var studentList:[Students] = []
    
    // DB 생성하기
    init() {
        let fileURL = try! FileManager.default.url(for: .documentDirectory, // 내 스마트폰의 현재 디렉토리를 의미한다.
                                                   in: .userDomainMask,
                                                   appropriateFor: nil,
                                                   create: false).appending(path: "StudentsData.sqlite")
        
        if sqlite3_open(fileURL.path(percentEncoded: true),&db) != SQLITE_OK{
            print("error opening database")
        }
        
        // Table 만들기
        if sqlite3_exec(db, "create table if not exists students (sid integer primary key autoincrement, sname text, sdept text, sphone text)", nil, nil, nil) != SQLITE_OK{
            let errMsg = String(cString: sqlite3_errmsg(db))
            print("error create table : \(errMsg)")
        }

    }

    // 처음에 그냥 몇개 넣는 거임
    func temp_insert(){
        var stmt:OpaquePointer?
        let SQLITE3_TRANSIENT = unsafeBitCast(-1, to: sqlite3_destructor_type.self)
        let queryString = "insert into students (sname, sdept, sphone) values (?,?,?)"
        
        if sqlite3_prepare(db, queryString, -1, &stmt, nil) != SQLITE_OK{
            let errMsg = String(cString: sqlite3_errmsg(db))
            print("error preparing insert : \(errMsg)")
            return
        }
        
        // 이미지 쓸 때 -1 부분이 중요하다.
        sqlite3_bind_text(stmt, 1, "유비", -1, SQLITE3_TRANSIENT)
        sqlite3_bind_text(stmt, 2, "컴퓨터공학과", -1, SQLITE3_TRANSIENT)
        sqlite3_bind_text(stmt, 3, "1234", -1, SQLITE3_TRANSIENT)
        
        if sqlite3_step(stmt) != SQLITE_DONE{
            let errMsg = String(cString: sqlite3_errmsg(db))
            print("error preparing insert : \(errMsg)")
            return
        }
        
    }
    
    // select문
    func queryDB(){
        var stmt:OpaquePointer?
        let queryString = "select * from students"
        
        if sqlite3_prepare(db, queryString, -1, &stmt, nil) != SQLITE_OK{
            let errMsg = String(cString: sqlite3_errmsg(db))
            print("error preparing insert : \(errMsg)")
            return
        }
        
        
        while(sqlite3_step(stmt) == SQLITE_ROW){
            let id = Int(sqlite3_column_int(stmt, 0))
            let name = String(cString:sqlite3_column_text(stmt, 1))
            let dept = String(cString:sqlite3_column_text(stmt, 2))
            let phone = String(cString:sqlite3_column_text(stmt, 3))
            
            let student = Students(id: id, name: name, dept: dept, phone: phone)
            
            studentList.append(student)
        }
        
        self.delegate.itemDownloaded(items: studentList)
        
    }
    
    
    
    func insert(name:String, dept:String, phone:String){
        var stmt:OpaquePointer?
        let SQLITE3_TRANSIENT = unsafeBitCast(-1, to: sqlite3_destructor_type.self)
        let queryString = "insert into students (sname, sdept, sphone) values (?,?,?)"
        
        if sqlite3_prepare(db, queryString, -1, &stmt, nil) != SQLITE_OK{
            let errMsg = String(cString: sqlite3_errmsg(db))
            print("error preparing insert : \(errMsg)")
            return
        }
        
        // 이미지 쓸 때 -1 부분이 중요하다.
        sqlite3_bind_text(stmt, 1,  name, -1, SQLITE3_TRANSIENT)
        sqlite3_bind_text(stmt, 2,  dept, -1, SQLITE3_TRANSIENT)
        sqlite3_bind_text(stmt, 3, phone, -1, SQLITE3_TRANSIENT)
        
        if sqlite3_step(stmt) != SQLITE_DONE{
            let errMsg = String(cString: sqlite3_errmsg(db))
            print("error preparing insert : \(errMsg)")
            return
        }
        
    }
    
    func update(code:Int,name:String, dept:String, phone:String){
        var stmt:OpaquePointer?
        let SQLITE3_TRANSIENT = unsafeBitCast(-1, to: sqlite3_destructor_type.self)
        let queryString = "update students set sname = ? , sdept = ? , sphone = ? where sid = ?"
        
        if sqlite3_prepare(db, queryString, -1, &stmt, nil) != SQLITE_OK{
            let errMsg = String(cString: sqlite3_errmsg(db))
            print("error preparing insert : \(errMsg)")
            return
        }
        
        // 이미지 쓸 때 -1 부분이 중요하다.
        sqlite3_bind_text(stmt, 1,  name, -1, SQLITE3_TRANSIENT)
        sqlite3_bind_text(stmt, 2,  dept, -1, SQLITE3_TRANSIENT)
        sqlite3_bind_text(stmt, 3, phone, -1, SQLITE3_TRANSIENT)
        sqlite3_bind_int(stmt, 4,Int32(code))
        
        if sqlite3_step(stmt) != SQLITE_DONE{
            let errMsg = String(cString: sqlite3_errmsg(db))
            print("error preparing insert : \(errMsg)")
            return
        }
        
    }
    
    func delete(code:Int){
        var stmt:OpaquePointer?
        let queryString = "delete from students where sid = ?"
        
        if sqlite3_prepare(db, queryString, -1, &stmt, nil) != SQLITE_OK{
            let errMsg = String(cString: sqlite3_errmsg(db))
            print("error preparing insert : \(errMsg)")
            return
        }
        
        // 이미지 쓸 때 -1 부분이 중요하다.
        sqlite3_bind_int(stmt, 1,Int32(code))
        
        
        if sqlite3_step(stmt) != SQLITE_DONE{
            let errMsg = String(cString: sqlite3_errmsg(db))
            print("error preparing insert : \(errMsg)")
            return
        }
        
    }
}



