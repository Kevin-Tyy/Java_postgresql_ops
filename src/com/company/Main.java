package com.company;
import java.sql.Connection;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        DbFunctions dbHandler = new DbFunctions();
        InputHandler inputHandler = new InputHandler();
        SelectionHandler selectionHandler = new SelectionHandler();

        int choice = selectionHandler.selectMode();

        Connection conn = dbHandler.connectDb("CrudOps", "     ", "postgres");

        switch (choice) {
            case 1 -> dbHandler.Insert_rows(conn, "Employee");
            case 2 -> dbHandler.ReadRows(conn, "Employee");
            case 3 -> dbHandler.UpdateRecord(conn, "Employee");
            case 4 -> dbHandler.DeleteRecord(conn, "Employee");
            default -> System.out.println("Invalid choice.");
        }

    }

    public void HandleSelection() {

    }
}