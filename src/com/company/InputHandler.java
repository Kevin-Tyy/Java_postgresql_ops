package com.company;
import java.util.Scanner;

public class InputHandler {
    public String getUserInput () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter employee name:\t");
        String name = scanner.nextLine();
        scanner.close();
        return name;
    }
}
