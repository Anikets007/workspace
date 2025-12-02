package com.example.java.conditionals;

import java.util.Scanner;

public class LargestNumberEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // int a = scanner.nextInt();
        // int b = scanner.nextInt();
        // int c = scanner.nextInt();

        // int max = a;
        // if(max < b){
        // max = b;
        // }if(max < c){
        // max = c;
        // }
        // System.out.println("Largest number is: " + max);

        System.out.println(Math.max(3, Math.max(4, 6)));
    }
}