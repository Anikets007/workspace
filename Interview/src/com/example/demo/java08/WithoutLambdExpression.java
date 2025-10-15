package com.example.demo.java08;

public class WithoutLambdExpression implements VotingEligible {

	public static void main(String[] args) {
		//Without Lambda Expression
		VotingEligible eligible = new WithoutLambdExpression();
		System.out.println("Is 20 age eligible for voting.? -Without Lambda Expression: " + eligible.isValid(20));
		
		//With Lambda Expression
		
		VotingEligible voting = age -> age >= 18; 
		System.out.println("Is 20 age eligible for voting.?  - With Lambda : "+voting.isValid(20));
	}

	@Override
	public boolean isValid(int age) {
		return age >= 18;
	}
	
	
}

interface VotingEligible {

	public boolean isValid(int age);
}
