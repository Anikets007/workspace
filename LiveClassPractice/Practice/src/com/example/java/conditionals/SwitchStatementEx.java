package com.example.java.conditionals;

import java.util.Scanner;

public class SwitchStatementEx {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		//Fruit
		System.out.println("Enter the type of fruit");
		String fruit = scanner.next();
		printFruitesType(fruit);

		//Day
		System.out.println("Enter the day");
		int day = scanner.nextInt();
		printDayType(day);

		//Employee Department
		System.out.println("Please enter employee id");
		int empId = scanner.nextInt();
		
		System.out.println("Please enter employee department");
		String department = scanner.next();
		
		printEmppoyeeDepartment(empId, department);
	}

	
	private static void printEmppoyeeDepartment(int empId, String department) {
		switch (empId) {
		case 101:
			System.out.println("Aniket Narsikar");
			break;
		case 102:
			System.out.println("Sara Tabssum");
			break;
		case 103:
			switch (department) {
			case "IT":
				System.out.println("IT Department");
				break;
			case "Management":
				System.out.println("Management Department");
				break;

			default:
				System.out.println("No department found");
			}
		default:
			System.out.println("Enter correct id");
		}
	}

	private static void printFruitesType(String fruit) {
		
		//		if (fruit.equals("Mango")) {
//			System.out.println("King of fruit");
//		} else if (fruit.equals("Orange")) {
//			System.out.println("Just an orange");
//		} else if (fruit.equals("Apple")) {
//			System.out.println("An apple keep away the doctor");
//		} else {
//			System.out.println("Invalid fruit");
//		}

//		switch(expression) {
//		//cases 
//		case one:
//			//do something
//			break;
//		case two:
//			//do something / statement
//			break;
//		default:
//			//do something
//		}

//		switch(fruit) {
//		case "Mango":
//			System.out.println("King of fruit");
//			break;
//		case "Orange":
//			System.out.println("Just an orange");
//			break;
//		case "Apple":
//			System.out.println("An apple a day keeps doctor away");
//			break;
//		default:
//			System.out.println("Invalid fruit");
//		}
		switch (fruit) {
		case "Mango" -> System.out.println("King of fruit");
		case "Orange" -> System.out.println("Just an orange");
		case "Apple" -> System.out.println("An apple a day keeps doctor away");
		default -> System.out.println("Invalid fruit");
		}
	}

	private static void printDayType(int day) {
//		switch (day) {
//		case 1 -> System.out.println("Monday");
//		case 2 -> System.out.println("Tuesday");
//		case 3 -> System.out.println("Wednesday");
//		case 4 -> System.out.println("Thursday");
//		case 5 -> System.out.println("Friday");
//		case 6 -> System.out.println("Saturday");
//		case 7 -> System.out.println("Sunday");
//		default -> System.out.println("Invalid day");
//		}
		switch (day) {
		case 1, 2, 3, 4, 5 -> System.out.println("Weekdays");
		case 6, 7 -> System.out.println("Weekend");
		}
	}
}
