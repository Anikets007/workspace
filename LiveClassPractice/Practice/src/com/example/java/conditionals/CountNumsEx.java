package com.example.java.conditionals;

public class CountNumsEx {
    public static void main(String[] args) {
        int number = 757726894;

        int count = 0;
        while(number > 0){
            int lastDigit = number % 10;

            if(lastDigit == 7){
                count++;
            }
            number = number / 10;
        }
        System.out.println("Count of 7's is: " + count);
    }
}
