package com.company;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Functiondb {
    public Connection connectDb (String dbName, String password, String user) {
        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, user, password);
            if (conn != null){
                System.out.println("Connection established!!");
            }else{
                System.out.println("Connection failed!!");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return  conn;
    }
    public void CreateTable(Connection conn, String tableName ){
        Statement statement;
        try{
            //using the plus operator to concatenate strings
            String query = "CREATE TABLE " + tableName + "(empId SERIAL, name VARCHAR(200), address VARCHAR(200), primary key(empId));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created!!");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void Insert_rows(Connection conn,String tableName, String name, String address) {
        Statement statement;
        try{
            //using format method to auto concatenate strings in the query;
            String query = String.format("INSERT INTO %s(name,address) values('%s','%s');", tableName, name, address);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row inserted!!");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
