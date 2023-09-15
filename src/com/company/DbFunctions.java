package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbFunctions {
    InputHandler inputHandler = new InputHandler();
    public Connection connectDb (String dbName, String password, String user) {
        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, user, password);
            if (conn == null){
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
            System.out.println(e.getMessage());
        }
    }
    public void Insert_rows(Connection conn,String tableName) {
        Statement statement;
        try{
            String name = inputHandler.getUserInput("Enter employee name:");
            String address = inputHandler.getUserInput("Enter employee address:");

            //using format method to auto concatenate strings in the query;
            String query = String.format("INSERT INTO %s (name,address) values('%s','%s');", tableName, name, address);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Employee created!!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void ReadRows(Connection conn, String tableName){
        Statement statement;
        ResultSet result;
        try{
            String query = String.format("SELECT * FROM %s ORDER BY EmpId ASC;", tableName);
            statement = conn.createStatement();
            result = statement.executeQuery(query);
            System.out.println("EmpId\t\t\tName\t\t\tAddress");
            System.out.println("-------------------------------------------");
            while(result.next()){
                System.out.print(result.getString("EmpId")+"\t\t\t\t");
                System.out.print(result.getString("name")+"\t\t\t\t");
                System.out.println(result.getString("address") + "\t\t\t");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void UpdateRecord(Connection conn, String tableName) {
        Statement statememt;

        try{
            ReadRows(conn , tableName);
            int EmpId = Integer.parseInt(inputHandler.getUserInput("Select an Employee id to update:"));


            String newName = inputHandler.getUserInput("Enter New Employee Name:");
            String newAddress = inputHandler.getUserInput("Enter New Employee Address");

            String query = String.format("UPDATE %s SET NAME = '%s', ADDRESS = '%s' WHERE EmpId = %d;", tableName, newName, newAddress, EmpId);

            System.out.println(query);
            statememt = conn.createStatement();
            statememt.executeUpdate(query);

            System.out.println("Employee has been updated Successfully");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void DeleteRecord(Connection conn, String tableName){
        Statement statement;
        try{
            ReadRows(conn, tableName);
            int EmpId = Integer.parseInt(inputHandler.getUserInput("Select a Employee id to delete"));

            String query = String.format("DELETE FROM %s WHERE EmpId = %d", tableName, EmpId);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Employee Deleted Successfully");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
