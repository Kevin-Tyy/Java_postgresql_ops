package com.company;
import java.sql.Connection;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        DbFunctions db = new DbFunctions();
        InputHandler inputHandler = new InputHandler();
        SelectionHandler selectionHandler = new SelectionHandler();

        int choice = selectionHandler.selectMode();
        Connection conn = db.connectDb("CrudOps", "     ", "postgres");

        switch (choice) {
            case 1 -> db.Insert_rows(conn, "Employee");
            case 2 -> db.ReadRows(conn, "Employee");
            case 3 -> db.UpdateRecord(conn, "Employee");
            case 4 -> db.DeleteRecord(conn, "Employee");
            default -> System.out.println("Invalid choice.");
        }

        //db.CreateTable(conn, "employee");

        //db.Insert_rows(conn, "employee", name, address);
        //db.ReadRows(conn, "employee");
    }

    public void HandleSelection() {

    }
}