package com.example.demo.oops;

public class AbstarctVsInterface {

	public static void main(String[] args) {

//		Animal animal = new Dog("Bruno");
//		animal.sound();
		Dog dog = new Dog("Bruno");
		dog.sound();

	}
}

abstract class Animal {

	String name;

	public Animal(String name) {
		this.name = name;

		System.out.println("Animal (Parent) constructor is called");
	}

	public abstract void sound();
}

class Dog extends Animal {
	public Dog(String name) {
		super(name);
	}

	@Override
	public void sound() {
		System.out.println(name + " Bark...");

	}
}
