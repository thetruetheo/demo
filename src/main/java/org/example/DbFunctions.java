package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbFunctions {
    public Connection connectToDB(String user, String pass){
        Connection conn=null;
        try {
            Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/autoworkshop",
                    user, pass);
            if(conn!=null){
                System.out.println("Connection Established");
            }
            else{
                System.out.println("Connection Failed");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return conn;
    }

    public void createTable(Connection conn, String tableName){
        Statement statement;
        try {
            String query="create table "+tableName+"(empid SERIAL, name varchar(200), " +
                    "address varchar(200), primary key(empid));";
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void insertRow(Connection conn, String tableName, String name, String address){
        Statement statement;
        try{
            String query=String.format("insert into %s(name, address) " +
                    "values('%s', '%s');",tableName, name, address);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void readData(Connection conn, String tableName){
        Statement statement;
        ResultSet rs=null;
        try{
            String query=String.format("select * from %s", tableName);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while(rs.next()){
                System.out.print(rs.getString("empid")+" ");
                System.out.print(rs.getString("name")+" ");
                System.out.print(rs.getString("Address")+" ");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }



    public void updateName(Connection conn, String tableName, String oldName, String newName){
        Statement statement;
        try{
            String query=String.format("update %s set name='%s' where name='%s'",
                    tableName, newName, oldName);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Updated");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void searchByName(Connection conn, String tableName, String name){
        Statement statement;
        ResultSet rs=null;
        try{
            String query=String.format("select * from %s where name= '%s'", tableName, name);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while (rs.next()){
                System.out.print(rs.getString("empid")+" ");
                System.out.print(rs.getString("name")+" ");
                System.out.println(rs.getString("address"));
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void searchById(Connection conn, String tableName, int id){
        Statement statement;
        ResultSet rs=null;
        try{
            String query=String.format("select * from %s where empid= '%s'", tableName, id);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while (rs.next()){
                System.out.print(rs.getString("empid")+" ");
                System.out.print(rs.getString("name")+" ");
                System.out.println(rs.getString("address"));
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void deleteRowByName(Connection conn, String tableName, String name){
        Statement statement;
        try{
            String query=String.format("delete from %s where name='%s'", tableName, name);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Deleted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void deleteTable(Connection conn, String tableName){
        Statement statement;
        try{
            String query = String.format("drop table %s", tableName);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Deleted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
