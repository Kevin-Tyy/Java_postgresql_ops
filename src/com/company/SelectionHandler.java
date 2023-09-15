package com.company;

import java.util.Scanner;

public class SelectionHandler {
    public int selectMode () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select an option:");
        System.out.println("1. Create");
        System.out.println("2. Read");
        System.out.println("3. Update");
        System.out.println("4. Delete");

        System.out.print("Enter your choice (1/2/3/4): ");
        return scanner.nextInt();
    }
}
