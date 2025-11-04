package com.example.demo.java.practice;

public class AbstractClassEx {

//	Account account = new Account("Aniket" , "SBI");
	
	public static void main(String[] args) {
		Account ba = new BankAccount("Aniket", "SBIII");
		ba.savingAccount("Aniket", "HDFC");
	}
}

abstract class Account {
	private String name;
	private String bank;

	public Account(String name, String bank) {
		this.name = name;
		this.bank = bank;
		System.out.println("Abstract class constructor logic");
	}

	abstract void savingAccount(String name, String bank);
}

class BankAccount extends Account {

	public BankAccount(String name, String bank) {
		super("Aniket", "SBI");
	}

	@Override
	void savingAccount(String name, String bank) {
		System.out.println("Saving account");
	}

}