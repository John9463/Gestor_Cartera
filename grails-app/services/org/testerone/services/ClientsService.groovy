package org.testerone.services

import groovy.sql.*;

class ClientsService {

    def db = [url:'jdbc:mysql://localhost:3306/cartera', user:'root', password:'', driver:'com.mysql.jdbc.Driver']
    def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)

    def clientList() {
      
    }
}
