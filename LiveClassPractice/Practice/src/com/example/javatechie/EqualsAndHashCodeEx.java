package com.example.javatechie;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EqualsAndHashCodeEx {

	public static void main(String[] args) {
		Demo demo1 = new Demo(101, "Aniket");
		Demo demo2 = new Demo(101, "Aniket");
		
		System.out.println(demo1.hashCode());
		System.out.println(demo2.hashCode());
		
		Set<Demo> demos = new HashSet<>();
		
		demos.add(demo1);
		demos.add(demo2);
		
		System.out.println(demos);
	}
	
}

class Demo {
	private int id;
	private String name;

	public Demo(int id, String name) {
		this.id = id;
		this.name = name;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Demo other = (Demo) obj;
		return id == other.id && Objects.equals(name, other.name);
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Demo [id=" + id + ", name=" + name + "]";
	} 
	
	
	
}
