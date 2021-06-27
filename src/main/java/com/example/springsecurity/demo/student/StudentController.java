package com.example.springsecurity.demo.student;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

	private static final List<Student> students = Arrays.asList(new Student(1, "PK"), new Student(2, "DK"),
			new Student(3, "CK"));

	@GetMapping(path = "{studentId}")
	public Student getStudent(@PathVariable("studentId") Integer studentId) {
		return students.stream().filter(students -> studentId.equals(students.getStudentId())).findFirst()
				.orElseThrow(() -> new IllegalStateException("Studentid doesn't exist"));
	}
}
