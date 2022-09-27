package com.example.demo2.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private final StudentRepository studentRepository;
    
	public StudentService(StudentRepository studentRepository){
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudentsRep(){
		return studentRepository.findAll();
	}

	public List<Student> getStudents() {
		return List.of(
			new Student(
				1L,
				"Mariam",
				"mariam@email.com",
				LocalDate.of(2000, Month.JANUARY, 5),
				21
			)
		);
	}

    
	public List<Student> getStudent2() {
		return List.of(
			new Student(
				1L,
				"Luka",
				"luke@email.com",
				LocalDate.of(2000, Month.JANUARY, 5),
				21
			)
		);
	}

    
	public List<Student> getStudent3() {
		return List.of(
			new Student(
				1L,
				"Keyl",
				"keyl@email.com",
				LocalDate.of(2000, Month.JANUARY, 5),
				21
			)
		);
	} 

	public List<Student> getStudent4() {
		return List.of(
			new Student(
				1L,
				"Keyl",
				"keyl@email.com",
				LocalDate.of(2000, Month.JANUARY, 5),
				21
			)
		);
	}
}
