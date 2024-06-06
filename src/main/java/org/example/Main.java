package org.example;


import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        //RegistrationFrame registrationFrame = new RegistrationFrame();
        DbFunctions dbFunctions=new DbFunctions();
        Connection conn = dbFunctions.connectToDB("tutdb","postgres","toor");
        //dbFunctions.createTable(conn, "employee");
        //dbFunctions.insertRow(conn, "employee","elisey","Russia");
        //dbFunctions.updateName(conn, "employee", "fedos", "fyodor");
        //dbFunctions.searchByName(conn, "employee", "fyodor");
        //dbFunctions.searchById(conn, "employee", 2);
        //dbFunctions.deleteRowByName(conn, "employee", "nekit");
        //dbFunctions.readData(conn, "employee");
        dbFunctions.deleteTable(conn,"employee");
    }
}

