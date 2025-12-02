package com.example.java.conditionals;

import java.util.Scanner;

public class FibbonacciExample {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        int count = 2;
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        while (count <= number) {
            int temp = b;
            b = a + b;
            a =  temp;
            count++;
        }
        System.out.println("Fibbonacci number at position " + number + " is: " + b);
    }
}
