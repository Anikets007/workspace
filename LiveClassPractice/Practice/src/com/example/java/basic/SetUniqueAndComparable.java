package com.example.java.basic;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SetUniqueAndComparable {

	public static void main(String[] args) {

		Student s1 = new Student(1, "John", "Pune", "john@gmail.com");
		Student s2 = new Student(1, "John", "Pune", "john@gmail.com");

		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2)); // Bydefault internally it is comparing object references that is ==

		Set<Student> students = new HashSet<>();
//		Set<Student> students = new TreeSet<>();
		students.add(new Student(100, "Aniket", "Pune", "aniket@gmail.com"));
		students.add(new Student(100, "Aniket", "Pune", "aniket@gmail.com"));
		students.add(new Student(102, "John Wick", "California", "john@gmail.com"));
		students.add(new Student(103, "Will Smith", "Los Santos", "will@gmail.com"));
		students.add(new Student(104, "Diana Princess", "Los Angeles", "diana@gmail.com"));
		students.add(new Student(105, "Ravi Gupta", "Scottsdale", "gwen@gmail.com"));
		students.add(new Student(98, "akash", "Pune", "akash@gmail.com"));

		List<Student> studentList = students.stream().collect(Collectors.toList());
//		Collections.sort(studentList);
		Collections.sort(studentList, new IdComparator());
		
		System.out.println(students);
		System.out.println(studentList);
	}
}

//class Student implements Comparable<Student>{
class Student{
	private int id;
	private String name;
	private String address;
	private String emailId;

//	public int hashCode() {
////		return id;
//		return emailId.hashCode();
//	}
//	public boolean equals(Object obj) {
//		if (obj == null) {
//			return false;
//		}
//		if (this == obj) {
//			return true;
//		}
//
//		if (obj instanceof Student) {
//			Student students = (Student) obj;
//
//			return id == students.getId() && name.equals(students.getName()) && address.equals(students.getAddress())
//					&& emailId.equals(students.getEmailId());
//		}
//		return false;
//	}
	
	
//	@Override
//	public int compareTo(Student other) {
//		
////		if(id == other.getId()) {
////			return 0;
////		}else if(id > other.getId()) {
////			return 1;
////		}else {
////			return -1;
////		}
////		
////		return Integer.compare(this.id, other.getId());
////		return this.id - other.getId();
//		return name.compareTo(other.getName());
//	}

	public int hashCode() {
//		return id;
		return emailId.hashCode();
	}

	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}
		if (this == object) { //Student s = new Student(...); // s.equals(s); // true
			return true;
		}

		if (object instanceof Student) {
			Student students = (Student) object;
			return id == students.getId() && name == students.getName() && address == students.getAddress()
					&& emailId == students.getEmailId();
		}

		return false;
	}


	public Student(int id, String name, String address, String emailId) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.emailId = emailId;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

}