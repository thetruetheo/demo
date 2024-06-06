package org.example;

import java.sql.*;

public class DbFunctionsActual {
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

    public void readDataFromUsersTable(Connection conn, String tableName){
        Statement statement;
        ResultSet rs=null;
        try{
            String query=String.format("select * from %s", tableName);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while(rs.next()){
                System.out.print(rs.getString("userID")+" ");
                System.out.print(rs.getString("fio")+" ");
                System.out.print(rs.getString("phone")+" ");
                System.out.print(rs.getString("login")+" ");
                System.out.print(rs.getString("password")+" ");
                System.out.println(rs.getString("type")+" ");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public boolean userLogin(Connection conn, String tableName, String login, String password){
        Statement statement;
        ResultSet rs=null;
        try{
            String query=String.format("select * from %s", tableName);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);

            while(rs.next()){
                if(rs.getString("login").equals(login)){
                    //System.out.println("login match");
                    if(rs.getString("password").equals(password)){
                        //System.out.println("password match");
                        ClientQueriesFrame clientQueriesFrame =
                                new ClientQueriesFrame(Integer.parseInt(rs.getString("userID")),
                                rs.getString("fio"),rs.getString("phone"));
                        return true;
                    }
                };
            }



        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }



    public void checkUserCredentialsForLogin(Connection conn, String tableName){
        Statement statement;
        ResultSet rs=null;
        try{
            String query=String.format("select * from %s", tableName);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while(rs.next()){
                System.out.print(rs.getString("userID")+" ");
                System.out.print(rs.getString("fio")+" ");
                System.out.print(rs.getString("phone")+" ");
                System.out.print(rs.getString("login")+" ");
                System.out.print(rs.getString("password")+" ");
                System.out.println(rs.getString("type")+" ");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
