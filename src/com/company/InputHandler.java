package com.company;
import java.util.Scanner;

public class InputHandler {
    public String getUserInput (String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        String input = scanner.nextLine();

        return input;
    }
}
