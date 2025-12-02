package com.example.javatechie;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SetExample {

	public static void main(String[] args) {

		Student s1 = new Student(100, "Aniket", "Pune");
		Student s2 = new Student(100, "Aniket", "Pune");
		Set set = new HashSet<>();

		set.add(1);
		set.add(1);
		set.add("Aniket");

		System.out.println(set);
		System.out.println(s1.equals(s2));

		Set<Student> students = new HashSet<>();

		students.add(new Student(100, "Aniket", "Pune"));
		students.add(new Student(100, "Aniket", "Pune"));
//		students.add(new Student(100, "Annniket", "Pppune"));
		students.add(new Student(101, "Rakesh", "Mumbai"));

		System.out.println(students);

	}
}

class Student {
	private int id;
	private String name;
	private String address;

	public int hashCode() {
//		return id;
		return address.hashCode();
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(address, id, name);
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
//		if (getClass() != obj.getClass())
//			return false;
		if (obj instanceof Student) {
			Student obj1 = (Student) obj;
			return name.equals(obj1.getName()) && id == obj1.getId() && address.equals(obj1.getAddress());
		}
//		return Objects.equals(address, obj1.address) && id == obj1.id && Objects.equals(name, obj1.name);
		return false;
	}

	public Student(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

}