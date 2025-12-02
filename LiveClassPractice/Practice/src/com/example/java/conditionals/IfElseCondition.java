package com.example.java.conditionals;

public class IfElseCondition {
    
    public static void main(String[] args) {
        int salary = 35000;

       System.out.println("Updated Salary: " + salaryIncrement(salary));
    }

    public static int salaryIncrement(int salary) {
        if(salary > 40000){
            salary = salary + 10000;
        }else if(salary > 45000){
            salary = salary + 20000;
        }else{
            salary = salary + 5000 ;
        }
        return salary;
    }
}
