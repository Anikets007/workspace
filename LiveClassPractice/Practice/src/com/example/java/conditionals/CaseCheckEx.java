package com.example.java.conditionals;

import java.util.Scanner;

public class CaseCheckEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char c = scanner.next().trim().charAt(0);

        if(c >= 'a' && c <= 'z'){
            System.out.println(c + " is a lowercase letter.");
        }else{
            System.out.println(c + " is an UpperCase letter.");
        }
    }
}
