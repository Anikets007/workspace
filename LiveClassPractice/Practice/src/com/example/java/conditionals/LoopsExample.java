package com.example.java.conditionals;

public class LoopsExample {

    public static void main(String[] args) {
        // For Loop
        // for(initializaion : condition: increment/decrement){
        // System.out.println(print);
        // }

        for (int i = 0; i <= 10; i++) {
            System.out.println("Value of i: " + i);
        }

        // While Loop
        // condition
        // while (condition) {
        // Body;
        // increment/decrement;
        // }

        int j = 0; // for ( int i = initilization;
        while (j <= 10) { // i <= 10; Condition;
            System.out.println("Value of j: " + j); // Body
            j++; // increment/decrement
        }
        //Recomded
        //Use for loop when you know the number of iterations
        //Use while loop when you don't know the number of iterations

        // Do-While Loop
        // initialization;
        int k = 0;          
        do {                 // do {
            System.out.println("Value of k: " + k); // Body;
            k++;            // increment/decrement;
        } while (k <= 10);  // } while (condition); // it will execute at least once
    }
}
