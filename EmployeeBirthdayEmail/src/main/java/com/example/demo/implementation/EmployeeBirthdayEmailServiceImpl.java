package com.example.demo.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeBirthdayEmailService;

@Service
public class EmployeeBirthdayEmailServiceImpl implements EmployeeBirthdayEmailService {

	@Autowired
	JavaMailSender javaMailSender;

	@Override
	public List<Employee> getEmployeeBirthdayToday() {
		
		LocalDate today = LocalDate.now();
		int currentMonth = today.getMonthValue();
		int currentDay = today.getDayOfMonth();
		
		List<Employee> employees = Arrays.asList(
				new Employee(1, "Aniket S", "aniketnarsikar@gmail.com", LocalDate.of(1993, 3, 27)),
				new Employee(2, "Aniket Narsikar","aniketnarsikar143@gmail.com", LocalDate.of(1993, 3, 27)),
				new Employee(3,"Aniii ","mr.aniket.offical@gmail.com", LocalDate.of(1993, 3, 27))
				);
		List<Employee> birthdayEmployees = new ArrayList<>();
		for(Employee employee : employees) {
			
			LocalDate dob = employee.getEmployeeDOB();
			if(dob!= null && dob.getMonthValue() == currentMonth && dob.getDayOfMonth() == currentDay) {
				birthdayEmployees.add(employee);
			}
		}
		
		return birthdayEmployees;
	}

	@Override
	public void sendBirthdayEmail(Employee employee) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(employee.getEmail());
		message.setFrom("aniketnarsikar@gmail.com");
		message.setSubject("Happy Birthday, " + employee.getEmployeeName() + "!");
		message.setText(buildBirthdayMessage(employee.getEmployeeName()));
		javaMailSender.send(message);

		System.out.println("Birthday email sent to: " + employee.getEmployeeName() + " (" + employee.getEmail() + ")");

	}

	public String buildBirthdayMessage(String employeeName) {
		return "Dear " + employeeName + ",\n\n"
				+ "Wishing a very Happy Birthday! We hope you have a fantastice day.\n\n" + "Best Regards,\n"
				+ "Human Resource Team";
	}

}
