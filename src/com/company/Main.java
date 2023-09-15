package com.company;
import java.sql.Connection;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Functiondb db = new Functiondb();
        Connection conn = db.connectDb("CrudOps", "     ", "postgres");

        //db.CreateTable(conn, "employee");
        db.Insert_rows(conn, "employee", "John", "Texas_Us");
    }
    public Object getInput () {

    }
}